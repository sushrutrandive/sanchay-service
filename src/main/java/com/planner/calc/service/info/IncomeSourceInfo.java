package com.planner.calc.service.info;

public class IncomeSourceInfo extends BaseInfo {
	private long incomeSourceId;
	private NameValueInfo incomeSourceType;
	private NameValueInfo member;
	private FrequencyInfo frequency;
	private long userId;
	private long income;
	private long annualIncome;
	private String remark;
	public long getIncomeSourceId() {
		return incomeSourceId;
	}
	public void setIncomeSourceId(long incomeSourceId) {
		this.incomeSourceId = incomeSourceId;
	}
	public NameValueInfo getIncomeSourceType() {
		return incomeSourceType;
	}
	public void setIncomeSourceType(NameValueInfo incomeSource) {
		this.incomeSourceType = incomeSource;
	}
	public NameValueInfo getMember() {
		return member;
	}
	public void setMember(NameValueInfo member) {
		this.member = member;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public long getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public FrequencyInfo getFrequency() {
		return frequency;
	}
	public void setFrequency(FrequencyInfo frequency) {
		this.frequency = frequency;
	}
	

}
