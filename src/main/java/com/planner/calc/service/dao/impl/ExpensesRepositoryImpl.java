package com.planner.calc.service.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.planner.calc.service.dao.ExpensesRepository;
import com.planner.calc.service.exceptions.RecordNotFoundException;
import com.planner.calc.service.info.ChildNameValueInfo;
import com.planner.calc.service.info.ExpenseInfo;
import com.planner.calc.service.info.FrequencyInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.prop.config.AppSql;
import com.planner.calc.service.util.Constants.YES_NO;
import com.planner.calc.service.util.StringUtil;



@Repository
public class ExpensesRepositoryImpl implements ExpensesRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AppSql appSql;

	public ExpensesRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ExpenseInfo createExpense(ExpenseInfo info) {
		this.jdbcTemplate.update(this.appSql.getExpense().getInsertExpensesDetailsSql(),new PreparedStatementSetter() {  			
	           public void setValues(PreparedStatement stmt) throws SQLException {               
	               stmt.setLong(1,  info.getUserId());
	               stmt.setLong(2,  info.getExpenseCategory().getValue());
	               stmt.setLong(3,  info.getFrequency().getValue());
	               stmt.setLong(4,  info.getExpenseSubCategory().getValue());
	               stmt.setLong(5,  info.getAmount());
	               stmt.setLong(6,  info.getAnnualAmount());
	               stmt.setString(7,  info.getRemark());
	           }
	       });			
			return info;
	}
	@Override
	public ExpenseInfo updateExpense(ExpenseInfo info) throws RecordNotFoundException {
		this.jdbcTemplate.update(this.appSql.getExpense().getUpdateExpensesDetailsSql(),new PreparedStatementSetter() {  			
	           public void setValues(PreparedStatement stmt) throws SQLException {               
	               
	               stmt.setLong(1,  info.getExpenseCategory().getValue());
	               stmt.setLong(2,  info.getFrequency().getValue());
	               stmt.setLong(3,  info.getExpenseSubCategory().getValue());
	               stmt.setLong(4,  info.getAmount());
	               stmt.setLong(5,  info.getAnnualAmount());
	               stmt.setString(6,  info.getRemark());
	               stmt.setLong(7,  info.getExpenseId());
	           }
	       });			
			return info;
	}
	@Override
	public void deleteExpense(long expenseId) {
		this.jdbcTemplate.update(this.appSql.getExpense().getDeleteExpensesDetailsSql(),new PreparedStatementSetter() {  			
	           public void setValues(PreparedStatement stmt) throws SQLException { 
	               stmt.setLong(7,  expenseId);
	           }
	       });			
		
	}
	@Override
	public ExpenseInfo getExpenseById(long id) throws RecordNotFoundException {
		try {
			List<ExpenseInfo> list = jdbcTemplate.query(this.appSql.getExpense().getSelectExpensesDetailsByIdSql(), new Object[] { id  },
					new ExpenseRowMapper());
			return list.get(0);
		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}
	@Override
	public List<ExpenseInfo> getExpensesByUserId(long userId) throws RecordNotFoundException {
		try {
			return jdbcTemplate.query(this.appSql.getExpense().getSelectExpensesDetailsByUserIdSql(), new Object[] { userId  },
					new ExpenseRowMapper());

		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}
	
}

class ExpenseRowMapper implements RowMapper<ExpenseInfo>{
	
	
	@Override
	public ExpenseInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		ExpenseInfo expense = new ExpenseInfo();
		expense.setExpenseId(rs.getLong("id"));
		expense.setUserId(rs.getLong("user_id"));		
		expense.setDeleted(StringUtil.stringToBoolean(YES_NO.NO.getValue()));
		expense.setUpdateCounter(rs.getInt("update_counter"));
		expense.setAmount(rs.getLong("amount"));
		expense.setAnnualAmount(rs.getLong("annual_amount"));		
		expense.setRemark(rs.getString("remark"));
		
		NameValueInfo category = new NameValueInfo(rs.getString("category_text"),rs.getInt("category"));		
		expense.setExpenseCategory(category);		
		
		ChildNameValueInfo expenseSubCategory = new ChildNameValueInfo(rs.getString("sub_category_text"),rs.getInt("sub_category"),rs.getInt("category_id"));		
		expense.setExpenseSubCategory(expenseSubCategory);
		
		FrequencyInfo frequency = new FrequencyInfo(rs.getString("frequency_text"),rs.getInt("frequency"),rs.getInt("factor"));		
		expense.setFrequency(frequency);
		return expense;
		
	}
}
