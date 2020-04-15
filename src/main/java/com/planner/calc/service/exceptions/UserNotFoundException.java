package com.planner.calc.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
@Component
@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="User not found!")
public class UserNotFoundException extends RuntimeException  {
	private static final long serialVersionUID = 100L;
}
