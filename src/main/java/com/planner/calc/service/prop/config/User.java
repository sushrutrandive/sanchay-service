package com.planner.calc.service.prop.config;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String selectUserByIdSql;
	private String selelctAuthenticateUser;
	private String insertTokenSql;
	private String selectTokenByUserName;
	private String deleteTokenByUserName;
	private String selectUserByUserName;
	public String getSelectUserByIdSql() {
		return selectUserByIdSql;
	}
	public void setSelectUserByIdSql(String selectUserByIdSql) {
		this.selectUserByIdSql = selectUserByIdSql;
	}
	public String getSelelctAuthenticateUser() {
		return selelctAuthenticateUser;
	}
	public void setSelelctAuthenticateUser(String selelctAuthenticateUser) {
		this.selelctAuthenticateUser = selelctAuthenticateUser;
	}
	public String getInsertTokenSql() {
		return insertTokenSql;
	}
	public void setInsertTokenSql(String insertTokenSql) {
		this.insertTokenSql = insertTokenSql;
	}
	public String getSelectTokenByUserName() {
		return selectTokenByUserName;
	}
	public void setSelectTokenByUserName(String selectTokenByUserName) {
		this.selectTokenByUserName = selectTokenByUserName;
	}
	public String getDeleteTokenByUserName() {
		return deleteTokenByUserName;
	}
	public void setDeleteTokenByUserName(String deleteTokenByUserName) {
		this.deleteTokenByUserName = deleteTokenByUserName;
	}
	public String getSelectUserByUserName() {
		return selectUserByUserName;
	}
	public void setSelectUserByUserName(String selectUserByUserName) {
		this.selectUserByUserName = selectUserByUserName;
	}

}
