package com.rxtracker.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rxtracker.userservice.service.UserNotFoundException;

@ControllerAdvice
public class UserServiceExceptionHandler {

	public UserServiceExceptionHandler() {
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public UserServiceApiError handleException(Exception e) {
		e.printStackTrace();
		return UserServiceApiErrorBuilder.builder()
		.message(e.getMessage())
		.httpStatus(HttpStatus.NOT_FOUND)
		.build();
	}
	
	
	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ResponseBody
	public UserServiceApiError handleException(Throwable e) {
		e.printStackTrace();
		return UserServiceApiErrorBuilder.builder()
		.message(e.getMessage())
		.httpStatus(HttpStatus.SERVICE_UNAVAILABLE)
		.build();
	}

}
