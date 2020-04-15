package com.planner.calc.service.info;

import java.util.Date;

public class RDCalcInfo {
	
	private double principalAmount;
	private double interestRate;
	private int terms;	
	private double currentValue;
	private double maturityAmount;
	private Date startDate;
	private double investedAmount;
	private NameValueInfo interestCalcMethod;
	
	public double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public double getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public double getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
	public NameValueInfo getInterestCalcMethod() {
		return interestCalcMethod;
	}
	public void setInterestCalcMethod(NameValueInfo interestCalcMethod) {
		this.interestCalcMethod = interestCalcMethod;
	}
	
	

}
