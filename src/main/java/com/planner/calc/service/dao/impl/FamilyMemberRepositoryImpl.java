package com.planner.calc.service.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.planner.calc.service.dao.FamilyMemberRepository;
import com.planner.calc.service.exceptions.RecordNotFoundException;
import com.planner.calc.service.info.FamilyMemberInfo;
import com.planner.calc.service.info.NameValueInfo;
import com.planner.calc.service.prop.config.AppSql;
import com.planner.calc.service.util.Constants.YES_NO;
import com.planner.calc.service.util.StringUtil;

@Repository
public class FamilyMemberRepositoryImpl implements FamilyMemberRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	private AppSql appSql;

	@Override
	public List<FamilyMemberInfo> getFamilyDetailsByUserId(long userId) throws RecordNotFoundException {
		try {
			return jdbcTemplate.query(this.appSql.getFamily().getSelelctFamilyDetailsByUserIdSql(),
					new Object[] { userId }, new FamilyMemberRowMapper());

		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}

	@Override
	public List<FamilyMemberInfo> getAllFamilyDetailsByUserId(long userId) throws RecordNotFoundException {
		try {
			return jdbcTemplate.query(this.appSql.getFamily().getSelelctAllFamilyDetailsByUserIdSql(),
					new Object[] { userId }, new FamilyMemberRowMapper());

		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}

	@Override
	public FamilyMemberInfo getFamilyDetailsById(long id) throws RecordNotFoundException {
		try {
			List<FamilyMemberInfo> list = jdbcTemplate.query(this.appSql.getFamily().getSelelctFamilyDetailsByIdSql(),
					new Object[] { id }, new FamilyMemberRowMapper());
			return list.get(0);

		} catch (EmptyResultDataAccessException exception) {
			throw new RecordNotFoundException();
		}
	}

	@Override
	public FamilyMemberInfo createFamilyMemberInfo(FamilyMemberInfo info) {
		// KeyHolder keyHolder = new GeneratedKeyHolder();
		// (user_id,first_name,last_name,email,birth_date,mobile_no,relation,occupation,is_user)
		this.jdbcTemplate.update(this.appSql.getFamily().getInsertFamilyDetailsSql(), new PreparedStatementSetter() {
			public void setValues(PreparedStatement stmt) throws SQLException {
				stmt.setLong(1, info.getUserId());
				stmt.setString(2, info.getFirstName());
				stmt.setString(3, info.getLastName());
				stmt.setString(4, info.getEmail());
				stmt.setDate(5, new Date(info.getDateOfBirth().getTime()));
				if (info.getMobileNo() == 0) {
					stmt.setNull(6, Types.BIGINT);
				} else {
					stmt.setLong(6, info.getMobileNo());
				}
				stmt.setLong(7, info.getRelation().getValue());
				stmt.setLong(8, info.getOccupation().getValue());
				stmt.setString(9, StringUtil.booleanToString(info.isMainUser()));

			}
		});
		// info.setMemberId(keyHolder.getKey().longValue());
		return info;
	}

	@Override
	public void deleteFamilyMemberInfo(long memberId) {
		this.jdbcTemplate.update(this.appSql.getFamily().getDeleteFamilyDetailsSql(), new PreparedStatementSetter() {
			public void setValues(PreparedStatement stmt) throws SQLException {
				stmt.setLong(1, memberId);
			}
		});
	}

	@Override
	public FamilyMemberInfo updateFamilyMemberInfo(FamilyMemberInfo info) throws RecordNotFoundException {
		this.jdbcTemplate.update(this.appSql.getFamily().getUpdateFamilyDetailsSql(), new PreparedStatementSetter() {
			public void setValues(PreparedStatement stmt) throws SQLException {
				// stmt.setLong(1, info.getUserId());
				stmt.setString(1, info.getFirstName());
				stmt.setString(2, info.getLastName());
				stmt.setString(3, info.getEmail());
				stmt.setDate(4, new Date(info.getDateOfBirth().getTime()));
				if (info.getMobileNo() == 0) {
					stmt.setNull(5, Types.BIGINT);
				} else {
					stmt.setLong(5, info.getMobileNo());
				}

				stmt.setLong(6, info.getRelation().getValue());
				stmt.setLong(7, info.getOccupation().getValue());
				stmt.setLong(8, info.getMemberId());

			}
		});
		return info;
	}

}

class FamilyMemberRowMapper implements RowMapper<FamilyMemberInfo> {

	@Override
	public FamilyMemberInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		FamilyMemberInfo member = new FamilyMemberInfo();
		member.setMemberId(rs.getLong("id"));
		member.setUserId(rs.getLong("user_id"));
		member.setMobileNo(rs.getLong("mobile_no"));
		member.setFirstName(rs.getString("first_name"));
		member.setLastName(rs.getString("last_name"));
		member.setEmail(rs.getString("email"));
		member.setDeleted(StringUtil.stringToBoolean(YES_NO.NO.getValue()));
		member.setUpdateCounter(rs.getInt("update_counter"));
		member.setDateOfBirth(rs.getDate("birth_date"));
		NameValueInfo relation = new NameValueInfo(rs.getString("relation_text"), rs.getInt("relation"));
		member.setRelation(relation);
		NameValueInfo occupation = new NameValueInfo(rs.getString("occupation_text"), rs.getInt("occupation"));
		member.setOccupation(occupation);
		member.setMainUser(StringUtil.stringToBoolean(rs.getString("is_user")));
		return member;

	}
}
