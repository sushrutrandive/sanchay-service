package com.planner.calc.service.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationStaticData {
	
	private List<NameValueInfo> fixedIncomeInstrumentList =  new ArrayList<>();
	private List<NameValueInfo> interestCalcMethodList =  new ArrayList<>();
	private List<NameValueInfo> interestPayoutOptionList =  new ArrayList<>();
	private List<NameValueInfo> investmentModeList =  new ArrayList<>();
	private InterestRateChangeInfo interestChange = new InterestRateChangeInfo();
	private List<NameValueInfo> ppfContributionFrequencies=  new ArrayList<>();
	private List<NameValueInfo> ppfExtensionOptions=  new ArrayList<>();
	private List<NameValueInfo> ppfExtensionPeriods=  new ArrayList<>();
	private List<NameValueInfo> ssyDepositFrequncyOptions=  new ArrayList<>();
	private List<NameValueInfo> loanPPFrequncyOptions=  new ArrayList<>();
	
	private LocalDate currentDate;
	
	public InterestRateChangeInfo getInterestChange() {
		return interestChange;
	}
	public void setInterestChange(InterestRateChangeInfo interestChange) {
		this.interestChange = interestChange;
	}
	public List<NameValueInfo> getFixedIncomeInstrumentList() {
		return fixedIncomeInstrumentList;
	}
	public void setFixedIncomeInstrumentList(List<NameValueInfo> fixedIncomeInstrumentList) {
		this.fixedIncomeInstrumentList = fixedIncomeInstrumentList;
	}
	
	public List<NameValueInfo> getInterestCalcMethodList() {
		return interestCalcMethodList;
	}
	public void setInterestCalcMethodList(List<NameValueInfo> interestCalcMethodList) {
		this.interestCalcMethodList = interestCalcMethodList;
	}
	public List<NameValueInfo> getInterestPayoutOptionList() {
		return interestPayoutOptionList;
	}
	public void setInterestPayoutOptionList(List<NameValueInfo> interestPayoutOptionList) {
		this.interestPayoutOptionList = interestPayoutOptionList;
	}
	public List<NameValueInfo> getInvestmentMode() {
		return investmentModeList;
	}
	public void setInvestmentMode(List<NameValueInfo> investmentMode) {
		this.investmentModeList = investmentMode;
	}
	public List<NameValueInfo> getPpfContributionFrequencies() {
		return ppfContributionFrequencies;
	}
	public void setPpfContributionFrequencies(List<NameValueInfo> ppfContributionFrequencies) {
		this.ppfContributionFrequencies = ppfContributionFrequencies;
	}
	public List<NameValueInfo> getPpfExtensionOptions() {
		return ppfExtensionOptions;
	}
	public void setPpfExtensionOptions(List<NameValueInfo> ppfExtensionOptions) {
		this.ppfExtensionOptions = ppfExtensionOptions;
	}
	public List<NameValueInfo> getPpfExtensionPeriods() {
		return ppfExtensionPeriods;
	}
	public void setPpfExtensionPeriods(List<NameValueInfo> ppfExtensionPeriods) {
		this.ppfExtensionPeriods = ppfExtensionPeriods;
	}
	public LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	public List<NameValueInfo> getSsyDepositFrequncyOptions() {
		return ssyDepositFrequncyOptions;
	}
	public void setSsyDepositFrequncyOptions(List<NameValueInfo> ssyDepositFrequncyOptions) {
		this.ssyDepositFrequncyOptions = ssyDepositFrequncyOptions;
	}
	public List<NameValueInfo> getLoanPPFrequncyOptions() {
		return loanPPFrequncyOptions;
	}
	public void setLoanPPFrequncyOptions(List<NameValueInfo> loanPPFrequncyOptions) {
		this.loanPPFrequncyOptions = loanPPFrequncyOptions;
	}
	
	
	
	

}
