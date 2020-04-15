package com.planner.calc.service.info;

public class ChildNameValueInfo {
	private String name;
	public ChildNameValueInfo(String name, int value, int parentId) {
		super();
		this.name = name;
		this.value = value;
		this.parentId = parentId;
	}

	private int value;
	private int parentId;
	
	public ChildNameValueInfo() {
		// TODO Auto-generated constructor stub
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	

}
