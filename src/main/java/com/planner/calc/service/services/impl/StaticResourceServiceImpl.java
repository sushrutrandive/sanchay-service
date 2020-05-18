package com.planner.calc.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planner.calc.service.dao.StaticResources;
import com.planner.calc.service.info.ChildNameValueInfo;
import com.planner.calc.service.info.ApplicationStaticData;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.services.StaticResourceService;



@Service
@Transactional
public class StaticResourceServiceImpl implements  StaticResourceService{
	
	@Autowired
	private StaticResources staticResource;
	@Override
	public List<NameValueInfo> getOccupations() {
		// TODO Auto-generated method stub
		return this.staticResource.getOccupations();
	}
	
	@Override
	public List<NameValueInfo> getReleations() {
		// TODO Auto-generated method stub
		return this.staticResource.getReleations();
	}
	
	@Override
	public List<NameValueInfo> getExpensesCategories() {
		// TODO Auto-generated method stub
		return this.staticResource.getExpensesCategories();
	}
	@Override
	public List<ChildNameValueInfo> getExpensesSubCategories() {
		// TODO Auto-generated method stub
		return this.staticResource.getExpensesSubCategories();
	}
	@Override
	public List<NameValueInfo> getIncomeSources() {
		// TODO Auto-generated method stub
		return this.staticResource.getIncomeSources();
	}
	
	@Override
	public List<FrequencyInfo> getFrequencies() {
		// TODO Auto-generated method stub
		return this.staticResource.getFrequencies();
	}
	
	@Override
	public ApplicationStaticData getFixedIncomeResources() {
		
		ApplicationStaticData resources = new ApplicationStaticData();
		// TODO Auto-generated method stub
		 List<NameValueInfo> fixedIncomeInstruments = this.staticResource.getFixedIncomeInstruments();
		 List<NameValueInfo> interstCalcMethods = this.staticResource.getInterestCalcMethods();
		 List<NameValueInfo> interestPayoutOptions = this.staticResource.getInterestPaymentOptions();
		 List<NameValueInfo> investmentModeOptions = this.staticResource.getInvestmentModes();		
		 InterestRateChangeInfo rateChange = this.staticResource.getInterestRateChange();
		 List<NameValueInfo> ppfContributionFrequenciesOptions = this.staticResource.getPPFContributionFrequencies();
		 List<NameValueInfo> ppfExtentionOptions = this.staticResource.getPPFExtensionOptions();
		 List<NameValueInfo> ppfExtenstionPeriodOptions = this.staticResource.getPPFExtensionPeriods();
		 List<NameValueInfo> ssyDepositFrequencyOptions = this.staticResource.getSSYDepositFrequencyOptions();
		 List<NameValueInfo> loanPPFrequencyOptions = this.staticResource.getLoanPPFrequencyOptions();
		 
		 resources.setFixedIncomeInstrumentList(fixedIncomeInstruments);
		 resources.setInterestCalcMethodList(interstCalcMethods);
		 resources.setInterestPayoutOptionList(interestPayoutOptions);
		 resources.setInvestmentMode(investmentModeOptions);
		 resources.setInterestChange(rateChange);
		 resources.setPpfContributionFrequencies(ppfContributionFrequenciesOptions);
		 resources.setPpfExtensionOptions(ppfExtentionOptions);
		 resources.setPpfExtensionPeriods(ppfExtenstionPeriodOptions);
		 resources.setSsyDepositFrequncyOptions(ssyDepositFrequencyOptions);
		 resources.setLoanPPFrequncyOptions(loanPPFrequencyOptions);
		 return resources;
	}

}
