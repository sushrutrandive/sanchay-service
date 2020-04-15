package com.planner.calc.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planner.calc.service.dao.FamilyMemberRepository;
import com.planner.calc.service.exceptions.InvalidParameterException;
import com.planner.calc.service.info.FamilyMemberInfo;
import com.planner.calc.service.services.FamilyMemberService;
import com.planner.calc.service.services.IncomeSourceService;
import com.planner.calc.service.util.DateUtil;


@Service
@Transactional
public class FamilyMemberServiceImpl implements FamilyMemberService {
	@Autowired
	private FamilyMemberRepository familyMemberRepository;
	
	@Autowired
	private IncomeSourceService incomeSourceService;
	
	@Override
	public List<FamilyMemberInfo> getFamilyDetailsByUserId(long userId) {
		// TODO Auto-generated method stub
		return familyMemberRepository.getFamilyDetailsByUserId(userId);
	}
	
	@Override
	public FamilyMemberInfo getFamilyDetailsById(long id) {
		// TODO Auto-generated method stub
		return familyMemberRepository.getFamilyDetailsById(id);
	}
	
	@Override
	public FamilyMemberInfo createFamilyMemberInfo(FamilyMemberInfo info) {
		// TODO Auto-generated method stub
		if(DateUtil.afterToday(info.getDateOfBirth())){
			throw new InvalidParameterException("Birth date should not be future date.");
			
		}
		return this.familyMemberRepository.createFamilyMemberInfo(info);
	}
	
	@Override
	public FamilyMemberInfo updateFamilyMemberInfo(FamilyMemberInfo info) {
		// TODO Auto-generated method stub
		if(DateUtil.afterToday(info.getDateOfBirth())){
			throw new InvalidParameterException("Birth date should not be future date.");
			
		}
		return this.familyMemberRepository.updateFamilyMemberInfo(info);
	}
	
	@Override
	public void deleteFamilyMemberInfo(long memberId) {
		// TODO Auto-generated method stub
		// delete the Income sources attached with family member first
		incomeSourceService.deleteIncomeSourceByMemberId(memberId);
		this.familyMemberRepository.deleteFamilyMemberInfo(memberId);
	}
	
	@Override
	public List<FamilyMemberInfo> getAllFamilyDetailsByUserId(long userId) {
		// TODO Auto-generated method stub
		return this.familyMemberRepository.getAllFamilyDetailsByUserId(userId);
	}

}
