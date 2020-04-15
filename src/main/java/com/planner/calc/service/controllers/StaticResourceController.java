package com.planner.calc.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.info.ChildNameValueInfo;
import com.planner.calc.service.info.ApplicationStaticData;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.services.StaticResourceService;



@RestController
@RequestMapping(value="api/goldensource")
public class StaticResourceController {
	
	@Autowired
	private StaticResourceService staticResourceService;

	@RequestMapping(value = "/occupations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NameValueInfo> occupation() {
		return staticResourceService.getOccupations();
	}
	@RequestMapping(value = "/relationships", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NameValueInfo> relations() {
		return staticResourceService.getReleations();
	}
	
	@RequestMapping(value = "/incomesources", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NameValueInfo> incomeSources() {
		return staticResourceService.getIncomeSources();
	}
	@RequestMapping(value = "/expensecategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NameValueInfo> expenseCategories() {
		return staticResourceService.getExpensesCategories();
	}
	@RequestMapping(value = "/expensesubcategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChildNameValueInfo> expenseSubCategories() {
		return staticResourceService.getExpensesSubCategories();
	}
	@RequestMapping(value = "/frequencies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FrequencyInfo> frequencies() {
		return staticResourceService.getFrequencies();
	}
	
	@RequestMapping(value = "/applicationdata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApplicationStaticData fixedIncomeInstruments() {
		return staticResourceService.getFixedIncomeResources();
	}
}
