package com.planner.calc.service.info;

public class BaseInfo {
	
	private boolean deleted;
	private int updateCounter;
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getUpdateCounter() {
		return updateCounter;
	}
	public void setUpdateCounter(int updateCounter) {
		this.updateCounter = updateCounter;
	}
	

}
