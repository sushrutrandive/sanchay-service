package com.planner.calc.service.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.calculators.CalculatorContext;
import com.planner.calc.service.calculators.EPFCalculator;
import com.planner.calc.service.calculators.PPFCalculator;
import com.planner.calc.service.dao.StaticResources;
import com.planner.calc.service.exceptions.InvalidParameterException;
import com.planner.calc.service.info.EPFCalcInfo;
import com.planner.calc.service.info.CalculatorInfo;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.PPFCalcInfo;
import com.planner.calc.service.services.PFCalculatorService;
import com.planner.calc.service.services.PFTransactionService;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.DateUtil;
import com.planner.calc.service.util.ErrorCodes;


@Service
public class PFCalculatorServiceImpl implements PFCalculatorService{
	
	@Autowired
	private PFTransactionService pfTransactionService;
	
	
	@Override
	public EPFCalcInfo calculateEPF(EPFCalcInfo info) {
		
		LocalDate currentDate = LocalDate.now();		
		currentDate = currentDate.minusMonths(1);
		currentDate=currentDate.withDayOfMonth(currentDate.lengthOfMonth());
		
	
		List<PFTransactionInfo> transactionList = pfTransactionService.createEPFTransactionList(info);
		if(transactionList.size() == 0 ) {
			throw new InvalidParameterException(ErrorCodes.EPF_CALC_INTERNAL_ERROR);
		}
		LocalDate endDate = transactionList.get(transactionList.size()-1).getTransactionDate();
		info.setMaturityAsOfDate(endDate);
		info.setCurrentAsOfDate(currentDate);
		info.setTransactionList(transactionList);
		double totalAmount = transactionList.stream().mapToDouble(item-> item.getTransactionAmount().doubleValue()).sum();
		totalAmount= AmountUtil.round(totalAmount, 2);
		info.setInvestedAmount(totalAmount);
		
		CalculatorContext<EPFCalcInfo> context = new CalculatorContext<>(new EPFCalculator());
		info = context.calulateAmount(info);
		return info;
	}
	
	@Override
	public PPFCalcInfo calculatePPF(PPFCalcInfo info) {
		LocalDate currentDate = LocalDate.now();		
		currentDate = currentDate.minusMonths(1);
		currentDate=currentDate.withDayOfMonth(currentDate.lengthOfMonth());
		
	
		List<PFTransactionInfo> transactionList = pfTransactionService.createPPFTransactionList(info);
		if(transactionList.size() == 0 ) {
			throw new InvalidParameterException(ErrorCodes.EPF_CALC_INTERNAL_ERROR);
		}
		LocalDate endDate = transactionList.get(transactionList.size()-1).getTransactionDate();
		info.setMaturityAsOfDate(endDate);
		info.setCurrentAsOfDate(currentDate);
		info.setTransactionList(transactionList);
		double totalAmount = transactionList.stream().mapToDouble(item-> item.getTransactionAmount().doubleValue()).sum();
		totalAmount= AmountUtil.round(totalAmount, 2);
		info.setInvestedAmount(totalAmount);
		
		CalculatorContext<PPFCalcInfo> context = new CalculatorContext<>(new PPFCalculator());
		info = context.calulateAmount(info);
		return info;
	}
	
	

}
