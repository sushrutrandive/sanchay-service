package com.planner.calc.service.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.planner.calc.service.exceptions.InvalidParameterException;
import com.planner.calc.service.info.LoanRepaymentDetailsInfo;
import com.planner.calc.service.info.LoanRepaymentInfo;
import com.planner.calc.service.services.LoanRepaymentService;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.Constants.LOAN_PREPAYMENT_FREQUENCY;
import com.planner.calc.service.util.ErrorCodes;

@Service
public class LoanRepaymentServiceImpl implements LoanRepaymentService {
	
	@Override
	public LoanRepaymentInfo getAmortizationSchedule(LoanRepaymentInfo info) {
		int repaymentFactor = getRepaymentFactor(info);
		
		
		if (Objects.isNull(info) || info.getEmi()<1 || info.getPrincipalAmout() <1 || !(info.getRate()>0 && info.getRate() <100) ) {
			throw new InvalidParameterException(ErrorCodes.LOAN_INVALID_DETAILS);
		}
		double monthlyInterestAmount  =  AmountUtil.round((info.getPrincipalAmout() * info.getRate() /1200),2);
		if(monthlyInterestAmount > info.getEmi()) {
			throw new InvalidParameterException(ErrorCodes.LOAN_INCORRECT_EMI);
		}
		
		if(info.getPrePaymentAmount() > info.getPrincipalAmout()) {
			throw new InvalidParameterException(ErrorCodes.LOAN_PP_AMT_GT_LOAN_AMT);
		}
		
		BigDecimal principalAmount  = new BigDecimal(info.getPrincipalAmout());
		int count  = 0;
		while(AmountUtil.round(principalAmount, 2)>0) {
			
			LoanRepaymentDetailsInfo amort = new LoanRepaymentDetailsInfo();
			amort.setEmi(info.getEmi());
			amort.setRate(info.getRate());
			amort.setOpeningAmount(AmountUtil.round(principalAmount, 2));
			
			count=count+1;
			
			double interstForPeriod= AmountUtil.round(new BigDecimal(info.getRate()).multiply(principalAmount).divide(new BigDecimal(1200),2, RoundingMode.HALF_UP),2);
			double principalForPeriod= AmountUtil.round(new BigDecimal(info.getEmi()).subtract(new BigDecimal(interstForPeriod)),2); 
			if(principalForPeriod>AmountUtil.round(principalAmount, 2)) {
				principalForPeriod = AmountUtil.round(principalAmount, 2);
				double emi= AmountUtil.round(principalAmount.add(new BigDecimal(interstForPeriod)),2); 
				amort.setEmi(emi);
			}
			
			double outstandingPricipal  = AmountUtil.round(principalAmount.subtract(new BigDecimal(principalForPeriod)),2); 
			if((repaymentFactor > 0 &&  (count % repaymentFactor == 0)) || ((repaymentFactor ==5 &&  (count  == 1))) ) {
				
				if(outstandingPricipal>0) {
					amort.setPrePaymentAmout(info.getPrePaymentAmount());
					if(outstandingPricipal >= info.getPrePaymentAmount()) {
						outstandingPricipal  = AmountUtil.round(new BigDecimal(outstandingPricipal).subtract(new BigDecimal(info.getPrePaymentAmount())),2);
					}
					else {
						amort.setPrePaymentAmout(outstandingPricipal);
						outstandingPricipal = 0D;
						
					}
				}
			}
			amort.setInterestForPeriod(interstForPeriod);
			amort.setOutstandingAmount(outstandingPricipal);
			amort.setPrincipalForPeriod(principalForPeriod);
			
			info.addPaymentDetail(amort);
			principalAmount  = new BigDecimal(outstandingPricipal);
			if((repaymentFactor ==  5) && count==1) {
				
				//reset prepayment amount to zero
				info.setPrePaymentAmount(0);
			}
			
		}
		
		return info;
			
	}

	private int getRepaymentFactor(LoanRepaymentInfo info) {
		int repaymentFactor=0;
		if(Objects.nonNull(info.getPrePaymentFrequency())) {
			LOAN_PREPAYMENT_FREQUENCY fre = LOAN_PREPAYMENT_FREQUENCY.fromInteger(info.getPrePaymentFrequency().getValue());
			if(fre==LOAN_PREPAYMENT_FREQUENCY.MONTHLY )
				repaymentFactor = 1;
			else if(fre==LOAN_PREPAYMENT_FREQUENCY.QUARTERLY )
				repaymentFactor = 3;
			else if(fre==LOAN_PREPAYMENT_FREQUENCY.SEMI_ANNUALLY )
				repaymentFactor = 6;
			else if(fre==LOAN_PREPAYMENT_FREQUENCY.ANNUALLY )
				repaymentFactor = 12;
			else if(fre==LOAN_PREPAYMENT_FREQUENCY.ONE_TIME )
				repaymentFactor = 5;
			
		}
		return repaymentFactor;
	}

}
