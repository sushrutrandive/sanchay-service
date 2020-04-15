package com.planner.calc.service.prop.config;

import org.springframework.stereotype.Component;

@Component
public class Income {
	
	private String selectIncomeDetailsByUserIdSql;
	private String selectIncomeDetailsByIdSql;
	private String insertIncomeDetailsSql;
	private String updateIncomeDetailsSql;
	private String deleteIncomeDetailsSql;
	private String deleteIncomeDetailsByMemberIdSql;
	public String getSelectIncomeDetailsByUserIdSql() {
		return selectIncomeDetailsByUserIdSql;
	}
	public void setSelectIncomeDetailsByUserIdSql(String selectIncomeDetailsByUserIdSql) {
		this.selectIncomeDetailsByUserIdSql = selectIncomeDetailsByUserIdSql;
	}
	public String getSelectIncomeDetailsByIdSql() {
		return selectIncomeDetailsByIdSql;
	}
	public void setSelectIncomeDetailsByIdSql(String selectIncomeDetailsByIdSql) {
		this.selectIncomeDetailsByIdSql = selectIncomeDetailsByIdSql;
	}
	public String getInsertIncomeDetailsSql() {
		return insertIncomeDetailsSql;
	}
	public void setInsertIncomeDetailsSql(String insertIncomeDetailsSql) {
		this.insertIncomeDetailsSql = insertIncomeDetailsSql;
	}
	public String getUpdateIncomeDetailsSql() {
		return updateIncomeDetailsSql;
	}
	public void setUpdateIncomeDetailsSql(String updateIncomeDetailsSql) {
		this.updateIncomeDetailsSql = updateIncomeDetailsSql;
	}
	public String getDeleteIncomeDetailsSql() {
		return deleteIncomeDetailsSql;
	}
	public void setDeleteIncomeDetailsSql(String deleteIncomeDetailsSql) {
		this.deleteIncomeDetailsSql = deleteIncomeDetailsSql;
	}
	public String getDeleteIncomeDetailsByMemberIdSql() {
		return deleteIncomeDetailsByMemberIdSql;
	}
	public void setDeleteIncomeDetailsByMemberIdSql(String deleteIncomeDetailsByMemberIdSql) {
		this.deleteIncomeDetailsByMemberIdSql = deleteIncomeDetailsByMemberIdSql;
	}
	
	

}
