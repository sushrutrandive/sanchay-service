package com.planner.calc.service.dao;

import java.util.List;

import com.planner.calc.service.exceptions.RecordNotFoundException;
import com.planner.calc.service.info.IncomeSourceInfo;



public interface IncomeSourceRepository {

	public List<IncomeSourceInfo> getIncomeSourcesByUserId(long userId) throws RecordNotFoundException;

	public IncomeSourceInfo getIncomeSourceById(long id) throws RecordNotFoundException;

	public IncomeSourceInfo updateIncomeSourceInfo(IncomeSourceInfo info) throws RecordNotFoundException;

	public IncomeSourceInfo createIncomeSourceInfo(IncomeSourceInfo info);

	public void deleteIncomeSourceInfo(long incomeSourceId);
	
	public void deleteIncomeSourceByMemberId(long memberId);

}
