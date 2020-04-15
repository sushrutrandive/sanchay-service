package com.planner.calc.service.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EPFCalcInfo {

	private double employeeContributionAmount;
	private double employerContributionAmount;
	private double epsContributionAmount;
	private double balance;
	private double epsBalance;
	private NameValueInfo interestCalcMethod;
	private double interestRate;
	private Date startDate;
	private Date endDate;
	private int terms;
	private double currentEPFValue;
	private double maturityAmount;
	private double currentEPsValue;
	private double maturityEpsAmount;
	private LocalDate currentAsOfDate;
	private LocalDate maturityAsOfDate;
	private double investedAmount;
	private double interestAmount;
	private double expectedGrowth;
	private List<PFTransactionInfo> transactionList = new ArrayList<>();
	
	
	public double getEmployeeContributionAmount() {
		return employeeContributionAmount;
	}
	public void setEmployeeContributionAmount(double employeeContributionAmount) {
		this.employeeContributionAmount = employeeContributionAmount;
	}
	public double getEmployerContributionAmount() {
		return employerContributionAmount;
	}
	public void setEmployerContributionAmount(double employerContributionAmount) {
		this.employerContributionAmount = employerContributionAmount;
	}
	public double getEpsContributionAmount() {
		return epsContributionAmount;
	}
	public void setEpsContributionAmount(double epsContributionAmount) {
		this.epsContributionAmount = epsContributionAmount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getEpsBalance() {
		return epsBalance;
	}
	public void setEpsBalance(double epsBalance) {
		this.epsBalance = epsBalance;
	}
	public NameValueInfo getInterestCalcMethod() {
		return interestCalcMethod;
	}
	public void setInterestCalcMethod(NameValueInfo interestCalcMethod) {
		this.interestCalcMethod = interestCalcMethod;
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
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public double getCurrentEPFValue() {
		return currentEPFValue;
	}
	public void setCurrentEPFValue(double currentEPFValue) {
		this.currentEPFValue = currentEPFValue;
	}
	public double getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public double getCurrentEPsValue() {
		return currentEPsValue;
	}
	public void setCurrentEPsValue(double currentEPsValue) {
		this.currentEPsValue = currentEPsValue;
	}
	public double getMaturityEpsAmount() {
		return maturityEpsAmount;
	}
	public void setMaturityEpsAmount(double maturityEpsAmount) {
		this.maturityEpsAmount = maturityEpsAmount;
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
	public double getExpectedGrowth() {
		return expectedGrowth;
	}
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
	public void setExpectedGrowth(double expectedGrowth) {
		this.expectedGrowth = expectedGrowth;
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
	
	

}
