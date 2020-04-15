package com.planner.calc.service.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.dao.StaticResources;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.PPFCalcInfo;
import com.planner.calc.service.info.SSYCalcInfo;
import com.planner.calc.service.info.SSYTransactionInfo;
import com.planner.calc.service.services.InterestRateService;
import com.planner.calc.service.services.SSYTransactionService;
import com.planner.calc.service.util.DateUtil;
import com.planner.calc.service.util.Constants.PPF_CONTRIBUTION_FREQUENCY;
import com.planner.calc.service.util.Constants.PPF_EXTENSION_OPTIONS;
import com.planner.calc.service.util.Constants.SSY_CONTRIBUTION_FREQUENCY;

@Service
public class SSYTransactionServiceImpl implements SSYTransactionService {
	@Autowired
	private StaticResources staticResource;
	@Autowired
	private InterestRateService interestRateService;
	
	@Override
	public List<SSYTransactionInfo> createSSYTransactionList(SSYCalcInfo calcInfo) {
		
		LocalDate accountOpenDate = DateUtil.convertIntoLocalDate(calcInfo.getStartDate());
		LocalDate depositEndDate =accountOpenDate.plusYears(15);
		LocalDate startDate = DateUtil.getAprilDateForCurrentFY(30);
		LocalDate endDate = accountOpenDate.plusYears(calcInfo.getTerms());
		

		List<InterestRateChangeInfo> changes = this.staticResource.getInterestRateChangeDetails(DateUtil.asDate(startDate));
		InterestRateChangeInfo latestRate = this.staticResource.getInterestRateChange();

		List<SSYTransactionInfo> transactionList = new ArrayList<>();
		boolean firstTime = false;
		BigDecimal employeeContribution = new BigDecimal(calcInfo.getContributionAmount());
		SSY_CONTRIBUTION_FREQUENCY contributionFrequency = SSY_CONTRIBUTION_FREQUENCY.fromInteger(calcInfo.getContributionFrequency().getValue());
		
		
		
		while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {

			LocalDate transactionDate = getSSYTransactionDate(calcInfo, startDate);
			double interestRate = interestRateService.getSSYInterestRateForPeriod(startDate, changes, latestRate);
			SSYTransactionInfo transactionInfo = new SSYTransactionInfo();
			transactionInfo.setTransactionDate(transactionDate);
			transactionInfo.setInterestRate(new BigDecimal(interestRate));

			employeeContribution = getTransactionAmount(depositEndDate,startDate, employeeContribution, firstTime,0);
			

			if (SSY_CONTRIBUTION_FREQUENCY.MONTHLY_AFTER_CUT_OFF_DATE == contributionFrequency
					|| SSY_CONTRIBUTION_FREQUENCY.MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE == contributionFrequency) {

				transactionInfo.setTransactionAmount(employeeContribution);

			} else if (SSY_CONTRIBUTION_FREQUENCY.ANNUALLY_END_OF_FY == contributionFrequency) {

				if (transactionDate.getMonth() == Month.MARCH) {
					transactionInfo.setTransactionAmount(employeeContribution);

				} else {
					transactionInfo.setTransactionAmount(new BigDecimal(0));
				}
				// startDate = startDate.plusMonths(12);
				// startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

			} else if (SSY_CONTRIBUTION_FREQUENCY.ANNUALLY_START_OF_FY == contributionFrequency) {

				if (transactionDate.getMonth() == Month.APRIL) {
					transactionInfo.setTransactionAmount(employeeContribution);

				} else {
					transactionInfo.setTransactionAmount(new BigDecimal(0));
				}
				// startDate = startDate.plusMonths(12);
				// startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

			}

			startDate = startDate.plusMonths(1);
			startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

			transactionList.add(transactionInfo);
			firstTime = true;

		}
		/*if (isAnnual) {
			if (endDate.getMonth() != Month.MARCH) {
				endDate = LocalDate.of(endDate.getYear() + 1, Month.MARCH, 31);
				// endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());

				double interestRate = interestRateService.getPPFInterestRateForPeriod(endDate, changes, latestRate);
				SSYTransactionInfo transactionInfo = new SSYTransactionInfo();
				transactionInfo.setTransactionDate(endDate);
				transactionInfo.setInterestRate(new BigDecimal(interestRate));
				transactionInfo.setTransactionAmount(new BigDecimal(0));

				transactionList.add(transactionInfo);
			}

		} else {
			while (endDate.getMonth() != Month.MARCH) {

				endDate = endDate.plusMonths(1);
				// endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());

				double interestRate = interestRateService.getPPFInterestRateForPeriod(endDate, changes, latestRate);
				SSYTransactionInfo transactionInfo = new SSYTransactionInfo();
				transactionInfo.setTransactionDate(endDate);
				transactionInfo.setInterestRate(new BigDecimal(interestRate));
				transactionInfo.setTransactionAmount(new BigDecimal(0));

				transactionList.add(transactionInfo);

			}

		}*/
		// System.out.println(transactionList);
		transactionList.get(0).setStart(true);
		return transactionList;
	}

	private LocalDate getSSYTransactionDate(SSYCalcInfo calcInfo, LocalDate localDate) {

		int date = 1;
		Month month = localDate.getMonth();
		int year = localDate.getYear();

		switch (SSY_CONTRIBUTION_FREQUENCY.fromInteger(calcInfo.getContributionFrequency().getValue())) {
		case MONTHLY_AFTER_CUT_OFF_DATE:
			date = 12;
			break;
		case MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE:
			date = 2;
			break;
		case ANNUALLY_END_OF_FY:
			date = 28;
			// year = year+1;
			// month = Month.MARCH;
			break;
		case ANNUALLY_START_OF_FY:
			date = 2;
			// month = Month.APRIL;
			break;
		default:
			break;
		}

		return LocalDate.of(year, month, date);

	}
	
	private BigDecimal getTransactionAmount(LocalDate depositEndDate,LocalDate transactionDate, BigDecimal employeeContribution,
			boolean firstTime, double expectedReturn) {
		
		if(transactionDate.isAfter(depositEndDate))
			return new BigDecimal(0);
		if (!firstTime) {
			return new BigDecimal(employeeContribution.doubleValue());
		} else if (transactionDate.getMonth() == Month.APRIL) {
			BigDecimal newAmount = employeeContribution.multiply(new BigDecimal(expectedReturn))
					.divide(new BigDecimal(100));
			newAmount = newAmount.add(employeeContribution);
			newAmount = newAmount.setScale(0, RoundingMode.HALF_UP);
			return newAmount;

		} else {
			return new BigDecimal(employeeContribution.doubleValue());
		}

	}

}
