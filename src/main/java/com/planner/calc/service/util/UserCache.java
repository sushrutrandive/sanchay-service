package com.planner.calc.service.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class UserCache {
	
	private Map<String, Long> userMap=  new ConcurrentHashMap<>();
	
	public void saveUserIdAndToken(String toekn,Long userId){
		userMap.put(toekn, userId);
	}
	public long getUserId(String toekn){
		return userMap.get(toekn);
	}
	public void removeToekn(String token){
		userMap.remove(token);
	}
	
	public boolean isTokenPresent(String token){
		return userMap.containsKey(token);
	}
}
