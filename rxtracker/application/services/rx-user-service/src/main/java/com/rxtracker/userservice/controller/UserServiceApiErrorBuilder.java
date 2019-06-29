package com.rxtracker.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

public class UserServiceApiErrorBuilder{
	
	protected UserServiceApiError error;
	
	private UserServiceApiErrorBuilder() {
			error = new UserServiceApiError();
	}
	
	public UserServiceApiError getError() {
		return error;
	}

	public void setError(UserServiceApiError error) {
		this.error = error;
	}
	
	public HttpStatus getHttpStatus() {
		return error.httpStatus;
	}
	
	public List<String> getErrors() {
		return error.errorMsg;
	}
	
	public String getMessage() {
		return error.genericMsg;
	}
	
	public UserServiceApiErrorBuilder httpStatus(HttpStatus httpStatus) {
		error.httpStatus = httpStatus;
		return this;
		
	}
	public UserServiceApiErrorBuilder errors(List<String> errors) {
		error.errorMsg = errors;
		return this;
	}
	
	public UserServiceApiErrorBuilder message(String message) {
		error.genericMsg = message;
		return this;
	}
	
	public UserServiceApiError build() {
		return error;
	}

	public static UserServiceApiErrorBuilder builder() {
		return new UserServiceApiErrorBuilder();
	}
	
}
