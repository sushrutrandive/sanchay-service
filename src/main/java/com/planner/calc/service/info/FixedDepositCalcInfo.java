package com.planner.calc.service.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FixedDepositCalcInfo extends BaseInfo {
	
	private double principalAmount;
	private double interestRate;
	private Date startDate;
	private Date endDate;
	private NameValueInfo interestCalcMethod;
	private double currentValue;
	private double maturityAmount;
	private LocalDate currentAsOfDate;
	private LocalDate maturityAsOfDate;
	private double investedAmount;
	private List<FDTransactionInfo> transactionList =  new ArrayList<>();
	
	
	public List<FDTransactionInfo> getTransactionList() {
		return transactionList;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public NameValueInfo getInterestCalcMethod() {
		return interestCalcMethod;
	}
	public void setInterestCalcMethod(NameValueInfo interestCalcMethod) {
		this.interestCalcMethod = interestCalcMethod;
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
	
	public void addTransactionToList(FDTransactionInfo info) {
		this.transactionList.add(info);
	}
	public double getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
	
	
	

}
