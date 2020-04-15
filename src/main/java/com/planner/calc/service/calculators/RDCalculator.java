package com.planner.calc.service.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;

import com.planner.calc.service.info.RDCalcInfo;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.DateUtil;



public class RDCalculator implements Calculator<RDCalcInfo> {
	
	@Override
	public RDCalcInfo calculate(RDCalcInfo info) {
		// TODO Auto-generated method stub
		
		double n  = info.getTerms()/3d;
		double r = info.getInterestRate();
		double p = info.getPrincipalAmount();
		
		double amount = calculateAmount(n, r, p);
		
		// Calculate current Amount
		
		 n= DateUtil.getMonthsBetweenDates(info.getStartDate(), new Date())/3d;
		
		 double currentAmount = calculateAmount(n, r, p);
		
		info.setCurrentValue(currentAmount);
		info.setMaturityAmount(amount);
		
		BigDecimal investedAmount  = new  BigDecimal(info.getPrincipalAmount());
		investedAmount= investedAmount.multiply(BigDecimal.valueOf(info.getTerms()));
		
		double amount1 = AmountUtil.round(investedAmount, 2);
		info.setInvestedAmount(amount1);
		
		return info;
	}

	private double calculateAmount(double n, double r, double p) {
		BigDecimal i = new BigDecimal(r/400d);
		BigDecimal nFac= new BigDecimal(Math.pow(1+i.doubleValue(), n));
		BigDecimal num= new BigDecimal(nFac.doubleValue()-1).multiply(new BigDecimal(p));
		
		BigDecimal dFac= new BigDecimal(Math.pow(1+i.doubleValue(), (-1d/3d)));
		BigDecimal dem= new BigDecimal(1).subtract(dFac);
		
		BigDecimal maturityAmount = num.divide(dem,MathContext.DECIMAL32);
		double amount = maturityAmount.setScale(2, RoundingMode.HALF_UP).doubleValue();
		return amount;
	}

}
