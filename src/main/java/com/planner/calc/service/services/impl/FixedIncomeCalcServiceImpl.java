package com.planner.calc.service.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.calc.service.calculators.CalculatorContext;
import com.planner.calc.service.calculators.EPFCalculator;
import com.planner.calc.service.calculators.FixedDepositCalculator;
import com.planner.calc.service.calculators.PPFCalculator;
import com.planner.calc.service.calculators.RDCalculator;
import com.planner.calc.service.exceptions.InvalidParameterException;
import com.planner.calc.service.exceptions.RequiredParametersMissingException;
import com.planner.calc.service.info.EPFCalcInfo;
import com.planner.calc.service.info.FixedDepositCalcInfo;
import com.planner.calc.service.info.CalculatorInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.info.PFTransactionInfo;
import com.planner.calc.service.info.PPFCalcInfo;
import com.planner.calc.service.info.RDCalcInfo;
import com.planner.calc.service.info.SSYCalcInfo;
import com.planner.calc.service.services.FixedIncomeCalcService;
import com.planner.calc.service.services.PFCalculatorService;
import com.planner.calc.service.services.SSYCalculatorService;
import com.planner.calc.service.util.Constants.FIXED_INCOME;
import com.planner.calc.service.util.Constants.FIXED_INCOME_INVESTMENT_MODE;
import com.planner.calc.service.util.Constants.INTEREST_CALC_MEHOD;
import com.planner.calc.service.util.Constants.PPF_CONTRIBUTION_FREQUENCY;
import com.planner.calc.service.util.Constants.PPF_EXTENSION_OPTIONS;
import com.planner.calc.service.util.Constants.SSY_CONTRIBUTION_FREQUENCY;
import com.planner.calc.service.util.DateUtil;
import com.planner.calc.service.util.ErrorCodes;
import com.planner.calc.service.util.InterestCalcMethodUtil;

@Service
public class FixedIncomeCalcServiceImpl implements FixedIncomeCalcService {

	@Autowired
	private PFCalculatorService epfCalculatorService;

	@Autowired
	private SSYCalculatorService ssyCalculatorService;

	@Override
	public CalculatorInfo calculate(CalculatorInfo info) {

		FIXED_INCOME type = FIXED_INCOME.fromInteger(info.getInstrument().getValue());
		switch (type) {
		case FIXED_DEPOSIT:
			return fdCalculation(info);
		case RECURRING_DEPOSIT:
			return rdCalculation(info);
		case EPF:
			return epfCalculation(info);
		case PPF:
			return ppfCalculation(info);
		case SSY:
			return ssyCalculation(info);
		default:
			throw new InvalidParameterException("Invlid instrument type.");
		}

	}

	private CalculatorInfo ppfCalculation(CalculatorInfo calcInfo) {

		PPFCalcInfo info = calcInfo.getPpfCalcInfo();

		int terms = 15;
		info.setOriginalTerms(terms);

		if (info.getExtensionPeriodOption() != null
				&& PPF_EXTENSION_OPTIONS.NO_EXTENSION.getValue() != info.getExtensionPeriodOption().getValue()) {
			terms = terms + info.getExtensionPeriod();

		}
		info.setTerms(terms);
		if (PPF_CONTRIBUTION_FREQUENCY.MONTHLY_AFTER_CUT_OFF_DATE.getValue() == info.getContributionFrequency()
				.getValue()
				|| PPF_CONTRIBUTION_FREQUENCY.MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE.getValue() == info
						.getContributionFrequency().getValue()) {
			double total = info.getContributionAmount() * 12;
			if (total > 150000) {
				throw new InvalidParameterException(ErrorCodes.PPF_MAX_AMOUNT);
			}
		} else if (PPF_CONTRIBUTION_FREQUENCY.ANNUALLY_END_OF_FY.getValue() == info.getContributionFrequency()
				.getValue()
				|| PPF_CONTRIBUTION_FREQUENCY.ANNUALLY_START_OF_FY.getValue() == info.getContributionFrequency()
						.getValue()) {

			if (info.getContributionAmount() > 150000) {
				throw new InvalidParameterException(ErrorCodes.PPF_MAX_AMOUNT);
			}
		}

		checkAccountBalance(info.getStartDate(), info.getBalance());
		PPFCalcInfo result = epfCalculatorService.calculatePPF(info);
		calcInfo.setPpfCalcInfo(result);

		return calcInfo;
	}

