package com.planner.calc.service.util;

import org.springframework.util.StringUtils;

public class Constants {
	
	public enum YES_NO{
		YES ("Y"),
		NO("N");
		private final String value;
	    YES_NO(String value) {
	        this.value = value;
	    }
	    public String getValue(){
	    	return this.value;
	    }
	    public boolean getBooleanValue(){
	    	return StringUtil.stringToBoolean(this.value);
	    }
	}
	
	public enum FIXED_INCOME{
		FIXED_DEPOSIT (1),
		RECURRING_DEPOSIT(2),
		NSC(3),
		PPF(5),
		EPF(6),
		SSY(7);
		private final int value;
		FIXED_INCOME(int value) {
	        this.value = value;
	    }
	    public int getValue(){
	    	return this.value;
	    }
	    
	    public static FIXED_INCOME fromInteger(int x) {
	        switch(x) {
	        case 1:
	            return FIXED_DEPOSIT;
	        case 2:
	            return RECURRING_DEPOSIT;
	        case 3:
	            return NSC;
	        case 5:
	            return PPF;	            
	        case 6:
	            return EPF;
	        case 7:
	            return SSY;
	        }
	        return null;
	    }
	}
	
	public enum FIXED_INCOME_INVESTMENT_MODE{
		ONE_TIME (1),
		MONTHLY_OR_SIP(2),
		ADHOC(3),
		YEARLY(4);
		private final int value;
		FIXED_INCOME_INVESTMENT_MODE(int value) {
	        this.value = value;
	    }
	    public int getValue(){
	    	return this.value;
	    }
	   
	}
	public enum INTEREST_CALC_MEHOD{
		SIMPLE (1,0),
		CONMPOND_MONTHLY(2,12),
		CONMPOND_QUARTERLY(3,4),
		CONMPOND_SEMI_ANNUALLY(4,2),
		CONMPOND_ANNUALLY(5,1);
		private final int value;
		private final int factor;
		INTEREST_CALC_MEHOD(int value,int factor) {
	        this.value = value;
	        this.factor = factor;
	    }
	    public int getValue(){
	    	return this.value;
	    }
	   
	    public int getFactor(){
	    	return this.factor;
	    }
	}
	
	public enum PPF_CONTRIBUTION_FREQUENCY{
		MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE (1),
		MONTHLY_AFTER_CUT_OFF_DATE (2),
		ANNUALLY_START_OF_FY (3),
		ANNUALLY_END_OF_FY (4);
		
		private final int value;
		
		PPF_CONTRIBUTION_FREQUENCY(int value) {
	        this.value = value;
	       
	    }
	    public int getValue(){
	    	return this.value;
	    }
	    
	    public static PPF_CONTRIBUTION_FREQUENCY fromInteger(int x) {
	        switch(x) {
	        case 1:
	            return MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE;
	        case 2:
	            return MONTHLY_AFTER_CUT_OFF_DATE;
	        case 3:
	            return ANNUALLY_START_OF_FY;
	        case 4:
	            return ANNUALLY_END_OF_FY;	           
	      
	        }
	        return null;
	    }
	   
	   
	}
	
	public enum PPF_EXTENSION_OPTIONS{
		NO_EXTENSION (1),
		EXTENSION_WITH_FRESH_CONTRIBUTION (2),
		EXTENSION_WITHOUT_FRESH_CONTRIBUTION (3);
		
		
		private final int value;
		
		PPF_EXTENSION_OPTIONS(int value) {
	        this.value = value;
	       
	    }
	    public int getValue(){
	    	return this.value;
	    }
	    
	    public static PPF_EXTENSION_OPTIONS fromInteger(int x) {
	        switch(x) {
	        case 1:
	            return NO_EXTENSION;
	        case 2:
	            return EXTENSION_WITH_FRESH_CONTRIBUTION;
	        case 3:
	            return EXTENSION_WITHOUT_FRESH_CONTRIBUTION;
	              
	      
	        }
	        return null;
	    }
	   
	   
	}
	
	public enum SSY_CONTRIBUTION_FREQUENCY{
		MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE (1),
		MONTHLY_AFTER_CUT_OFF_DATE (2),
		ANNUALLY_START_OF_FY (3),
		ANNUALLY_END_OF_FY (4);
		
		private final int value;
		
		SSY_CONTRIBUTION_FREQUENCY(int value) {
	        this.value = value;
	       
	    }
	    public int getValue(){
	    	return this.value;
	    }
	    
	    public static SSY_CONTRIBUTION_FREQUENCY fromInteger(int x) {
	        switch(x) {
	        case 1:
	            return MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE;
	        case 2:
	            return MONTHLY_AFTER_CUT_OFF_DATE;
	        case 3:
	            return ANNUALLY_START_OF_FY;
	        case 4:
	            return ANNUALLY_END_OF_FY;	           
	      
	        }
	        return null;
	    }
	   
	   
	}
	
	
	public enum FV_CALC_OPTIONS{
		FV_SIP_AMT ("FV_SIP_AMT");
	
		
		private final String value;
		
		FV_CALC_OPTIONS(String value) {
	        this.value = value;
	       
	    }
	    public String getValue(){
	    	return this.value;
	    }
	    
	    public static FV_CALC_OPTIONS fromString(String x) {
	        switch(x) {
	        case "FV_SIP_AMT":
	            return FV_SIP_AMT;
	        }
	        return null;
	    }
	   
	   
	}
	 
	
	
	

}
