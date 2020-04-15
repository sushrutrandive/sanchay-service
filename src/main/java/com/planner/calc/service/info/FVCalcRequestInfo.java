package com.planner.calc.service.info;

public class FVCalcRequestInfo {
	
	private double presentCost;
	private int terms;
	private double balance;
	private double inflationRate;
	
	public FVCalcRequestInfo() {
		// TODO Auto-generated constructor stub
	}
	public double getPresentCost() {
		return presentCost;
	}
	public void setPresentCost(double presentCost) {
		this.presentCost = presentCost;
	}
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInflationRate() {
		return inflationRate;
	}
	public void setInflationRate(double inflationRate) {
		this.inflationRate = inflationRate;
	}
	
	

}
