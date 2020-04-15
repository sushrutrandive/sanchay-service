package com.planner.calc.service.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.info.FVCalcInfo;
import com.planner.calc.service.services.FutureValueCalcService;



@RestController
@RequestMapping(value = "api/fvcalculator")
public class FutureValueCalculator {
	
	@Autowired
	private FutureValueCalcService futureValueCalcService;
	@RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public FVCalcInfo getDetails(HttpServletRequest request, @RequestBody FVCalcInfo info) {
		return futureValueCalcService.calculate(info);		
	}

}
