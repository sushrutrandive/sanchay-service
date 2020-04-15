package com.planner.calc.service.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.planner.calc.service.exceptions.RequiredParametersMissingException;
import com.planner.calc.service.info.DatePeriodInfo;
import com.planner.calc.service.info.FDTransactionInfo;
import com.planner.calc.service.info.FixedDepositCalcInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.util.Constants.INTEREST_CALC_MEHOD;
import com.planner.calc.service.util.DateUtil;


public class FixedDepositCalculator implements Calculator<FixedDepositCalcInfo>{
	
	public static Map<Integer,INTEREST_CALC_MEHOD> INTEREST_CALC_MAP= new HashMap<>();
	static{
		INTEREST_CALC_MAP.put(2, INTEREST_CALC_MEHOD.CONMPOND_MONTHLY);
		INTEREST_CALC_MAP.put(3, INTEREST_CALC_MEHOD.CONMPOND_QUARTERLY);
		INTEREST_CALC_MAP.put(4, INTEREST_CALC_MEHOD.CONMPOND_SEMI_ANNUALLY);
		INTEREST_CALC_MAP.put(5, INTEREST_CALC_MEHOD.CONMPOND_ANNUALLY);
	}
	
	public FixedDepositCalcInfo calculate(FixedDepositCalcInfo info) throws RequiredParametersMissingException{
			
		if(info.getInterestCalcMethod().getValue() !=1){
			
			DatePeriodInfo datePeriod = DateUtil.getDaysBetweenTwoDates(info.getStartDate(), info.getEndDate());
			double maturityAmount1 = calculateCompoundInterest(info, datePeriod);
			info.setMaturityAmount(maturityAmount1);
			
			if(info.getStartDate().before(new Date())) {
				DatePeriodInfo currentDatePeriod = DateUtil.getDaysBetweenTwoDates(info.getStartDate(), new Date());
				double currentValue = calculateCompoundInterest(info, currentDatePeriod);
				info.setCurrentValue(currentValue);
			}
				
			
			
			
			// Set Transaction Details
			for (int i = 0; i < datePeriod.getYears(); i++) {
				int year = i + 1;
				DatePeriodInfo date   =  new DatePeriodInfo(year, 0);
				double amount = calculateCompoundInterest(info, date);
				Calendar start = Calendar.getInstance();
				start.setTime(info.getStartDate());
				start.set(Calendar.HOUR_OF_DAY, 0);
				start.set(Calendar.MINUTE, 0);
				start.set(Calendar.SECOND,0);
				LocalDate startLocalDate = LocalDate.of(start.get(Calendar.YEAR), start.get(Calendar.MONTH)+1, start.get(Calendar.DATE));
				startLocalDate = startLocalDate.plusYears(year); 
				FDTransactionInfo fdInfo = new FDTransactionInfo(startLocalDate, amount);
				info.addTransactionToList(fdInfo);				
			}
			
			if(datePeriod.getDays() >0) {
				Calendar end = Calendar.getInstance();
				end.setTime(info.getEndDate());
				end.set(Calendar.HOUR_OF_DAY, 0);
				end.set(Calendar.MINUTE, 0);
				end.set(Calendar.SECOND,0);
				LocalDate endDate = LocalDate.of(end.get(Calendar.YEAR), end.get(Calendar.MONTH)+1, end.get(Calendar.DATE));
				FDTransactionInfo fdInfo = new FDTransactionInfo(endDate, info.getMaturityAmount());
				info.addTransactionToList(fdInfo);		
			}
			
				
			
		
		}
		info.setInvestedAmount(info.getPrincipalAmount());
				
		return info;
		
	}

	private double calculateCompoundInterest(FixedDepositCalcInfo info, DatePeriodInfo datePeriod) {
		BigDecimal principal = new BigDecimal(info.getPrincipalAmount());
		BigDecimal interest = new BigDecimal(info.getInterestRate()).divide(new BigDecimal(100),new MathContext(6,RoundingMode.HALF_UP));
		BigDecimal interestCalcFactor = new BigDecimal(getCompoundFacor(info.getInterestCalcMethod()));
		BigDecimal factor = new BigDecimal(1).add(interest.divide(interestCalcFactor,new MathContext(6,RoundingMode.HALF_UP)));
		
		BigDecimal daysFactor =new BigDecimal(datePeriod.getYears());
		BigDecimal fac =new BigDecimal(0);
		if(datePeriod.getDays()>0){
			BigDecimal decimal = new BigDecimal(datePeriod.getDays());
			BigDecimal decimal1 = new BigDecimal(365);
			fac = decimal.divide(decimal1,new MathContext(6,RoundingMode.HALF_UP));
			//daysFactor = new BigDecimal( Math.pow(factor.doubleValue(), fac.doubleValue()*interestCalcFactor.doubleValue()));
		}
		daysFactor = daysFactor.add(fac, new MathContext(6,RoundingMode.HALF_UP));
		BigDecimal yearFactor = new BigDecimal( Math.pow(factor.doubleValue(), daysFactor.doubleValue()*interestCalcFactor.doubleValue()));
		BigDecimal maturityAmount = principal.multiply(yearFactor);
		double amount = maturityAmount.setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		return amount;
	}
	
	private int getCompoundFacor(NameValueInfo info){		
		return INTEREST_CALC_MAP.get(info.getValue()).getFactor();
		
	}

}