	private CalculatorInfo ssyCalculation(CalculatorInfo calcInfo) {

		SSYCalcInfo info = calcInfo.getSsyCalcInfo();

		int terms = 21;
		info.setTerms(terms);

		if (SSY_CONTRIBUTION_FREQUENCY.MONTHLY_AFTER_CUT_OFF_DATE.getValue() == info.getContributionFrequency()
				.getValue()
				|| SSY_CONTRIBUTION_FREQUENCY.MONTHLY_ON_OR_BEFORE_CUT_OFF_DATE.getValue() == info
						.getContributionFrequency().getValue()) {
			double total = info.getContributionAmount() * 12;
			if (total > 150000) {
				throw new InvalidParameterException(ErrorCodes.SSY_MAX_AMOUNT);
			}
		} else if (SSY_CONTRIBUTION_FREQUENCY.ANNUALLY_END_OF_FY.getValue() == info.getContributionFrequency()
				.getValue()
				|| SSY_CONTRIBUTION_FREQUENCY.ANNUALLY_START_OF_FY.getValue() == info.getContributionFrequency()
						.getValue()) {

			if (info.getContributionAmount() > 150000) {
				throw new InvalidParameterException(ErrorCodes.SSY_MAX_AMOUNT);
			}
		}
		checkAccountBalance(info.getStartDate(), info.getBalance());
		SSYCalcInfo result = ssyCalculatorService.calculateSSY(info);
		calcInfo.setSsyCalcInfo(result);
		
		

		return calcInfo;
	}

	private CalculatorInfo epfCalculation(CalculatorInfo calcInfo) {

		EPFCalcInfo info = calcInfo.getEpfCalcInfo();
		info.setInterestCalcMethod(InterestCalcMethodUtil.interestCalcMethodCompoundAnnually());

		if (info.getStartDate() == null) {
			throw new InvalidParameterException(ErrorCodes.INVALID_START_DATE);
		}

		if (info.getTerms() < 1) {
			throw new InvalidParameterException(ErrorCodes.INVALID_TERM);
		}

		LocalDate end = LocalDate.now().withDayOfMonth(1);
		end = end.plusMonths(info.getTerms());
		int length = end.lengthOfMonth();
		end = end.withDayOfMonth(length);
		Date endDate = Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant());
		info.setEndDate(endDate);

		EPFCalcInfo result = epfCalculatorService.calculateEPF(info);
		calcInfo.setEpfCalcInfo(result);

		/*
		 * info.setCurrentValue(calcInfo.getCurrentValue());
		 * info.setMaturityAmount(calcInfo.getMaturityAmount());
		 * info.setMaturityAsOfDate(calcInfo.getMaturityAsOfDate());
		 * info.setCurrentAsOfDate(calcInfo.getCurrentAsOfDate());
		 * info.getPFTransactionList().addAll(calcInfo.getTransactionList());
		 */

