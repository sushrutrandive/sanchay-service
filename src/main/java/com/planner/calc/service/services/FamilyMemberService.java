package com.planner.calc.service.services;

import java.util.List;


import com.planner.calc.service.info.FamilyMemberInfo;



public interface FamilyMemberService {

	public List<FamilyMemberInfo> getFamilyDetailsByUserId(long userId);
	public FamilyMemberInfo getFamilyDetailsById(long id);
	public List<FamilyMemberInfo> getAllFamilyDetailsByUserId(long userId);
	public FamilyMemberInfo updateFamilyMemberInfo(FamilyMemberInfo info);
	public FamilyMemberInfo createFamilyMemberInfo(FamilyMemberInfo info);
	public void deleteFamilyMemberInfo(long id);
}
