package com.planner.calc.service.prop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Expense {
	
	private String selectExpensesDetailsByUserIdSql;
	private String selectExpensesDetailsByIdSql;
	private String insertExpensesDetailsSql ;
	private String updateExpensesDetailsSql;
	private String deleteExpensesDetailsSql;
	public String getSelectExpensesDetailsByUserIdSql() {
		return selectExpensesDetailsByUserIdSql;
	}
	public void setSelectExpensesDetailsByUserIdSql(String selectExpensesDetailsByUserIdSql) {
		this.selectExpensesDetailsByUserIdSql = selectExpensesDetailsByUserIdSql;
	}
	public String getSelectExpensesDetailsByIdSql() {
		return selectExpensesDetailsByIdSql;
	}
	public void setSelectExpensesDetailsByIdSql(String selectExpensesDetailsByIdSql) {
		this.selectExpensesDetailsByIdSql = selectExpensesDetailsByIdSql;
	}
	public String getInsertExpensesDetailsSql() {
		return insertExpensesDetailsSql;
	}
	public void setInsertExpensesDetailsSql(String insertExpensesDetailsSql) {
		this.insertExpensesDetailsSql = insertExpensesDetailsSql;
	}
	public String getUpdateExpensesDetailsSql() {
		return updateExpensesDetailsSql;
	}
	public void setUpdateExpensesDetailsSql(String updateExpensesDetailsSql) {
		this.updateExpensesDetailsSql = updateExpensesDetailsSql;
	}
	public String getDeleteExpensesDetailsSql() {
		return deleteExpensesDetailsSql;
	}
	public void setDeleteExpensesDetailsSql(String deleteExpensesDetailsSql) {
		this.deleteExpensesDetailsSql = deleteExpensesDetailsSql;
	}

}
