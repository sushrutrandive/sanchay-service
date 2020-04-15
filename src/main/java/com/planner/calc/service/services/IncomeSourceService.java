package com.planner.calc.service.services;

import java.util.List;

import com.planner.calc.service.info.IncomeSourceInfo;



public interface IncomeSourceService {

	public List<IncomeSourceInfo> getIncomeSourcesByUserId(long userId);

	public IncomeSourceInfo getIncomeSourceById(long id);

	public IncomeSourceInfo updateIncomeSourceInfo(IncomeSourceInfo info);

	public IncomeSourceInfo createIncomeSourceInfo(IncomeSourceInfo info);

	public void deleteIncomeSourceInfo(long incomeSourceId);
	
	public void deleteIncomeSourceByMemberId(long memberId);

}
