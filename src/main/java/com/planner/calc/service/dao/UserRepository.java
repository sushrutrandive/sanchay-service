package com.planner.calc.service.dao;

import com.planner.calc.service.exceptions.UserNotFoundException;
import com.planner.calc.service.info.LoginInfo;
import com.planner.calc.service.info.UserInfo;

public interface UserRepository {
	
	public UserInfo getUserDetailsById(long id) throws UserNotFoundException;
	public long authenticateUser(LoginInfo info ) throws UserNotFoundException;
	public void saveToken(UserInfo info, String token);
	public String getTokenByUserName(String userName);
	public void deleteTokenByUserName(String userName);
	public UserInfo getUserDetailsByUserName(String userName)throws UserNotFoundException;
	

}
