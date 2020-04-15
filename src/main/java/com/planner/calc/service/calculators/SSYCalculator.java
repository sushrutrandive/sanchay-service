package com.planner.calc.service.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.SSYCalcInfo;
import com.planner.calc.service.info.SSYTransactionInfo;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.DateUtil;
import com.planner.calc.service.util.Constants.PPF_CONTRIBUTION_FREQUENCY;
import com.planner.calc.service.util.Constants.SSY_CONTRIBUTION_FREQUENCY;

public class SSYCalculator implements Calculator<SSYCalcInfo> {
	
	@Override
	public SSYCalcInfo calculate(SSYCalcInfo info) {
		// TODO Auto-generated method stub

		calculateMaturityAmount(info);
		setMaturityAmount(info);
		List<SSYTransactionInfo> annualContribution  = new ArrayList<SSYTransactionInfo>();
		SSYTransactionInfo yearInfo  = new SSYTransactionInfo();
		BigDecimal investedAmount = new BigDecimal(0);
		BigDecimal interestAmount = new BigDecimal(0);
		
		for(SSYTransactionInfo pfInfo :  info.getTransactionList()) {
			if(pfInfo.isStart()) {
				 yearInfo  = new SSYTransactionInfo();
				 
				 yearInfo.setOpeningBalance(pfInfo.getOpeningBalance());
				 investedAmount = new BigDecimal(0);
				 interestAmount = new BigDecimal(0);
				 yearInfo.setFinanceYear(DateUtil.getFinancialYear(pfInfo.getTransactionDate()));
			}
			
			investedAmount =  investedAmount.add(pfInfo.getTransactionAmount());
			interestAmount =  interestAmount.add(pfInfo.getInterestAmount());
			
			if(pfInfo.isEnd()) {
				yearInfo.setClosingBalance(pfInfo.getClosingBalance());
				yearInfo.setInterestAmount(interestAmount);
				yearInfo.setTransactionAmount(investedAmount);
				yearInfo.setTransactionDate(pfInfo.getTransactionDate());
				annualContribution.add(yearInfo);
				
			}
			
			
		}
		
		info.setTransactionList(annualContribution);
		return info;
	}

	private void calculateMaturityAmount(SSYCalcInfo info) {
		List<SSYTransactionInfo> list = info.getTransactionList();

		BigDecimal totalAccuredInterest = new BigDecimal(0);
		BigDecimal openingBalance = new BigDecimal(info.getBalance());
		openingBalance= openingBalance.setScale(2, RoundingMode.HALF_UP);	
		BigDecimal principalAmount = new BigDecimal(info.getBalance());
		BigDecimal yearlyAmount = new BigDecimal(0);
		SSY_CONTRIBUTION_FREQUENCY contributionFrequency = SSY_CONTRIBUTION_FREQUENCY.fromInteger(info.getContributionFrequency().getValue());
		boolean isAnnual = (SSY_CONTRIBUTION_FREQUENCY.ANNUALLY_END_OF_FY == contributionFrequency|| SSY_CONTRIBUTION_FREQUENCY.ANNUALLY_START_OF_FY== contributionFrequency) ? true :false;
		SSYTransactionInfo last = list.get(list.size()-1);
		last.setEnd(true);
		for (SSYTransactionInfo transactionInfo : list) {
			// New Balance			
			BigDecimal minimumBalance = getMinimumBalance(transactionInfo, openingBalance, contributionFrequency);
			transactionInfo.setOpeningBalance(openingBalance);

			if (transactionInfo.getTransactionDate().getMonth() == Month.APRIL) {
				transactionInfo.setStart(true);
			}

			BigDecimal rate = new BigDecimal(transactionInfo.getInterestRate().doubleValue());			
			rate = rate.divide(new BigDecimal(1200), new MathContext(6, RoundingMode.HALF_UP));
			BigDecimal result = minimumBalance.multiply(rate);
			result = result.setScale(2, RoundingMode.HALF_UP);
			totalAccuredInterest = totalAccuredInterest.add(result);
			
		
			openingBalance = openingBalance.add(transactionInfo.getTransactionAmount());

			yearlyAmount = yearlyAmount.add(transactionInfo.getTransactionAmount());
			yearlyAmount = yearlyAmount.setScale(2, RoundingMode.HALF_UP);

			BigDecimal maturityAmt = openingBalance.add(totalAccuredInterest);
			transactionInfo.setMaturityAmount(maturityAmt);
			transactionInfo.setInterestAmount(result);
			if ((transactionInfo.getTransactionDate().getMonth() == Month.MARCH) || transactionInfo.isEnd()) {
				// This is march end and now post the accrued interest to balance
				BigDecimal interestComp = new BigDecimal(maturityAmt.doubleValue());
				interestComp = interestComp.setScale(2, RoundingMode.HALF_UP);
				openingBalance = new BigDecimal(interestComp.doubleValue());
				totalAccuredInterest = totalAccuredInterest.setScale(2, RoundingMode.HALF_UP);
				transactionInfo.setAccuredInterest(totalAccuredInterest);
				totalAccuredInterest = new BigDecimal(0);
				transactionInfo.setEnd(true);

			}
			transactionInfo.setClosingBalance(openingBalance);

		}
		// info.setTransactionList(transactionList);

	}
	
