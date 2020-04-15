package com.planner.calc.service.util;

import org.springframework.util.StringUtils;

import com.planner.calc.service.util.Constants.YES_NO;



public class StringUtil {
	
	public static boolean stringToBoolean(String str){
		
		if(StringUtils.hasText(str) && YES_NO.YES.getValue().equals(str))
		{
			return true;
		}
		return false;
	}
	
	public static String booleanToString(boolean value){
			
			if(value)
			{
				return YES_NO.YES.getValue();
			}
			return YES_NO.NO.getValue();
		}
	
	}