		return calcInfo;
	}

	private CalculatorInfo nscCalculation(CalculatorInfo info) {
		// For NSC interest calc method is compound semi-annually
		if (info.getInterestCalcMethod() == null
				|| info.getInterestCalcMethod().getValue() != INTEREST_CALC_MEHOD.CONMPOND_SEMI_ANNUALLY.getValue()) {
			throw new InvalidParameterException("Invalid Interest Calculation Method");
		}
		if (info.getStartDate() == null || info.getInterestCalcMethod() == null) {
			throw new RequiredParametersMissingException();
		}
		if (info.getPrincipalAmount() == 0 || info.getInterestRate() == 0) {
			throw new RequiredParametersMissingException();
		}

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(info.getStartDate());

		LocalDate end = LocalDate.now();
		end = end.withYear(startCal.get((Calendar.MONTH) + 1));
		end = end.withYear(startCal.get(Calendar.YEAR));
		end = end.withDayOfMonth(startCal.get(Calendar.DAY_OF_MONTH));
		end = end.plusMonths(info.getTerms());
		if (end.compareTo(LocalDate.now()) <= 0) {
			throw new InvalidParameterException("End Date should not be less than or equal to current date.");
		}

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(info.getStartDate());
		endDate.add(Calendar.MONTH, info.getTerms());

		FixedDepositCalcInfo calcInfo = new FixedDepositCalcInfo();
		calcInfo.setStartDate(info.getStartDate());
		calcInfo.setEndDate(endDate.getTime());
		calcInfo.setInterestCalcMethod(info.getInterestCalcMethod());
		calcInfo.setInterestRate(info.getInterestRate());
		calcInfo.setPrincipalAmount(info.getPrincipalAmount());
		CalculatorContext<FixedDepositCalcInfo> context = new CalculatorContext<>(new FixedDepositCalculator());
		calcInfo = context.calulateAmount(calcInfo);
		info.setCurrentValue(calcInfo.getCurrentValue());
		info.setMaturityAmount(calcInfo.getMaturityAmount());
		info.setCurrentAsOfDate(null);
		info.setMaturityAsOfDate(null);
		return info;
	}

	private CalculatorInfo rdCalculation(CalculatorInfo calcInfo) {

		RDCalcInfo info = calcInfo.getRdCalcInfo();
		if (info.getInterestCalcMethod() == null
				|| info.getInterestCalcMethod().getValue() != INTEREST_CALC_MEHOD.CONMPOND_QUARTERLY.getValue()) {
			throw new InvalidParameterException("Invalid Interest Calculation Method");
		}

		if (info.getTerms() == 0 || info.getPrincipalAmount() == 0 || info.getInterestRate() == 0
				|| info.getStartDate() == null) {
			throw new RequiredParametersMissingException();
		}

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(info.getStartDate());

		LocalDate end = LocalDate.now();
		end = end.withYear(startCal.get((Calendar.MONTH) + 1));
		end = end.withYear(startCal.get(Calendar.YEAR));
		end = end.withDayOfMonth(startCal.get(Calendar.DAY_OF_MONTH));
		end = end.plusMonths(info.getTerms());
		if (end.compareTo(LocalDate.now()) <= 0) {
			throw new InvalidParameterException("End Date should not be less than or equal to current date.");
		}

		CalculatorContext<RDCalcInfo> context = new CalculatorContext<>(new RDCalculator());
		RDCalcInfo calcInfo1 = context.calulateAmount(info);
		// info.setCurrentValue(calcInfo.getCurrentValue());
		// info.setMaturityAmount(calcInfo.getMaturityAmount());
		calcInfo.setRdCalcInfo(calcInfo1);

		return calcInfo;
	}

	private CalculatorInfo fdCalculation(CalculatorInfo calcInfo) {
		FixedDepositCalcInfo info = calcInfo.getFdCalcInfo();
		if (info.getStartDate() == null || info.getEndDate() == null || info.getInterestCalcMethod() == null) {
			throw new RequiredParametersMissingException();
		}
		if (info.getPrincipalAmount() == 0 || info.getInterestRate() == 0) {
			throw new RequiredParametersMissingException();
		}

		if (info.getInterestCalcMethod().getValue() < 1 || info.getInterestCalcMethod().getValue() > 5) {
			throw new InvalidParameterException("Incorrect Interest Calculation Method. ");
		}

		CalculatorContext<FixedDepositCalcInfo> context = new CalculatorContext<>(new FixedDepositCalculator());
		FixedDepositCalcInfo calcInfo1 = context.calulateAmount(info);
		calcInfo.setFdCalcInfo(calcInfo1);
		return calcInfo;
	}
	
	private void checkAccountBalance(Date startDate, double accountBalance) {
		Date lastFinancialYearDate = DateUtil.getLastFinancialYearEndDate();
		if (DateUtil.after(startDate, lastFinancialYearDate) && accountBalance > 0) {
			throw new InvalidParameterException(ErrorCodes.ACCT_BALANCE_ZERO);
		}
	}

}
