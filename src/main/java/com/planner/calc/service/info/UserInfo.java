package com.planner.calc.service.info;

public class UserInfo extends BaseInfo{
	
	private long userId;
	private String name;	
	private String email;
	private long mobileNo;
	private boolean active;
	private NameValueInfo relation;
	private NameValueInfo occupation;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public NameValueInfo getRelation() {
		return relation;
	}
	public void setRelation(NameValueInfo relation) {
		this.relation = relation;
	}
	public NameValueInfo getOccupation() {
		return occupation;
	}
	public void setOccupation(NameValueInfo occupation) {
		this.occupation = occupation;
	}
	

}
