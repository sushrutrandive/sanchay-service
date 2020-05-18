package com.planner.calc.service.services.impl;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.info.LoanRepaymentInfo;
import com.planner.calc.service.info.LoanVsInvestmentInfo;
import com.planner.calc.service.services.LoanPaymentVsInvestment;
import com.planner.calc.service.services.LoanRepaymentService;
import com.planner.calc.service.util.AmountUtil;

@Service
public class LoanPaymentVsInvestmentImpl implements LoanPaymentVsInvestment {
	
	@Autowired
	private LoanRepaymentService loanRepaymentService;
	
	@Override
	public LoanVsInvestmentInfo compareLoanPaymentVsInvestment(LoanVsInvestmentInfo info) {
		
		LoanVsInvestmentInfo retInfo = new LoanVsInvestmentInfo(); 
		retInfo.getRequest().setEmi(info.getRequest().getEmi());
		retInfo.getRequest().setPrePaymentAmount(info.getRequest().getPrePaymentAmount());
		retInfo.getRequest().setPrePaymentFrequency(info.getRequest().getPrePaymentFrequency());
		retInfo.getRequest().setPrincipalAmout(info.getRequest().getPrincipalAmout());
		retInfo.getRequest().setRate(info.getRequest().getRate());
		
		
		LoanRepaymentInfo repaymentInfo =  LoanVsInvestmentInfo.toLoanRepaymentInfo(info);
		double prePaymentAmt =  repaymentInfo.getPrePaymentAmount();
		repaymentInfo =  loanRepaymentService.getAmortizationSchedule(repaymentInfo);
		retInfo.setNoOfTermsWithPrePayment(repaymentInfo.getAmortizationSchedule().size());
		
		double totalInterest = repaymentInfo.getAmortizationSchedule().stream().mapToDouble(item -> item.getInterestForPeriod()).sum();
		retInfo.setInterestWithPrePayment(totalInterest);
		
		int noOfTerms =  repaymentInfo.getAmortizationSchedule().size();
		
		// Without prepayment
		repaymentInfo =  LoanVsInvestmentInfo.toLoanRepaymentInfo(info);
		repaymentInfo.setPrePaymentAmount(0);
		repaymentInfo =  loanRepaymentService.getAmortizationSchedule(repaymentInfo);
		retInfo.setNoOfTermsWithoutPrePayment(repaymentInfo.getAmortizationSchedule().size());
		double totalInterestWithoutPrePay =   repaymentInfo.getAmortizationSchedule().stream().mapToDouble(item -> item.getInterestForPeriod()).sum();
		retInfo.setInterestWithoutPrePayment(totalInterestWithoutPrePay);
		// TODO Auto-generated method stub
		// Calculate Investment Details
		double [] rates = {8.0D,9.0D,10.0D,11.0D,12.0D,13.0D,14.0D,15.0D};
		
		Arrays.stream(rates).forEach((r)->{
			
			double fv = AmountUtil.round(FinanceLib.fv((r/100), (noOfTerms/12.0D), 0, prePaymentAmt, false), 0);			
			retInfo.addToInvestmentDetails(r, fv*-1D);
		});
		
		
		return retInfo;
	}

}
