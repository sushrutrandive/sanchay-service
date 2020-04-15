package com.planner.calc.service.services;

import java.util.List;

import com.planner.calc.service.info.ChildNameValueInfo;
import com.planner.calc.service.info.ApplicationStaticData;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.NameValueInfo;


public interface StaticResourceService {
	public List<NameValueInfo> getReleations();
	public List<NameValueInfo> getOccupations();
	public List<NameValueInfo> getIncomeSources();
	public List<NameValueInfo> getExpensesCategories();
	public List<ChildNameValueInfo> getExpensesSubCategories();
	public List<FrequencyInfo> getFrequencies();
	public ApplicationStaticData getFixedIncomeResources();
	
	
}
