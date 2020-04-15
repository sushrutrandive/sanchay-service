package com.planner.calc.service.info;

import java.util.Date;

public class FamilyMemberInfo extends BaseInfo {
	private long userId;
	private long memberId;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNo;
	private boolean active;
	private boolean mainUser;
	private Date dateOfBirth;
	private NameValueInfo relation;
	private NameValueInfo occupation;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public boolean isMainUser() {
		return mainUser;
	}
	public void setMainUser(boolean mainUser) {
		this.mainUser = mainUser;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
