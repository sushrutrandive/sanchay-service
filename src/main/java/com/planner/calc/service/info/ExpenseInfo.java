package com.planner.calc.service.info;

public class ExpenseInfo extends BaseInfo{
	private long expenseId;
	private NameValueInfo expenseCategory;
	private ChildNameValueInfo expenseSubCategory;
	private FrequencyInfo frequency;
	private long userId;
	private long amount;
	private long annualAmount;
	private String remark;
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	public NameValueInfo getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(NameValueInfo expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	public ChildNameValueInfo getExpenseSubCategory() {
		return expenseSubCategory;
	}
	public void setExpenseSubCategory(ChildNameValueInfo expenseSubCategory) {
		this.expenseSubCategory = expenseSubCategory;
	}
	public FrequencyInfo getFrequency() {
		return frequency;
	}
	public void setFrequency(FrequencyInfo frequency) {
		this.frequency = frequency;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getAnnualAmount() {
		return annualAmount;
	}
	public void setAnnualAmount(long annualAmount) {
		this.annualAmount = annualAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
