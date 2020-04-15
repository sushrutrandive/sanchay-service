package com.planner.calc.service.services;

import java.util.List;

import com.planner.calc.service.info.EPFCalcInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.PPFCalcInfo;
public interface PFTransactionService {
	
	public List<PFTransactionInfo> createEPFTransactionList(EPFCalcInfo calcInfo);
	public List<PFTransactionInfo> createPPFTransactionList(PPFCalcInfo calcInfo);

}
