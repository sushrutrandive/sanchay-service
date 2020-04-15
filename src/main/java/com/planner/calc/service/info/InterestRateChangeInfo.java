package com.planner.calc.service.info;

import java.util.Date;

public class InterestRateChangeInfo extends BaseInfo {
	
	private long id;
	private Date startDate;
	private Date endDate;
	private double ppfRate;
	private double epfRate;
	private double ssyRate;
	private double kvpRate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public double getPpfRate() {
		return ppfRate;
	}
	public void setPpfRate(double ppfRate) {
		this.ppfRate = ppfRate;
	}
	public double getEpfRate() {
		return epfRate;
	}
	public void setEpfRate(double epfRate) {
		this.epfRate = epfRate;
	}
	public double getSsyRate() {
		return ssyRate;
	}
	public void setSsyRate(double ssyRate) {
		this.ssyRate = ssyRate;
	}
	public double getKvpRate() {
		return kvpRate;
	}
	public void setKvpRate(double kvpRate) {
		this.kvpRate = kvpRate;
	}
	
	
	

}
