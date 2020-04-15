package com.planner.calc.service.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.config.WebSecurityConfiguration;
import com.planner.calc.service.info.FamilyMemberInfo;
import com.planner.calc.service.services.FamilyMemberService;
import com.planner.calc.service.services.UserService;
import com.planner.calc.service.util.UserUtil;




@RestController
@RequestMapping(value="api/familydetails")
public class FamilyMemberController {
	
	@Autowired
	private FamilyMemberService familyMemberService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FamilyMemberInfo> getDetails(HttpServletRequest request) {
	
		return familyMemberService.getFamilyDetailsByUserId(UserUtil.getUserId());
	}
	
	@RequestMapping(value="/member/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FamilyMemberInfo getDetailsById(@PathVariable("id") long memberId) {
		
		return familyMemberService.getFamilyDetailsById(memberId);
	}
	
	@RequestMapping(value="/member", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public FamilyMemberInfo saveFamilyMemberInfo(HttpServletRequest request,@RequestBody FamilyMemberInfo info) {
		
		info.setUserId(UserUtil.getUserId());
		return familyMemberService.createFamilyMemberInfo(info);
	}
	
	@RequestMapping(value="/member", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public FamilyMemberInfo updateFamilyMemberInfo(HttpServletRequest request,@RequestBody FamilyMemberInfo info) {
		
		info.setUserId(UserUtil.getUserId());
		return familyMemberService.updateFamilyMemberInfo(info);
	}
	
	@RequestMapping(value="/member/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteFamilyMemberInfo(HttpServletRequest request,@PathVariable("id") long memberId) {
		//String tokenPayload = request.getHeader(WebSecurityConfiguration.AUTHENTICATION_HEADER_NAME);
		//info.setUserId(userService.getUserIdByToken(tokenPayload));
		familyMemberService.deleteFamilyMemberInfo(memberId);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FamilyMemberInfo> getAllDetails(HttpServletRequest request) {		
		return familyMemberService.getAllFamilyDetailsByUserId(UserUtil.getUserId());
	}

}
