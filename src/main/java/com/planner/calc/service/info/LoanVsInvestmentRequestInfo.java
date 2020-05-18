package com.planner.calc.service.info;

public class LoanVsInvestmentRequestInfo {
	
	private double principalAmout;
	private double rate;
	private double emi;
	private NameValueInfo prePaymentFrequency = new NameValueInfo("ONE_TIME", 5) ;
	private double prePaymentAmount;
	public double getPrincipalAmout() {
		return principalAmout;
	}
	public void setPrincipalAmout(double principalAmout) {
		this.principalAmout = principalAmout;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public NameValueInfo getPrePaymentFrequency() {
		return prePaymentFrequency;
	}
	public void setPrePaymentFrequency(NameValueInfo prePaymentFrequency) {
		this.prePaymentFrequency = prePaymentFrequency;
	}
	public double getPrePaymentAmount() {
		return prePaymentAmount;
	}
	public void setPrePaymentAmount(double prePaymentAmount) {
		this.prePaymentAmount = prePaymentAmount;
	}
	
	
	
	

}
