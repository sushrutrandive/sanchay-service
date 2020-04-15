package com.planner.calc.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planner.calc.service.dao.UserRepository;
import com.planner.calc.service.info.UserInfo;

import com.planner.calc.service.services.UserService;
import com.planner.calc.service.util.UserCache;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private UserCache userCache;
	
	@Override
	public String getTokenByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.getTokenByUserName(userName);
	}
	
	@Override
	public UserInfo getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.getUserDetailsByUserName(userName);
	}
	
	@Override
	public void logout(String token) {
		// TODO Auto-generated method stub
		String decodedToekn ="";
		
		userRepository.deleteTokenByUserName(decodedToekn);
		this.userCache.removeToekn(token);
	}
	@Override
	public long getUserIdByToken(String token) {
		if(this.userCache.isTokenPresent(token)){
			return this.userCache.getUserId(token);
		}
		else{
			String decodedToekn = "";			
			UserInfo user =  this.userRepository.getUserDetailsByUserName(decodedToekn);
			this.userCache.saveUserIdAndToken(token, user.getUserId()); 
			return user.getUserId();
		}
		
	}

}
