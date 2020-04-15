package com.planner.calc.service.services;

import com.planner.calc.service.info.UserInfo;

public interface UserService {
	
	public String getTokenByUserName(String userName);
	public long getUserIdByToken(String token);
	public UserInfo getUserByUserName(String userName);
	public void logout(String userName);

}
