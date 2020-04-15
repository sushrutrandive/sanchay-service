package com.planner.calc.service.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.planner.calc.service.info.EPFCalcInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.DateUtil;




public class EPFCalculator implements Calculator<EPFCalcInfo> {

	@Override
	public EPFCalcInfo calculate(EPFCalcInfo info) {
		
		calculateMaturityAmount(info);		
		setMaturityAmount(info);
		
		// Yearly Contribution checking
		List<PFTransactionInfo> annualContribution  = new ArrayList<PFTransactionInfo>();
		PFTransactionInfo yearInfo  = new PFTransactionInfo();
		BigDecimal investedAmount = new BigDecimal(0);
		BigDecimal interestAmount = new BigDecimal(0);
		
		for(PFTransactionInfo pfInfo :  info.getTransactionList()) {
			if(pfInfo.isStart()) {
				 yearInfo  = new PFTransactionInfo();
				 
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
	
	private void setMaturityAmount(EPFCalcInfo info){
		
		LocalDate maturityDate = info.getMaturityAsOfDate();
		LocalDate currentAsOfDate = info.getCurrentAsOfDate();
		
		/*Optional<PFTransactionInfo> matchingMaturityDateObject = info.getTransactionList().stream()
															.filter(obj->	obj.getTransactionDate()
															.compareTo(maturityDate)==0).findFirst();*/
		PFTransactionInfo  pfMaturity = info.getTransactionList().get(info.getTransactionList().size()-1);
		double maturityAmount = AmountUtil.round(pfMaturity.getMaturityAmount(), 2);				
		info.setMaturityAmount(maturityAmount);
		
		PFTransactionInfo  pfCurrent = info.getTransactionList().stream()
				.filter(obj->	obj.getTransactionDate()
				.compareTo(currentAsOfDate)==0).findFirst().orElse(null);
		
		//PFTransactionInfo  pfCurrent = matchingCurrentDateObject.get();
		double currentAmt = 0.0d;
		if(pfCurrent==null){
			if(info.getCurrentAsOfDate().compareTo(maturityDate)>0)
				currentAmt = maturityAmount;
			else 
				currentAmt = info.getBalance();
		}
		else{
			pfCurrent.getMaturityAmount().setScale(2, RoundingMode.HALF_UP);	
			currentAmt =  AmountUtil.round(pfCurrent.getMaturityAmount(), 2);		
		}
					
		info.setCurrentEPFValue(currentAmt);
	}
	
	private void calculateMaturityAmount(EPFCalcInfo info){
		List<PFTransactionInfo> list = info.getTransactionList();
		
		BigDecimal totalAccuredInterest = new BigDecimal(0);
		BigDecimal openingBalance = new BigDecimal(info.getBalance());
		BigDecimal yearlyAmount = new BigDecimal(0);
		
		
		for(PFTransactionInfo transactionInfo : list){
			// New Balance
			openingBalance= openingBalance.setScale(2, RoundingMode.HALF_UP);	
			transactionInfo.setOpeningBalance(openingBalance);
			
			if(transactionInfo.getTransactionDate().getMonth() == Month.APRIL ) {
				transactionInfo.setStart(true);
			}
			
			
			BigDecimal rate= new BigDecimal(transactionInfo.getInterestRate().doubleValue());
			rate = rate.divide(new BigDecimal(1200),new MathContext(6, RoundingMode.HALF_UP));
			BigDecimal result =  openingBalance.multiply(rate);
			result= result.setScale(2, RoundingMode.HALF_UP);	
			totalAccuredInterest = totalAccuredInterest.add(result);
			openingBalance = openingBalance.add(transactionInfo.getTransactionAmount());
			
			yearlyAmount =  yearlyAmount.add(transactionInfo.getTransactionAmount());
			yearlyAmount = yearlyAmount.setScale(2, RoundingMode.HALF_UP);				
			
			BigDecimal maturityAmt = openingBalance.add(totalAccuredInterest);
			transactionInfo.setMaturityAmount(maturityAmt);
			transactionInfo.setInterestAmount(result);
			if((transactionInfo.getTransactionDate().getMonth() == Month.MARCH && transactionInfo.getTransactionDate().getDayOfMonth()==31)){ 
				// This is march end and now post the accrued interest to balance
				BigDecimal interestComp = new BigDecimal(maturityAmt.doubleValue());
				interestComp = interestComp.setScale(2, RoundingMode.HALF_UP);				
				openingBalance = new BigDecimal(interestComp.doubleValue());	
				totalAccuredInterest= totalAccuredInterest.setScale(2, RoundingMode.HALF_UP);	
				transactionInfo.setAccuredInterest(totalAccuredInterest);
				totalAccuredInterest = new BigDecimal(0);
				transactionInfo.setEnd(true);
				
			}
			transactionInfo.setClosingBalance(openingBalance);
		
		}
		//info.setTransactionList(transactionList);
		
	}

	private double calculateInterest(BigDecimal balance1, BigDecimal principal1, BigDecimal rate1, LocalDate balanceDate1,
			LocalDate endDate1) {
		BigDecimal totalAccuredInterest = new BigDecimal(0);
		BigDecimal balance = new BigDecimal(balance1.doubleValue());
		BigDecimal principal = new BigDecimal(principal1.doubleValue());
		BigDecimal rate = new BigDecimal(rate1.doubleValue());
		LocalDate balanceDate = LocalDate.from(balanceDate1);
		LocalDate endDate = LocalDate.from(endDate1);
		
		rate = rate.divide(new BigDecimal(1200),new MathContext(6, RoundingMode.HALF_UP));
		while(endDate.compareTo(balanceDate)>=0){
			// Calculate the interest Amount
			
			BigDecimal result =  balance.multiply(rate);
			totalAccuredInterest = totalAccuredInterest.add(result);
			balance = balance.add(principal);	
			balanceDate=balanceDate.plusMonths(1);	
			balanceDate = balanceDate.withDayOfMonth( balanceDate.lengthOfMonth());
			
			if(balanceDate.getMonth() == Month.MARCH && balanceDate.getDayOfMonth()==31){ 
				// This is march end and now post the accrued interest to balance
				BigDecimal interestComp = new BigDecimal(totalAccuredInterest.doubleValue());
				interestComp = interestComp.setScale(2, RoundingMode.HALF_UP);				
				balance = balance.add(interestComp);
				totalAccuredInterest = new BigDecimal(0);
			}
		
			
		}
		balance = balance.add(totalAccuredInterest); // If Maturity date is not on year end
		double amount = balance.setScale(2, RoundingMode.HALF_UP).doubleValue();
		return amount;
	}
	
	public static void main(String[] args) {
		/*LocalDate balanceDate = LocalDate.now();
		
		if (balanceDate.getMonth() == Month.JANUARY|| balanceDate.getMonth() == Month.FEBRUARY
				|| balanceDate.getMonth() == Month.MARCH) {
			balanceDate=balanceDate.withYear(balanceDate.getYear()-1);
		}
		balanceDate = balanceDate.withMonth(Month.MARCH.getValue());
		balanceDate = balanceDate.withDayOfMonth(31);
		
		for(int i=0;i<12;i++){
			balanceDate=balanceDate.plusMonths(1);
			
			int maxDate = balanceDate.lengthOfMonth();
			balanceDate = balanceDate.withDayOfMonth(maxDate);
			System.out.println(balanceDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		}
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.get(Calendar.DATE) + " : "+(cal.get(Calendar.MONTH)+1) + " : "+cal.get(Calendar.YEAR));*/
		
		BigDecimal newAmount = new BigDecimal(10.02);
		newAmount = newAmount.setScale(0, RoundingMode.HALF_UP);	
		System.out.println(newAmount.doubleValue());
	}

}
