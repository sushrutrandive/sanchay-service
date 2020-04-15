package com.planner.calc.service.dao;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import com.planner.calc.service.info.ChildNameValueInfo;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.info.NameValueInfo;


public interface StaticResources {
	
	public List<NameValueInfo> getReleations();
	public List<NameValueInfo> getOccupations();
	public List<NameValueInfo> getIncomeSources();
	public List<NameValueInfo> getExpensesCategories();
	public List<ChildNameValueInfo> getExpensesSubCategories();
	public List<FrequencyInfo> getFrequencies();
	public List<NameValueInfo>  getFixedIncomeInstruments();
	public List<NameValueInfo>  getInterestCalcMethods();
	public List<NameValueInfo>  getInterestPaymentOptions();
	public List<NameValueInfo> getInvestmentModes();
	public InterestRateChangeInfo getInterestRateChange();
	public List<InterestRateChangeInfo> getInterestRateChangeDetails(Date date);
	public List<NameValueInfo> getPPFContributionFrequencies();
	public List<NameValueInfo> getPPFExtensionOptions();
	public List<NameValueInfo> getPPFExtensionPeriods();
	
	public List<NameValueInfo> getSSYDepositFrequencyOptions();
	


}
