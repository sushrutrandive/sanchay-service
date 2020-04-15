package com.planner.calc.service.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PPFCalcInfo {
	
	private Date startDate;
	private NameValueInfo contributionFrequency;
	private double contributionAmount;
	private double expectedGrowth;
	private double balance;
	private NameValueInfo extensionPeriodOption; 
	private int extensionPeriod;
	
	private int terms;
	private double currentPPFValue;
	private double maturityAmount;
	private LocalDate currentAsOfDate;
	private LocalDate maturityAsOfDate;
	private double investedAmount;
	private double interestAmount;	
	private int originalTerms;
	private List<PFTransactionInfo> transactionList = new ArrayList<>();
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public NameValueInfo getContributionFrequency() {
		return contributionFrequency;
	}
	public void setContributionFrequency(NameValueInfo contributionFrequency) {
		this.contributionFrequency = contributionFrequency;
	}
	public double getContributionAmount() {
		return contributionAmount;
	}
	public void setContributionAmount(double contributionAmount) {
		this.contributionAmount = contributionAmount;
	}
	public double getExpectedGrowth() {
		return expectedGrowth;
	}
	public void setExpectedGrowth(double expectedGrowth) {
		this.expectedGrowth = expectedGrowth;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public NameValueInfo getExtensionPeriodOption() {
		return extensionPeriodOption;
	}
	public void setExtensionPeriodOption(NameValueInfo extensionPeriodOption) {
		this.extensionPeriodOption = extensionPeriodOption;
	}
	public int getExtensionPeriod() {
		return extensionPeriod;
	}
	public void setExtensionPeriod(int extensionPeriod) {
		this.extensionPeriod = extensionPeriod;
	}
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public double getCurrentPPFValue() {
		return currentPPFValue;
	}
	public void setCurrentPPFValue(double currentPPFValue) {
		this.currentPPFValue = currentPPFValue;
	}
	public double getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public LocalDate getCurrentAsOfDate() {
		return currentAsOfDate;
	}
	public void setCurrentAsOfDate(LocalDate currentAsOfDate) {
		this.currentAsOfDate = currentAsOfDate;
	}
	public LocalDate getMaturityAsOfDate() {
		return maturityAsOfDate;
	}
	public void setMaturityAsOfDate(LocalDate maturityAsOfDate) {
		this.maturityAsOfDate = maturityAsOfDate;
	}
	public double getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
	public double getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}
	public List<PFTransactionInfo> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<PFTransactionInfo> transactionList) {
		this.transactionList = transactionList;
	}
	public int getOriginalTerms() {
		return originalTerms;
	}
	public void setOriginalTerms(int originalTerms) {
		this.originalTerms = originalTerms;
	}
	
	
}
