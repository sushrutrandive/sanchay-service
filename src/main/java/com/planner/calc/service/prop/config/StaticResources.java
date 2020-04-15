package com.planner.calc.service.prop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class StaticResources {
	
	private String selectRelationsSql;
	private String selectOccupationsSql;
	private String selectIncomeSourcesSql ;
	private String selectExpenseCategoriesSql;
	private String selectExpenseSubCategoriesSql ;
	private String selectExpenseFrequenciesSql ;
	private String selectFixedIncomeInstrumentsSql ;
	private String selectInterestCalcMethodsSql ;
	private String selectInterestPayoutOptionsSql ;
	private String selectInvestmentOptionsSql ;
	private String selectInterestRateChangeSql;
	private String selectInterestYearRateChangeSql;
	
	private String selectPPFContributionFrequenciesSql;
	private String selectPPFExtensionOptionsSql;
	private String selectPPFExtensionPeriodSql;
	
	private String selectSSYDepositFrequencySql;
	
	public String getSelectRelationsSql() {
		return selectRelationsSql;
	}
	public void setSelectRelationsSql(String selectRelationsSql) {
		this.selectRelationsSql = selectRelationsSql;
	}
	public String getSelectOccupationsSql() {
		return selectOccupationsSql;
	}
	public void setSelectOccupationsSql(String selectOccupationsSql) {
		this.selectOccupationsSql = selectOccupationsSql;
	}
	public String getSelectIncomeSourcesSql() {
		return selectIncomeSourcesSql;
	}
	public void setSelectIncomeSourcesSql(String selectIncomeSourcesSql) {
		this.selectIncomeSourcesSql = selectIncomeSourcesSql;
	}
	public String getSelectExpenseCategoriesSql() {
		return selectExpenseCategoriesSql;
	}
	public void setSelectExpenseCategoriesSql(String selectExpenseCategoriesSql) {
		this.selectExpenseCategoriesSql = selectExpenseCategoriesSql;
	}
	public String getSelectExpenseSubCategoriesSql() {
		return selectExpenseSubCategoriesSql;
	}
	public void setSelectExpenseSubCategoriesSql(String selectExpenseSubCategoriesSql) {
		this.selectExpenseSubCategoriesSql = selectExpenseSubCategoriesSql;
	}
	public String getSelectExpenseFrequenciesSql() {
		return selectExpenseFrequenciesSql;
	}
	public void setSelectExpenseFrequenciesSql(String selectExpenseFrequenciesSql) {
		this.selectExpenseFrequenciesSql = selectExpenseFrequenciesSql;
	}
	public String getSelectFixedIncomeInstrumentsSql() {
		return selectFixedIncomeInstrumentsSql;
	}
	public void setSelectFixedIncomeInstrumentsSql(String selectFixedIncomeInstrumentsSql) {
		this.selectFixedIncomeInstrumentsSql = selectFixedIncomeInstrumentsSql;
	}
	public String getSelectInterestCalcMethodsSql() {
		return selectInterestCalcMethodsSql;
	}
	public void setSelectInterestCalcMethodsSql(String selectInterestCalcMethodsSql) {
		this.selectInterestCalcMethodsSql = selectInterestCalcMethodsSql;
	}
	public String getSelectInterestPayoutOptionsSql() {
		return selectInterestPayoutOptionsSql;
	}
	public void setSelectInterestPayoutOptionsSql(String selectInterestPayoutOptionsSql) {
		this.selectInterestPayoutOptionsSql = selectInterestPayoutOptionsSql;
	}
	public String getSelectInvestmentOptionsSql() {
		return selectInvestmentOptionsSql;
	}
	public void setSelectInvestmentOptionsSql(String selectInvestmentOptionsSql) {
		this.selectInvestmentOptionsSql = selectInvestmentOptionsSql;
	}
	public String getSelectInterestRateChangeSql() {
		return selectInterestRateChangeSql;
	}
	public void setSelectInterestRateChangeSql(String selectInterestRateChangeSql) {
		this.selectInterestRateChangeSql = selectInterestRateChangeSql;
	}
	public String getSelectInterestYearRateChangeSql() {
		return selectInterestYearRateChangeSql;
	}
	public void setSelectInterestYearRateChangeSql(String selectInterestYearRateChangeSql) {
		this.selectInterestYearRateChangeSql = selectInterestYearRateChangeSql;
	}
	public String getSelectPPFContributionFrequenciesSql() {
		return selectPPFContributionFrequenciesSql;
	}
	public void setSelectPPFContributionFrequenciesSql(String selectPPFContributionFrequenciesSql) {
		this.selectPPFContributionFrequenciesSql = selectPPFContributionFrequenciesSql;
	}
	public String getSelectPPFExtensionOptionsSql() {
		return selectPPFExtensionOptionsSql;
	}
	public void setSelectPPFExtensionOptionsSql(String selectPPFExtensionOptionsSql) {
		this.selectPPFExtensionOptionsSql = selectPPFExtensionOptionsSql;
	}
	public String getSelectPPFExtensionPeriodSql() {
		return selectPPFExtensionPeriodSql;
	}
	public void setSelectPPFExtensionPeriodSql(String selectPPFExtensionPeriodSql) {
		this.selectPPFExtensionPeriodSql = selectPPFExtensionPeriodSql;
	}
	public String getSelectSSYDepositFrequencySql() {
		return selectSSYDepositFrequencySql;
	}
	public void setSelectSSYDepositFrequencySql(String selectSSYDepositFrequencySql) {
		this.selectSSYDepositFrequencySql = selectSSYDepositFrequencySql;
	}

}
