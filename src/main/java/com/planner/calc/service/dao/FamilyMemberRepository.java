package com.planner.calc.service.dao;

import java.util.List;

import com.planner.calc.service.exceptions.RecordNotFoundException;
import com.planner.calc.service.info.FamilyMemberInfo;



public interface FamilyMemberRepository {
	
	public List<FamilyMemberInfo> getFamilyDetailsByUserId(long userId)throws RecordNotFoundException;
	public List<FamilyMemberInfo> getAllFamilyDetailsByUserId(long userId)throws RecordNotFoundException;
	public FamilyMemberInfo getFamilyDetailsById(long id) throws RecordNotFoundException;
	public FamilyMemberInfo updateFamilyMemberInfo(FamilyMemberInfo info) throws RecordNotFoundException;
	public FamilyMemberInfo createFamilyMemberInfo(FamilyMemberInfo info);
	public void deleteFamilyMemberInfo(long memberId);
}
