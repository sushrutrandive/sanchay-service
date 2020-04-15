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
import com.planner.calc.service.info.IncomeSourceInfo;
import com.planner.calc.service.services.IncomeSourceService;
import com.planner.calc.service.services.UserService;
import com.planner.calc.service.util.UserUtil;



@RestController
@RequestMapping(value = "api/incomesources")
public class IncomeSourceController {

	@Autowired
	private IncomeSourceService incomeSourceService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IncomeSourceInfo> getDetails(HttpServletRequest request) {
		
		return incomeSourceService.getIncomeSourcesByUserId(UserUtil.getUserId());
	}
	
	@RequestMapping(value="/incomesource/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public IncomeSourceInfo getDetailsById(@PathVariable("id") long incomeSourceId) {
		
		return incomeSourceService.getIncomeSourceById(incomeSourceId);
	}
	
	@RequestMapping(value="/incomesource", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public IncomeSourceInfo saveIncomeSource(HttpServletRequest request,@RequestBody IncomeSourceInfo info) {
		
		info.setUserId(UserUtil.getUserId());
		return incomeSourceService.createIncomeSourceInfo(info);
	}
	
	@RequestMapping(value="/incomesource", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public IncomeSourceInfo updateIncomeSource(HttpServletRequest request,@RequestBody IncomeSourceInfo info) {
		
		info.setUserId(UserUtil.getUserId() );
		return incomeSourceService.updateIncomeSourceInfo(info);
	}
	
	@RequestMapping(value="/incomesource/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteIncomeSource(HttpServletRequest request,@PathVariable("id") long incomeSourceId) {
		//String tokenPayload = request.getHeader(WebSecurityConfiguration.AUTHENTICATION_HEADER_NAME);
		//info.setUserId(userService.getUserIdByToken(tokenPayload));
		incomeSourceService.deleteIncomeSourceInfo(incomeSourceId);
	}

}
