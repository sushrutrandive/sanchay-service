package com.planner.calc.service.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SSYCalcInfo {
	
	private Date startDate;
	private NameValueInfo contributionFrequency;
	private double contributionAmount;	
	private double balance;	
	private int terms;
	private double currentSSYValue;
	private double maturityAmount;
	private LocalDate currentAsOfDate;
	private LocalDate maturityAsOfDate;
	private double investedAmount;
	private double interestAmount;	
	
	private List<SSYTransactionInfo> transactionList = new ArrayList<>();

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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTerms() {
		return terms;
	}

	public void setTerms(int terms) {
		this.terms = terms;
	}

	public double getCurrentSSYValue() {
		return currentSSYValue;
	}

	public void setCurrentSSYValue(double currentSSYValue) {
		this.currentSSYValue = currentSSYValue;
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

	public List<SSYTransactionInfo> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<SSYTransactionInfo> transactionList) {
		this.transactionList = transactionList;
	}
	
	

}
