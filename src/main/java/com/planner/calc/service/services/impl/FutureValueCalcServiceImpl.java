package com.planner.calc.service.services.impl;

import java.math.BigDecimal;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.springframework.stereotype.Service;

import com.planner.calc.service.info.FVCalcInfo;
import com.planner.calc.service.info.FVCalcRequestInfo;
import com.planner.calc.service.services.FutureValueCalcService;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.Constants.FV_CALC_OPTIONS;

@Service
public class FutureValueCalcServiceImpl implements FutureValueCalcService  {
	
	@Override
	public FVCalcInfo calculate(FVCalcInfo calcInfo) {
		
		

		FVCalcRequestInfo request = calcInfo.getFvCalcRequest();
		BigDecimal presntCost = new BigDecimal(request.getPresentCost());
		double result =FinanceLib.fv((request.getInflationRate()/100), request.getTerms(), 0.0, presntCost.doubleValue()*-1D, false);
		//result =FinanceLib.fv((10.0/100), 15, 0.0, -400000, true);
		double fv = AmountUtil.round(result, 0);
		double [] rates = {8.0D,9.0D,10.0D,11.0D,12.0D,13.0D,14.0D,15.0D};
		
		for(double rate : rates) {
			
			double fvOfPresentAmt = 0;
			if(request.getBalance()>0) {
				fvOfPresentAmt = FinanceLib.fv((rate/100), request.getTerms(), 0.0D, (request.getBalance()*-1), false);
				fvOfPresentAmt = AmountUtil.round(fvOfPresentAmt, 0);
			}
			double fvAmt = fv - fvOfPresentAmt;
			double lumpsump = AmountUtil.round(FinanceLib.pv((rate/100), request.getTerms(), 0, fvAmt, false),0);
			int termsInMonth = request.getTerms()*12;
			double sip = AmountUtil.round(FinanceLib.pmt((rate/1200), termsInMonth, 0, fvAmt, false),0);
			lumpsump = lumpsump*-1D;
			sip = sip*-1D;
			calcInfo.addLumpsumDetail(rate, lumpsump);
			calcInfo.addSIPDetail(rate, sip );
			
		}
		
		
		
		
		calcInfo.setFutureValue(fv);
	
		return calcInfo;
	}
	
	public static void main(String[] args) {
		
		double result =FinanceLib.fv((10D/100), 15, 0.0, (400000*-1D), true);
		String str = new BigDecimal(result).toPlainString();
		
		double fv = AmountUtil.round(new BigDecimal(str), 0);
		System.out.println(fv);
		fv = AmountUtil.round(result, 0);
		System.out.println(fv);
		
	}
	
	
	


}
