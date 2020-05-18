package com.planner.calc.service.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.info.InvestmentCalcInfo;
import com.planner.calc.service.services.InvestmentAmountCalcService;

@RestController
@RequestMapping(value = "api/investmentAmtCalculator")
public class InvestmentAmountController {
	
	@Autowired
	private InvestmentAmountCalcService investmentAmountCalcService;
	@RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestmentCalcInfo getDetails(HttpServletRequest request, @RequestBody InvestmentCalcInfo info) {
		return investmentAmountCalcService.calculate(info);		
	}


}
