package com.planner.calc.service.info;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FDTransactionInfo {
	
	private LocalDate transactionDate;
	private double amount;
	
	public FDTransactionInfo(LocalDate transactionDate, double amount) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
