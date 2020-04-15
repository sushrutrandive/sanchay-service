package com.planner.calc.service.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.planner.calc.service.dao.UserRepository;
import com.planner.calc.service.exceptions.UserNotFoundException;
import com.planner.calc.service.info.LoginInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.info.UserInfo;
import com.planner.calc.service.prop.config.AppSql;
import com.planner.calc.service.util.Constants.YES_NO;
import com.planner.calc.service.util.StringUtil;


@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private AppSql appSql;

	@Override
	public UserInfo getUserDetailsById(long id) throws UserNotFoundException {

		try {
			return jdbcTemplate.queryForObject(this.appSql.getUser().getSelectUserByIdSql(), new Object[] { id, YES_NO.NO.getValue(), YES_NO.YES.getValue() },
					new UserRowMapper());

		} catch (EmptyResultDataAccessException exception) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public long authenticateUser(LoginInfo info) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {

			return jdbcTemplate.queryForObject(this.appSql.getUser().getSelelctAuthenticateUser(),
					new Object[] { info.getUserName(), info.getPassword(), YES_NO.NO.getValue() }, Long.class);

		} catch (EmptyResultDataAccessException exception) {
			throw new UserNotFoundException();
		}

	}

	@Override
	public void saveToken(UserInfo info, String token) {
		
		jdbcTemplate.update(appSql.getUser().getInsertTokenSql(), new PreparedStatementSetter() {
            
           public void setValues(PreparedStatement stmt) throws SQLException {               
               stmt.setString(1,  info.getEmail());
               stmt.setString(2, token);
           }
       });   //update(this.saveTokenSql, objects, objectTypes);

	}

	//
	@Override
	public String getTokenByUserName(String userName) {
		try {

			return jdbcTemplate.queryForObject(this.appSql.getUser().getSelectTokenByUserName(), new Object[] { userName, YES_NO.NO.getValue() },
					String.class);

		} catch (EmptyResultDataAccessException exception) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public void deleteTokenByUserName(String userName) {
		// TODO Auto-generated method stub
		
		jdbcTemplate.update(this.appSql.getUser().getDeleteTokenByUserName(), new PreparedStatementSetter() {
            
	           public void setValues(PreparedStatement stmt) throws SQLException {               
	               stmt.setString(1,  userName);
	               
	           }
	       });   //update(this.saveTokenSql, objects, objectTypes);
	}
	
	@Override
	public UserInfo getUserDetailsByUserName(String userName) throws UserNotFoundException {
		try {
			return jdbcTemplate.queryForObject(this.appSql.getUser().getSelectUserByUserName(), new Object[] { userName, YES_NO.NO.getValue(),YES_NO.YES.getValue() },
					new UserRowMapper());

		} catch (EmptyResultDataAccessException exception) {
			throw new UserNotFoundException();
		}
	}
	
	

}

class UserRowMapper implements RowMapper<UserInfo> {
	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo user = new UserInfo();
		user.setUserId(rs.getLong("id"));
		user.setMobileNo(rs.getLong("mobile_no"));
		user.setName(rs.getString("name"));
		
		user.setEmail(rs.getString("email"));
		user.setDeleted(StringUtil.stringToBoolean(rs.getString("deleted")));
		user.setUpdateCounter(rs.getInt("update_counter"));
		user.setActive(StringUtil.stringToBoolean(rs.getString("active")));
		NameValueInfo relation = new NameValueInfo(rs.getString("relation_text"),rs.getInt("relation"));		
		user.setRelation(relation);
		NameValueInfo occupation = new NameValueInfo(rs.getString("occupation_text"),rs.getInt("occupation"));
		user.setOccupation(occupation);
		return user;
	}
}
