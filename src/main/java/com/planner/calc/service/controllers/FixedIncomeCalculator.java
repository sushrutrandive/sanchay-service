package com.planner.calc.service.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.info.CalculatorInfo;
import com.planner.calc.service.services.FixedIncomeCalcService;


@RestController
@RequestMapping(value = "api/fixedincomecalculator")
public class FixedIncomeCalculator {
	@Autowired
	private FixedIncomeCalcService fixedIncomeCalcService;

	@RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public CalculatorInfo getDetails(HttpServletRequest request, @RequestBody CalculatorInfo info) {
		return fixedIncomeCalcService.calculate(info);
		// return
		// expenseService.getExpensesByUserId(userService.getUserIdByToken(tokenPayload));
	}

}
