package com.planner.calc.service.util;

import java.util.Objects;

import org.springframework.security.core.context.SecurityContextHolder;

import com.planner.calc.service.exceptions.UnAuthorizedRequestException;
import com.planner.calc.service.security.UserPrincipal;

public class UserUtil {
	
	public static UserPrincipal getUser() {
		 if(SecurityContextHolder.getContext().getAuthentication()== null) {
			 throw new UnAuthorizedRequestException();
		 }
		 UserPrincipal userDetails =(UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 if(Objects.isNull(userDetails))
			 throw new UnAuthorizedRequestException();
		 return userDetails;
	}
	
	public static long getUserId() {
		 if(SecurityContextHolder.getContext().getAuthentication()== null) {
			 throw new UnAuthorizedRequestException();
		 }
		 UserPrincipal userDetails =(UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 if(Objects.isNull(userDetails) || userDetails.getId()<1)
			 throw new UnAuthorizedRequestException();
		 return userDetails.getId();
	}

}
