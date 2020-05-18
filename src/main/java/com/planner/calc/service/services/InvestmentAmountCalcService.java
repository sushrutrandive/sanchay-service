package com.planner.calc.service.services;

import com.planner.calc.service.info.FVCalcInfo;
import com.planner.calc.service.info.InvestmentCalcInfo;

public interface InvestmentAmountCalcService {

	public InvestmentCalcInfo calculate(InvestmentCalcInfo calcInfo);
}
