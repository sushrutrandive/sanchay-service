package com.planner.calc.service.info;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PFTransactionInfo {
	
	private LocalDate transactionDate;
	private BigDecimal openingBalance;
	private BigDecimal transactionAmount;
	private BigDecimal interestRate;
	private BigDecimal maturityAmount;
	private BigDecimal interestAmount;
	private BigDecimal closingBalance;
	private boolean start;
	private boolean end;
	private BigDecimal accuredInterest;
	private String financeYear;
	
	
	public BigDecimal getAccuredInterest() {
		return accuredInterest;
	}
	public void setAccuredInterest(BigDecimal accuredInterest) {
		this.accuredInterest = accuredInterest;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public BigDecimal getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public BigDecimal getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(BigDecimal maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public BigDecimal getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(BigDecimal closingBalance) {
		this.closingBalance = closingBalance;
	}
	
	public boolean isStart() {
		return start;
	}
	public boolean isEnd() {
		return end;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public String getFinanceYear() {
		return financeYear;
	}
	public void setFinanceYear(String financeYear) {
		this.financeYear = financeYear;
	}
	@Override
	public String toString() {
		return "PFTransactionInfo [transactionDate=" + transactionDate + ", openingBalance=" + openingBalance
				+ ", transactionAmount=" + transactionAmount + ", interestRate=" + interestRate + ", maturityAmount="
				+ maturityAmount + ", interestAmount=" + interestAmount + "]";
	}

}
