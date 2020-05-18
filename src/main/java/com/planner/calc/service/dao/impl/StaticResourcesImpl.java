package com.planner.calc.service.dao.impl;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.planner.calc.service.dao.StaticResources;
import com.planner.calc.service.info.ChildNameValueInfo;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.InterestRateChangeInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.prop.config.AppSql;


@Repository
public class StaticResourcesImpl implements StaticResources {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AppSql appSql;

	
	@Override
	public List<NameValueInfo> getOccupations() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectOccupationsSql(), new NameValueRowMapper());
	}
	
	@Override
	public List<NameValueInfo> getReleations() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectRelationsSql(), new NameValueRowMapper());
	}
	
	@Override
	public List<NameValueInfo> getExpensesCategories() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectExpenseCategoriesSql(), new NameValueRowMapper());
	}
	@Override
	public List<NameValueInfo> getIncomeSources() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectIncomeSourcesSql(), new NameValueRowMapper());
	}
	
	@Override
	public List<ChildNameValueInfo> getExpensesSubCategories() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectExpenseSubCategoriesSql(), new ChildNameValueRowMapper());
	}
	
	@Override
	public List<FrequencyInfo> getFrequencies() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectExpenseFrequenciesSql(), new FrequencyRowMapper());
	}
	
	@Override
	public List<NameValueInfo> getFixedIncomeInstruments() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectFixedIncomeInstrumentsSql(), new NameValueRowMapper());
	}
	@Override
	public List<NameValueInfo> getInterestCalcMethods() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectInterestCalcMethodsSql(), new NameValueRowMapper());
	}
	@Override
	public List<NameValueInfo> getInterestPaymentOptions() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectInterestPayoutOptionsSql(), new NameValueRowMapper());
	}
	
	@Override
	public List<NameValueInfo> getInvestmentModes() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectInvestmentOptionsSql(), new NameValueRowMapper());
	}
	
	@Override
	public InterestRateChangeInfo getInterestRateChange() {
		// TODO Auto-generated method stub
		List<InterestRateChangeInfo> list =  jdbcTemplate.query(this.appSql.getStaticResources().getSelectInterestRateChangeSql(), new InterestRateChangeRowMapper());
		return list.get(0);
	}
	
	@Override
	public List<InterestRateChangeInfo> getInterestRateChangeDetails(Date date) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectInterestYearRateChangeSql(), new Object[] { date  }, new InterestRateChangeRowMapper());
		
	}
	@Override
	public List<NameValueInfo> getPPFExtensionPeriods() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectPPFExtensionPeriodSql(), new NameValueRowMapper());
	}
	@Override
	public List<NameValueInfo> getPPFContributionFrequencies() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectPPFContributionFrequenciesSql(), new NameValueRowMapper());
	}
	@Override
	public List<NameValueInfo> getPPFExtensionOptions() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectPPFExtensionOptionsSql(), new NameValueRowMapper());
	}
	
	@Override
	public List<NameValueInfo> getSSYDepositFrequencyOptions() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectSSYDepositFrequencySql(), new NameValueRowMapper());
	}
	
	@Override
	public List<NameValueInfo> getLoanPPFrequencyOptions() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(this.appSql.getStaticResources().getSelectLoanPPFrequencySql(), new NameValueRowMapper());
	}

}

class NameValueRowMapper implements RowMapper<NameValueInfo>{
	@Override
	public NameValueInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		NameValueInfo info = new NameValueInfo();
		info.setName(rs.getString("name"));
		info.setValue(rs.getInt("value"));
		return info;
	}
}

class FrequencyRowMapper implements RowMapper<FrequencyInfo>{
	@Override
	public FrequencyInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		FrequencyInfo info = new FrequencyInfo();
		info.setName(rs.getString("name"));
		info.setValue(rs.getInt("value"));
		info.setMultiplyFactor(rs.getInt("factor"));
		return info;
	}
}

class ChildNameValueRowMapper implements RowMapper<ChildNameValueInfo>{
	@Override
	public ChildNameValueInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		ChildNameValueInfo info = new ChildNameValueInfo();
		info.setName(rs.getString("name"));
		info.setValue(rs.getInt("value"));
		info.setParentId(rs.getInt("category_id"));
		return info;
	}
}

class InterestRateChangeRowMapper implements RowMapper<InterestRateChangeInfo>{
	@Override
	public InterestRateChangeInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		InterestRateChangeInfo info = new InterestRateChangeInfo();
		//info.setId(rs.getLong("id"));
		info.setStartDate(rs.getDate("start_date"));
		info.setEndDate(rs.getDate("end_date"));
		info.setEpfRate(rs.getDouble("epf_rate"));
		info.setPpfRate(rs.getDouble("ppf_rate"));
		info.setKvpRate(rs.getDouble("kvp_rate"));
		info.setSsyRate(rs.getDouble("ssy_rate"));
		return info;
	}
}

