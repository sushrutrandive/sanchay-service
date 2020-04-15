package com.planner.calc.service.info;

public class DatePeriodInfo {
	
	private int years;
	private int days;
	
	
	public DatePeriodInfo(int years, int days) {
		super();
		this.years = years;
		this.days = days;
	}
	
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}

}
