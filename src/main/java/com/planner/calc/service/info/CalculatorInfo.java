package com.planner.calc.service.info;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalculatorInfo extends BaseInfo{
	
	private long fixedIncomeId;
	private String name;
	private NameValueInfo member;
	private NameValueInfo instrument;
	
	private EPFCalcInfo epfCalcInfo  = new EPFCalcInfo();
	private FixedDepositCalcInfo fdCalcInfo  = new FixedDepositCalcInfo();
	private RDCalcInfo rdCalcInfo  = new RDCalcInfo();
	private PPFCalcInfo ppfCalcInfo  = new PPFCalcInfo();
	private SSYCalcInfo ssyCalcInfo  = new SSYCalcInfo();
	
	
	private NameValueInfo investmentMode;
	private Date startDate;
	private Date endDate;
	private double principalAmount;
	private double interestRate;
	private NameValueInfo interestCalcMethod;
	private double currentValue;
	private double maturityAmount;
	private int terms;
	private double balance;
	private LocalDate currentAsOfDate;
	private LocalDate maturityAsOfDate;
	private double investedAmount;
	private double expectedGrowth;
	private List<FDTransactionInfo> transactionList =  new ArrayList<>();
	private List<PFTransactionInfo> pFTransactionList =  new ArrayList<>();
	
	
	
	public double getExpectedGrowth() {
		return expectedGrowth;
	}
	public void setExpectedGrowth(double expectedGrowth) {
		this.expectedGrowth = expectedGrowth;
	}
	
	public List<PFTransactionInfo> getPFTransactionList() {
		return pFTransactionList;
	}
	public void setPFTransactionList(List<PFTransactionInfo> pfTransactionList) {
		this.pFTransactionList = pfTransactionList;
	}
	public List<FDTransactionInfo> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<FDTransactionInfo> transactionList) {
		this.transactionList = transactionList;
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
	public long getFixedIncomeId() {
		return fixedIncomeId;
	}
	public void setFixedIncomeId(long fixedIncomeId) {
		this.fixedIncomeId = fixedIncomeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NameValueInfo getMember() {
		return member;
	}
	public void setMember(NameValueInfo member) {
		this.member = member;
	}
	public NameValueInfo getInstrument() {
		return instrument;
	}
	public void setInstrument(NameValueInfo instrument) {
		this.instrument = instrument;
	}
	public NameValueInfo getInvestmentMode() {
		return investmentMode;
	}
	public void setInvestmentMode(NameValueInfo investmentMode) {
		this.investmentMode = investmentMode;
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
	public double getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
	public EPFCalcInfo getEpfCalcInfo() {
		return epfCalcInfo;
	}
	public void setEpfCalcInfo(EPFCalcInfo epfCalcInfo) {
		this.epfCalcInfo = epfCalcInfo;
	}
	public FixedDepositCalcInfo getFdCalcInfo() {
		return fdCalcInfo;
	}
	public void setFdCalcInfo(FixedDepositCalcInfo fdCalcInfo) {
		this.fdCalcInfo = fdCalcInfo;
	}
	public RDCalcInfo getRdCalcInfo() {
		return rdCalcInfo;
	}
	public void setRdCalcInfo(RDCalcInfo rdCalcInfo) {
		this.rdCalcInfo = rdCalcInfo;
	}
	public PPFCalcInfo getPpfCalcInfo() {
		return ppfCalcInfo;
	}
	public void setPpfCalcInfo(PPFCalcInfo ppfCalcInfo) {
		this.ppfCalcInfo = ppfCalcInfo;
	}
	public SSYCalcInfo getSsyCalcInfo() {
		return ssyCalcInfo;
	}
	public void setSsyCalcInfo(SSYCalcInfo ssyCalcInfo) {
		this.ssyCalcInfo = ssyCalcInfo;
	}
	
	
	
	

}
