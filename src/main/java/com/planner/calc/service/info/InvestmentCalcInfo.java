package com.planner.calc.service.info;

import java.util.LinkedHashMap;
import java.util.Map;

public class InvestmentCalcInfo {

	private String type;
	private InvestmentCalcRequestInfo investmentCalcRequest;
	private Map<Double, Double> lumpsumInvestment = new LinkedHashMap<>();
	private Map<Double, Double> sipInvestment = new LinkedHashMap<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InvestmentCalcRequestInfo getInvestmentCalcRequest() {
		return investmentCalcRequest;
	}

	public void setInvestmentCalcRequest(InvestmentCalcRequestInfo investmentCalcRequest) {
		this.investmentCalcRequest = investmentCalcRequest;
	}

	public Map<Double, Double> getLumpsumInvestment() {
		return lumpsumInvestment;
	}

	public Map<Double, Double> getSipInvestment() {
		return sipInvestment;
	}

	public void addLumpsumDetail(double rate, double amount) {

		this.lumpsumInvestment.put(rate, amount);

	}

	public void addSIPDetail(double rate, double amount) {
		this.sipInvestment.put(rate, amount);
	}

}
