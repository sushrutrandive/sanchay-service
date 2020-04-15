package com.planner.calc.service.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.calculators.CalculatorContext;
import com.planner.calc.service.calculators.PPFCalculator;
import com.planner.calc.service.calculators.SSYCalculator;
import com.planner.calc.service.exceptions.InvalidParameterException;
import com.planner.calc.service.info.CalculatorInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.PPFCalcInfo;
import com.planner.calc.service.info.SSYCalcInfo;
import com.planner.calc.service.info.SSYTransactionInfo;
import com.planner.calc.service.services.SSYCalculatorService;
import com.planner.calc.service.services.SSYTransactionService;
import com.planner.calc.service.util.AmountUtil;
import com.planner.calc.service.util.ErrorCodes;
@Service
public class SSYCalculatorServiceImpl implements SSYCalculatorService {
	
	@Autowired
	private SSYTransactionService ssyTransactionService;
	
	@Override
	public SSYCalcInfo calculateSSY(SSYCalcInfo calcInfo) {
		LocalDate currentDate = LocalDate.now();		
		currentDate = currentDate.minusMonths(1);
		currentDate=currentDate.withDayOfMonth(currentDate.lengthOfMonth());
		
	
		List<SSYTransactionInfo> transactionList = ssyTransactionService.createSSYTransactionList(calcInfo);
		if(transactionList.size() == 0 ) {
			throw new InvalidParameterException(ErrorCodes.EPF_CALC_INTERNAL_ERROR);
		}
		LocalDate endDate = transactionList.get(transactionList.size()-1).getTransactionDate();
		calcInfo.setMaturityAsOfDate(endDate);
		calcInfo.setCurrentAsOfDate(currentDate);
		calcInfo.setTransactionList(transactionList);
		double totalAmount = transactionList.stream().mapToDouble(item-> item.getTransactionAmount().doubleValue()).sum();
		totalAmount= AmountUtil.round(totalAmount, 2);
		calcInfo.setInvestedAmount(totalAmount);
		
		CalculatorContext<SSYCalcInfo> context = new CalculatorContext<>(new SSYCalculator());
		calcInfo = context.calulateAmount(calcInfo);
		return calcInfo;
	}

}
