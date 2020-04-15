package com.planner.calc.service.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.dao.StaticResources;
import com.planner.calc.service.info.EPFCalcInfo;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.PPFCalcInfo;
import com.planner.calc.service.services.InterestRateService;
import com.planner.calc.service.services.PFTransactionService;
import com.planner.calc.service.util.Constants.PPF_CONTRIBUTION_FREQUENCY;
import com.planner.calc.service.util.Constants.PPF_EXTENSION_OPTIONS;
import com.planner.calc.service.util.DateUtil;

@Service
public class PFTransactionServiceImpl implements PFTransactionService {

	@Autowired
	private StaticResources staticResource;
	@Autowired
	private InterestRateService interestRateService;

	@Override
	public List<PFTransactionInfo> createEPFTransactionList(EPFCalcInfo info) {

		LocalDate startDate = DateUtil.getAprilDateForCurrentFY(30);

		LocalDate endDate = DateUtil.getMonthEndDate(info.getEndDate());

		List<InterestRateChangeInfo> changes = this.staticResource
				.getInterestRateChangeDetails(DateUtil.asDate(startDate));
		InterestRateChangeInfo latestRate = this.staticResource.getInterestRateChange();

		List<PFTransactionInfo> transactionList = new ArrayList<>();
		boolean firstTime = false;
		BigDecimal employeeContribution = new BigDecimal(info.getEmployeeContributionAmount());
		while (endDate.compareTo(startDate) >= 0) {

			double interestRate = interestRateService.getEPFInterestRateForPeriod(startDate, changes, latestRate);
			PFTransactionInfo transactionInfo = new PFTransactionInfo();
			transactionInfo.setTransactionDate(startDate);
			transactionInfo.setInterestRate(new BigDecimal(interestRate));

			employeeContribution = getTransactionAmount(startDate, employeeContribution, firstTime,
					info.getExpectedGrowth());
			transactionInfo.setTransactionAmount(employeeContribution);

			startDate = startDate.plusMonths(1);
			startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

			transactionList.add(transactionInfo);
			firstTime = true;
		}

		// Push transactions with zero amount till 31 march of current year

		while (endDate.getMonth() != Month.MARCH) {

			endDate = endDate.plusMonths(1);
			endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());

			double interestRate = interestRateService.getEPFInterestRateForPeriod(endDate, changes, latestRate);
			PFTransactionInfo transactionInfo = new PFTransactionInfo();
			transactionInfo.setTransactionDate(endDate);
			transactionInfo.setInterestRate(new BigDecimal(interestRate));
			transactionInfo.setTransactionAmount(new BigDecimal(0));

			transactionList.add(transactionInfo);

		}
		
		
		transactionList.get(0).setStart(true);
		// TODO Auto-generated method stub
		return transactionList;
	}

	@Override
	public List<PFTransactionInfo> createPPFTransactionList(PPFCalcInfo calcInfo) {
		
		//LocalDate currentFYFirstDate = DateUtil.getAprilDateForCurrentFY(1);
		LocalDate accountStartDate = DateUtil.convertIntoLocalDate(calcInfo.getStartDate());
		LocalDate startDate = DateUtil.getAprilDateForCurrentFY(1);
		if(accountStartDate.isAfter(startDate)) {
			startDate =accountStartDate;
		}
		LocalDate currentFYEndDate =  DateUtil.getLastDateOfCurrentFinancialYear(calcInfo.getStartDate()); 
		LocalDate endDate  =  currentFYEndDate.plusYears(calcInfo.getTerms());
		LocalDate originalEndDate  =  currentFYEndDate.plusYears(calcInfo.getOriginalTerms());
		
		List<InterestRateChangeInfo> changes = this.staticResource
				.getInterestRateChangeDetails(DateUtil.asDate(startDate));
		InterestRateChangeInfo latestRate = this.staticResource.getInterestRateChange();
		
		List<PFTransactionInfo> transactionList = new ArrayList<>();
		boolean firstTime = false;
		BigDecimal employeeContribution = new BigDecimal(calcInfo.getContributionAmount());
		PPF_CONTRIBUTION_FREQUENCY contributionFrequency = PPF_CONTRIBUTION_FREQUENCY.fromInteger(calcInfo.getContributionFrequency().getValue());
		PPF_EXTENSION_OPTIONS extentionOption = PPF_EXTENSION_OPTIONS.fromInteger(calcInfo.getExtensionPeriodOption().getValue());
		boolean isAnnual = (PPF_CONTRIBUTION_FREQUENCY.ANNUALLY_END_OF_FY == contributionFrequency|| PPF_CONTRIBUTION_FREQUENCY.ANNUALLY_START_OF_FY== contributionFrequency) ? true :false;
		boolean extensionWithoutContribution = extentionOption == PPF_EXTENSION_OPTIONS.EXTENSION_WITHOUT_FRESH_CONTRIBUTION;
		while(startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
			
			LocalDate transactionDate = getPPFTransactionDate(calcInfo, startDate);
			double interestRate = interestRateService.getPPFInterestRateForPeriod(startDate, changes, latestRate);
			PFTransactionInfo transactionInfo = new PFTransactionInfo();
			transactionInfo.setTransactionDate(transactionDate);
			transactionInfo.setInterestRate(new BigDecimal(interestRate));

			employeeContribution = getTransactionAmount(startDate, employeeContribution, firstTime,
					calcInfo.getExpectedGrowth());
			if(extensionWithoutContribution && transactionDate.isAfter(originalEndDate)) {
				employeeContribution = new BigDecimal(0);
			}
			
			
			
			if(PPF_CONTRIBUTION_FREQUENCY.MONTHLY_AFTER_CUT_OFF_DATE == contributionFrequency ||
					PPF_CONTRIBUTION_FREQUENCY.MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE == contributionFrequency	) {
				
				transactionInfo.setTransactionAmount(employeeContribution);
				
			}else if (PPF_CONTRIBUTION_FREQUENCY.ANNUALLY_END_OF_FY == contributionFrequency) {
				
				if(transactionDate.getMonth() == Month.MARCH) {
					transactionInfo.setTransactionAmount(employeeContribution);
				
				}else {
					transactionInfo.setTransactionAmount(new BigDecimal(0));
				}
				//startDate = startDate.plusMonths(12);
				//startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
				
				
			}else if (PPF_CONTRIBUTION_FREQUENCY.ANNUALLY_START_OF_FY == contributionFrequency) {
				
				if(transactionDate.getMonth() == Month.APRIL) {
					transactionInfo.setTransactionAmount(employeeContribution);
				
				}else {
					transactionInfo.setTransactionAmount(new BigDecimal(0));
				}
				//startDate = startDate.plusMonths(12);
				//startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
				
			}
			
			startDate = startDate.plusMonths(1);
			startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

			transactionList.add(transactionInfo);
			firstTime = true;
			
			
			
		}
		if(isAnnual) {
			if(endDate.getMonth() != Month.MARCH) {
				endDate = LocalDate.of(endDate.getYear()+1, Month.MARCH, 31);
				//endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());

				double interestRate = interestRateService.getPPFInterestRateForPeriod(endDate, changes, latestRate);
				PFTransactionInfo transactionInfo = new PFTransactionInfo();
				transactionInfo.setTransactionDate(endDate);
				transactionInfo.setInterestRate(new BigDecimal(interestRate));
				transactionInfo.setTransactionAmount(new BigDecimal(0));

				transactionList.add(transactionInfo);
			}
			
		}else {
			while (endDate.getMonth() != Month.MARCH) {

				endDate = endDate.plusMonths(1);
				//endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());

				double interestRate = interestRateService.getPPFInterestRateForPeriod(endDate, changes, latestRate);
				PFTransactionInfo transactionInfo = new PFTransactionInfo();
				transactionInfo.setTransactionDate(endDate);
				transactionInfo.setInterestRate(new BigDecimal(interestRate));
				transactionInfo.setTransactionAmount(new BigDecimal(0));

				transactionList.add(transactionInfo);

			}
			
		}
		//System.out.println(transactionList);
		transactionList.get(0).setStart(true);
		return transactionList;
	}
	
	private LocalDate getPPFTransactionDate(PPFCalcInfo calcInfo,LocalDate localDate) {
		
		int date =1;
		Month month = localDate.getMonth();
		int year = localDate.getYear();
		
		switch (PPF_CONTRIBUTION_FREQUENCY.fromInteger(calcInfo.getContributionFrequency().getValue())) {
			case MONTHLY_AFTER_CUT_OFF_DATE:
				date =7;
				break;
			case MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE:
				date =2;
				break;
			case ANNUALLY_END_OF_FY:
				date =28;
				//year =  year+1; 
				//month = Month.MARCH;
				break;
			case ANNUALLY_START_OF_FY:
				date =2;
				//month = Month.APRIL;
				break;
		default:
			break;
		}
		
		return LocalDate.of(year, month, date);
		
	}

	/*private double getEPFInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,
			InterestRateChangeInfo latestRate) {
		double rate = latestRate.getEpfRate();
		Date date = DateUtil.asDate(transactionDate);
		for (InterestRateChangeInfo info : changes) {
			if (DateUtil.between(date, info.getStartDate(), info.getEndDate())) {
				rate = info.getEpfRate();
				break;
			}
		}
		return rate;
	}
	
	private double getPPFInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,
			InterestRateChangeInfo latestRate) {
		double rate = latestRate.getPpfRate();
		Date date = DateUtil.asDate(transactionDate);
		for (InterestRateChangeInfo info : changes) {
			if (DateUtil.between(date, info.getStartDate(), info.getEndDate())) {
				rate = info.getEpfRate();
				break;
			}
		}
		return rate;
	}
	
	*/

	private BigDecimal getTransactionAmount(LocalDate transactionDate, BigDecimal employeeContribution,
			boolean firstTime, double expectedReturn) {

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
