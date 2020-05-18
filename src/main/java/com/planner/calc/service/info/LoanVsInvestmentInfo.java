package com.planner.calc.service.info;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoanVsInvestmentInfo {
	
	private int noOfTermsWithoutPrePayment;
	private int noOfTermsWithPrePayment;
	private double interestWithoutPrePayment;
	private double interestWithPrePayment;
	private Map<Double,Double> investmentDetails  = new LinkedHashMap<>();
	private LoanVsInvestmentRequestInfo request = new LoanVsInvestmentRequestInfo();
	
	public int getNoOfTermsWithoutPrePayment() {
		return noOfTermsWithoutPrePayment;
	}
	public void setNoOfTermsWithoutPrePayment(int noOfTermsWithoutPrePayment) {
		this.noOfTermsWithoutPrePayment = noOfTermsWithoutPrePayment;
	}
	public int getNoOfTermsWithPrePayment() {
		return noOfTermsWithPrePayment;
	}
	public void setNoOfTermsWithPrePayment(int noOfTermsWithPrePayment) {
		this.noOfTermsWithPrePayment = noOfTermsWithPrePayment;
	}
	public double getInterestWithoutPrePayment() {
		return interestWithoutPrePayment;
	}
	public void setInterestWithoutPrePayment(double interestWithoutPrePayment) {
		this.interestWithoutPrePayment = interestWithoutPrePayment;
	}
	public double getInterestWithPrePayment() {
		return interestWithPrePayment;
	}
	public void setInterestWithPrePayment(double interestWithPrePayment) {
		this.interestWithPrePayment = interestWithPrePayment;
	}
	public Map<Double, Double> getInvestmentDetails() {
		return investmentDetails;
	}
	public void setInvestmentDetails(Map<Double, Double> investmentDetails) {
		this.investmentDetails = investmentDetails;
	}
	
	public LoanVsInvestmentRequestInfo getRequest() {
		return request;
	}
	public void setRequest(LoanVsInvestmentRequestInfo request) {
		this.request = request;
	}
	
	
	public static LoanRepaymentInfo toLoanRepaymentInfo(LoanVsInvestmentInfo info) {
		
		LoanRepaymentInfo retInfo = new LoanRepaymentInfo();
		retInfo.setEmi(info.getRequest().getEmi());
		retInfo.setPrePaymentAmount(info.getRequest().getPrePaymentAmount());
		retInfo.setPrePaymentFrequency(info.getRequest().getPrePaymentFrequency());
		retInfo.setPrincipalAmout(info.getRequest().getPrincipalAmout());
		retInfo.setRate(info.getRequest().getRate());
		return retInfo;
		
	}
	
	public void addToInvestmentDetails (double rate, double fv) {
		this.investmentDetails.put(rate, fv);
	}
	

}
