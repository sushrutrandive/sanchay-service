package com.planner.calc.service.info;

public class FrequencyInfo {
	private String name;
	private int value;
	private int multiplyFactor;
	
	public FrequencyInfo() {
		// TODO Auto-generated constructor stub
	}
	public FrequencyInfo(String name, int value, int multiplyFactor) {
		super();
		this.name = name;
		this.value = value;
		this.multiplyFactor = multiplyFactor;
	}
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
	public int getMultiplyFactor() {
		return multiplyFactor;
	}
	public void setMultiplyFactor(int multiplyFactor) {
		this.multiplyFactor = multiplyFactor;
	}
	

}
