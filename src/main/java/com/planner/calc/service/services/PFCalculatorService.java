package com.planner.calc.service.services;

import com.planner.calc.service.info.EPFCalcInfo;
import com.planner.calc.service.info.PPFCalcInfo;
import com.planner.calc.service.info.CalculatorInfo;

public interface PFCalculatorService {
	
	public EPFCalcInfo calculateEPF(EPFCalcInfo calcInfo);
	public PPFCalcInfo calculatePPF(PPFCalcInfo calcInfo);

}
