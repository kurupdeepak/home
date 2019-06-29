package com.rxtracker.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

public class UserServiceApiError {
	HttpStatus httpStatus;
	List<String> errorMsg;
	String genericMsg;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public List<String> getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(List<String> errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getGenericMsg() {
		return genericMsg;
	}
	
	public void setGenericMsg(String genericMsg) {
		this.genericMsg = genericMsg;
	}

		
}
