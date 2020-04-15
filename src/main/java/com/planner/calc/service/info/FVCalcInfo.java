package com.planner.calc.service.info;

import java.util.LinkedHashMap;
import java.util.Map;

public class FVCalcInfo {
	
	
	private String type;
	private FVCalcRequestInfo fvCalcRequest;
	private double futureValue;
	private Map<Double, Double> lumpsumInvestment = new LinkedHashMap<>();	
	private Map<Double, Double> sipInvestment = new LinkedHashMap<>();
	
	public FVCalcInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FVCalcRequestInfo getFvCalcRequest() {
		return fvCalcRequest;
	}

	public void setFvCalcRequest(FVCalcRequestInfo fvCalcRequest) {
		this.fvCalcRequest = fvCalcRequest;
	}

	public double getFutureValue() {
		return futureValue;
	}

	public void setFutureValue(double futureValue) {
		this.futureValue = futureValue;
	}
	
	public void addLumpsumDetail(double rate,double amount) {
		
		this.lumpsumInvestment.put(rate, amount);
		
	}
	
	public void addSIPDetail(double rate,double amount) {
		this.sipInvestment.put(rate, amount);
	}

	public Map<Double, Double> getLumpsumInvestment() {
		return lumpsumInvestment;
	}

	public Map<Double, Double> getSipInvestment() {
		return sipInvestment;
	}
	
	
	
	

}
