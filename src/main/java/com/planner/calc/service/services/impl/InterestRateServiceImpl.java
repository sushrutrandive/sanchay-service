package com.planner.calc.service.services.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.dao.StaticResources;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.services.InterestRateService;
import com.planner.calc.service.util.DateUtil;

@Service
public class InterestRateServiceImpl implements InterestRateService {

	@Override
	public double getEPFInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,
			InterestRateChangeInfo latestRate) {
		double rate = latestRate.getEpfRate();
		Date date = DateUtil.asDate(transactionDate);
		for (InterestRateChangeInfo info : changes) {
			if (DateUtil.between(date, info.getStartDate(), info.getEndDate())) {
				rate = info.getEpfRate();
				break;
			}
		}
		return rate;
	}

	@Override
	public double getPPFInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,
			InterestRateChangeInfo latestRate) {
		double rate = latestRate.getPpfRate();
		Date date = DateUtil.asDate(transactionDate);
		for (InterestRateChangeInfo info : changes) {
			if (DateUtil.between(date, info.getStartDate(), info.getEndDate())) {
				rate = info.getPpfRate();
				break;
			}
		}
		return rate;
	}

	@Override
	public double getSSYInterestRateForPeriod(LocalDate transactionDate, List<InterestRateChangeInfo> changes,
			InterestRateChangeInfo latestRate) {
		// TODO Auto-generated method stub
		double rate = latestRate.getSsyRate();
		Date date = DateUtil.asDate(transactionDate);
		for (InterestRateChangeInfo info : changes) {
			if (DateUtil.between(date, info.getStartDate(), info.getEndDate())) {
				rate = info.getSsyRate();
				break;
			}
		}
		return rate;
	}

}