	private BigDecimal getMinimumBalance (SSYTransactionInfo transactionInfo , BigDecimal openingBalance,SSY_CONTRIBUTION_FREQUENCY contributionFrequency) {
		boolean isMonthly = (SSY_CONTRIBUTION_FREQUENCY.MONTHLY_AFTER_CUT_OFF_DATE == contributionFrequency|| SSY_CONTRIBUTION_FREQUENCY.MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE== contributionFrequency) ? true :false;
		
		BigDecimal result = new BigDecimal(openingBalance.doubleValue());
		
		if(isMonthly && transactionInfo.getTransactionDate().getDayOfMonth() < 11) {
			result  =result.add(transactionInfo.getTransactionAmount());
			
		}else if(!isMonthly && transactionInfo.getTransactionDate().getMonth() == Month.APRIL ) {// Start Of Year
			
			result  =result.add(transactionInfo.getTransactionAmount());			
		}
		result = result.setScale(2, RoundingMode.HALF_UP);
		return result;
	}

	private void setMaturityAmount(SSYCalcInfo info) {

		LocalDate maturityDate = info.getMaturityAsOfDate();
		LocalDate currentAsOfDate = info.getCurrentAsOfDate();
		
		Predicate<SSYTransactionInfo> transactionDatePredicate = (SSYTransactionInfo item)->{
			
			return currentAsOfDate.getMonth() == item.getTransactionDate().getMonth() && currentAsOfDate.getYear() == item.getTransactionDate().getYear();
			
		};

		/*
		 * Optional<PFTransactionInfo> matchingMaturityDateObject =
		 * info.getTransactionList().stream() .filter(obj-> obj.getTransactionDate()
		 * .compareTo(maturityDate)==0).findFirst();
		 */
		SSYTransactionInfo pfMaturity = info.getTransactionList().get(info.getTransactionList().size() - 1);
		double maturityAmount = AmountUtil.round(pfMaturity.getMaturityAmount(), 2);
		info.setMaturityAmount(maturityAmount);

		SSYTransactionInfo pfCurrent = info.getTransactionList().stream()
				.filter(transactionDatePredicate).findFirst().orElse(null);

		// PFTransactionInfo pfCurrent = matchingCurrentDateObject.get();
		double currentAmt = 0.0d;
		if (pfCurrent == null) {
			if (info.getCurrentAsOfDate().compareTo(maturityDate) > 0)
				currentAmt = maturityAmount;
			else
				currentAmt = info.getBalance();
		} else {
			pfCurrent.getMaturityAmount().setScale(2, RoundingMode.HALF_UP);
			currentAmt = AmountUtil.round(pfCurrent.getMaturityAmount(), 2);
		}

		info.setCurrentSSYValue(currentAmt);
	}

}
