package com.planner.calc.service.util;

import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.util.Constants.INTEREST_CALC_MEHOD;

public class InterestCalcMethodUtil {
	
	public static NameValueInfo interestCalcMethodCompoundAnnually() {
		return new NameValueInfo(INTEREST_CALC_MEHOD.CONMPOND_ANNUALLY.name(), INTEREST_CALC_MEHOD.CONMPOND_ANNUALLY.getValue());		
	}

}
