package com.planner.calc.service.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountUtil {
	
	public static double  round(double amount, int placeUnit) {
		
		String str = new BigDecimal(amount).toPlainString();
		BigDecimal total = new BigDecimal (str);
		total=   total.setScale(placeUnit, RoundingMode.HALF_UP);
		return total.doubleValue();
		
	}
	
public static double  round(BigDecimal amount, int placeUnit) {		
		
		BigDecimal total=   amount.setScale(placeUnit, RoundingMode.HALF_UP);
		return total.doubleValue();
		
	}


}
