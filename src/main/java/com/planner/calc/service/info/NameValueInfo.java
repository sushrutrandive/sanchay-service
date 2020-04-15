package com.planner.calc.service.info;

public class NameValueInfo {
	
	public NameValueInfo( String name,int value) {
		this.name = name;
		this.value=value;
	}
	
	public NameValueInfo() {
		// TODO Auto-generated constructor stub
	}
	
	private String name;
	private int value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
