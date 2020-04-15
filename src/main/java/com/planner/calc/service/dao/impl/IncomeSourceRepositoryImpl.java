package com.planner.calc.service.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.planner.calc.service.dao.IncomeSourceRepository;
import com.planner.calc.service.exceptions.RecordNotFoundException;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.IncomeSourceInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.prop.config.AppSql;
import com.planner.calc.service.util.Constants.YES_NO;
import com.planner.calc.service.util.StringUtil;



@Repository
public class IncomeSourceRepositoryImpl implements IncomeSourceRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private AppSql appSql;

	
	@Override
	public IncomeSourceInfo createIncomeSourceInfo(IncomeSourceInfo info) {
		this.jdbcTemplate.update(this.appSql.getIncome().getInsertIncomeDetailsSql(),new PreparedStatementSetter() {  
			
	           public void setValues(PreparedStatement stmt) throws SQLException {               
	               stmt.setLong(1,  info.getUserId());
	               stmt.setLong(2,  info.getIncomeSourceType().getValue());
	               stmt.setLong(3,  info.getFrequency().getValue());
	               stmt.setLong(4,  info.getMember().getValue());
	               stmt.setLong(5,  info.getIncome());
	               stmt.setLong(6,  info.getAnnualIncome());
	               stmt.setString(7,  info.getRemark());
	           }
	       });			
			return info;
	}
	@Override
	public IncomeSourceInfo updateIncomeSourceInfo(IncomeSourceInfo info) throws RecordNotFoundException {
		this.jdbcTemplate.update(this.appSql.getIncome().getUpdateIncomeDetailsSql(),new PreparedStatementSetter() { 
	           public void setValues(PreparedStatement stmt) throws SQLException {   
	               stmt.setLong(1,  info.getIncomeSourceType().getValue());
	               stmt.setLong(2,  info.getFrequency().getValue());	               
	               stmt.setLong(3,  info.getIncome());
	               stmt.setLong(4,  info.getAnnualIncome());
	               stmt.setString(5,  info.getRemark());
	               stmt.setLong(6,  info.getIncomeSourceId());
	           }
	       });			
			return info;
	}
	
	@Override
	public void deleteIncomeSourceInfo(long incomeSourceId) {
		this.jdbcTemplate.update(this.appSql.getIncome().getDeleteIncomeDetailsSql(),new PreparedStatementSetter() { 
	           public void setValues(PreparedStatement stmt) throws SQLException {   
	               stmt.setLong(1,  incomeSourceId);
	           }
	       });			
		
	} 
	
	@Override
	public void deleteIncomeSourceByMemberId(long memberId) {
		this.jdbcTemplate.update(this.appSql.getIncome().getDeleteIncomeDetailsByMemberIdSql(),new PreparedStatementSetter() { 
	           public void setValues(PreparedStatement stmt) throws SQLException {   
	               stmt.setLong(1,  memberId);
	           }
	       });		
	}
	@Override
	public List<IncomeSourceInfo> getIncomeSourcesByUserId(long userId) throws RecordNotFoundException {
		try {
			return jdbcTemplate.query(this.appSql.getIncome().getSelectIncomeDetailsByUserIdSql(), new Object[] { userId  },
					new IncomeSourceRowMapper());

		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}
	
	@Override
	public IncomeSourceInfo getIncomeSourceById(long id) throws RecordNotFoundException {
		try {
			List<IncomeSourceInfo> list = jdbcTemplate.query(this.appSql.getIncome().getSelectIncomeDetailsByIdSql(), new Object[] { id  },
					new IncomeSourceRowMapper());
			return list.get(0);
		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}


}
class IncomeSourceRowMapper implements RowMapper<IncomeSourceInfo>{
	
	
	@Override
	public IncomeSourceInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		IncomeSourceInfo incomeSource = new IncomeSourceInfo();
		incomeSource.setIncomeSourceId(rs.getLong("id"));
		incomeSource.setUserId(rs.getLong("user_id"));		
		incomeSource.setDeleted(StringUtil.stringToBoolean(YES_NO.NO.getValue()));
		incomeSource.setUpdateCounter(rs.getInt("update_counter"));
		incomeSource.setIncome(rs.getLong("income"));
		incomeSource.setAnnualIncome(rs.getLong("annual_income"));
		incomeSource.setUserId(rs.getLong("user_id"));
		incomeSource.setRemark(rs.getString("remark"));
		NameValueInfo incomeSourceType = new NameValueInfo(rs.getString("income_type_text"),rs.getInt("type"));		
		incomeSource.setIncomeSourceType(incomeSourceType);		
		NameValueInfo member = new NameValueInfo(rs.getString("name"),rs.getInt("member_id"));		
		incomeSource.setMember(member);
		FrequencyInfo frequency = new FrequencyInfo(rs.getString("frequency_text"),rs.getInt("frequency"),rs.getInt("factor"));		
		incomeSource.setFrequency(frequency);
		return incomeSource;
		
	}
}
