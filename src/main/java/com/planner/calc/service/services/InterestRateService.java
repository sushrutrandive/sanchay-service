package com.planner.calc.service.services;

import java.time.LocalDate;
import java.util.List;

import com.planner.calc.service.info.InterestRateChangeInfo;

public interface InterestRateService {
	
	public double getEPFInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,InterestRateChangeInfo latestRate);
	public double getPPFInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,InterestRateChangeInfo latestRate);
	public double getSSYInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,InterestRateChangeInfo latestRate);
}
