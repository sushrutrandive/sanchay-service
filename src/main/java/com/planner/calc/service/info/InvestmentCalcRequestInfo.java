package com.planner.calc.service.info;

public class InvestmentCalcRequestInfo {
	
	private double futureAmount;
	private int terms;
	private double balance;
	public double getFutureAmount() {
		return futureAmount;
	}
	public void setFutureAmount(double futureAmount) {
		this.futureAmount = futureAmount;
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
	

}
