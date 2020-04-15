package com.planner.calc.service.prop.config;

import org.springframework.stereotype.Component;

@Component
public class Family {
	private String selelctFamilyDetailsByUserIdSql ;
	private String selelctAllFamilyDetailsByUserIdSql;
	private String selelctFamilyDetailsByIdSql;
	private String insertFamilyDetailsSql;
	private String updateFamilyDetailsSql ;
	private String deleteFamilyDetailsSql;
	public String getSelelctFamilyDetailsByUserIdSql() {
		return selelctFamilyDetailsByUserIdSql;
	}
	public void setSelelctFamilyDetailsByUserIdSql(String selelctFamilyDetailsByUserIdSql) {
		this.selelctFamilyDetailsByUserIdSql = selelctFamilyDetailsByUserIdSql;
	}
	public String getSelelctAllFamilyDetailsByUserIdSql() {
		return selelctAllFamilyDetailsByUserIdSql;
	}
	public void setSelelctAllFamilyDetailsByUserIdSql(String selelctAllFamilyDetailsByUserIdSql) {
		this.selelctAllFamilyDetailsByUserIdSql = selelctAllFamilyDetailsByUserIdSql;
	}
	public String getSelelctFamilyDetailsByIdSql() {
		return selelctFamilyDetailsByIdSql;
	}
	public void setSelelctFamilyDetailsByIdSql(String selelctFamilyDetailsByIdSql) {
		this.selelctFamilyDetailsByIdSql = selelctFamilyDetailsByIdSql;
	}
	public String getInsertFamilyDetailsSql() {
		return insertFamilyDetailsSql;
	}
	public void setInsertFamilyDetailsSql(String insertFamilyDetailsSql) {
		this.insertFamilyDetailsSql = insertFamilyDetailsSql;
	}
	public String getUpdateFamilyDetailsSql() {
		return updateFamilyDetailsSql;
	}
	public void setUpdateFamilyDetailsSql(String updateFamilyDetailsSql) {
		this.updateFamilyDetailsSql = updateFamilyDetailsSql;
	}
	public String getDeleteFamilyDetailsSql() {
		return deleteFamilyDetailsSql;
	}
	public void setDeleteFamilyDetailsSql(String deleteFamilyDetailsSql) {
		this.deleteFamilyDetailsSql = deleteFamilyDetailsSql;
	}
	
	

}
