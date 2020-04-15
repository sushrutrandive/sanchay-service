package com.planner.calc.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planner.calc.service.dao.IncomeSourceRepository;
import com.planner.calc.service.info.IncomeSourceInfo;
import com.planner.calc.service.services.IncomeSourceService;


@Service
@Transactional
public class IncomeSourceServiceImpl implements IncomeSourceService{
	
	@Autowired
	private IncomeSourceRepository incomeSourceRepository;
	
	public IncomeSourceServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IncomeSourceInfo createIncomeSourceInfo(IncomeSourceInfo info) {
		// TODO Auto-generated method stub
		return this.incomeSourceRepository.createIncomeSourceInfo(info);
	}
	@Override
	public IncomeSourceInfo updateIncomeSourceInfo(IncomeSourceInfo info) {
		// TODO Auto-generated method stub
		return this.incomeSourceRepository.updateIncomeSourceInfo(info);
	}
	@Override
	public void deleteIncomeSourceInfo(long incomeSourceId) {
		this.incomeSourceRepository.deleteIncomeSourceInfo(incomeSourceId);
		
	}
	@Override
	public IncomeSourceInfo getIncomeSourceById(long id) {
		// TODO Auto-generated method stub
		return this.incomeSourceRepository.getIncomeSourceById(id);
	} 
	@Override
	public List<IncomeSourceInfo> getIncomeSourcesByUserId(long userId) {
		// TODO Auto-generated method stub
		return this.incomeSourceRepository.getIncomeSourcesByUserId(userId);
	}
	@Override
	public void deleteIncomeSourceByMemberId(long memberId) {
		this.incomeSourceRepository.deleteIncomeSourceByMemberId(memberId);
		
	}

}
