package com.planner.calc.service.services;

import java.util.List;


import com.planner.calc.service.info.SSYCalcInfo;
import com.planner.calc.service.info.SSYTransactionInfo;

public interface SSYTransactionService {
	
	public List<SSYTransactionInfo> createSSYTransactionList(SSYCalcInfo calcInfo);

}
