package com.planner.calc.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidParameterException extends RuntimeException  {
	private static final long serialVersionUID = 100L;
	public InvalidParameterException(){
		super();
	}
	public InvalidParameterException(String message){
		super(message);
	}
}
