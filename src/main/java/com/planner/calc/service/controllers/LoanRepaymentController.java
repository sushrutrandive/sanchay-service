package com.planner.calc.service.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.info.FVCalcInfo;
import com.planner.calc.service.info.LoanRepaymentInfo;
import com.planner.calc.service.info.LoanVsInvestmentInfo;
import com.planner.calc.service.services.FutureValueCalcService;
import com.planner.calc.service.services.LoanPaymentVsInvestment;
import com.planner.calc.service.services.LoanRepaymentService;

@RestController
@RequestMapping(value = "api/loanppcalculator")
public class LoanRepaymentController {
	
	@Autowired
	private LoanRepaymentService loanRepaymentService;
	
	@Autowired
	private LoanPaymentVsInvestment loanPaymentVsInvestmentService;
	
	@RequestMapping(value = "/schedule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanRepaymentInfo getDetails(HttpServletRequest request, @RequestBody LoanRepaymentInfo info) {
		return loanRepaymentService.getAmortizationSchedule(info);		
	}
	
	@RequestMapping(value = "/compare", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanVsInvestmentInfo compareLoanVsInvestment(HttpServletRequest request, @RequestBody LoanVsInvestmentInfo info) {
		return loanPaymentVsInvestmentService.compareLoanPaymentVsInvestment(info);	
	}

}
