package com.planner.calc.service.info;

import java.util.ArrayList;
import java.util.List;

public class LoanRepaymentInfo {

	private double principalAmout;
	private double rate;
	private double emi;
	private NameValueInfo prePaymentFrequency;
	private double prePaymentAmount;
	private List<LoanRepaymentDetailsInfo> amortizationSchedule = new ArrayList<>();
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
	public void setAmortizationSchedule(List<LoanRepaymentDetailsInfo> amortizationSchedule) {
		this.amortizationSchedule = amortizationSchedule;
	}

	
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
	public List<LoanRepaymentDetailsInfo> getAmortizationSchedule() {
		return amortizationSchedule;
	}
	
	public void addPaymentDetail(LoanRepaymentDetailsInfo detail) {
		this.amortizationSchedule.add(detail);
	}
	
	
	
}
