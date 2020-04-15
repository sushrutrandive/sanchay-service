package com.planner.calc.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(code=HttpStatus.FORBIDDEN, reason="Unauthorized access!")
public class UnAuthorizedRequestException extends RuntimeException  {
	private static final long serialVersionUID = 100L;
}
