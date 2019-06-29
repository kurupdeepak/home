package com.rxtracker.common;

import java.util.List;

import org.springframework.http.HttpStatus;

public class RxApiError {
	HttpStatus httpStatus;
	List<String> errorMsg;
	String genericMsg;
	Throwable exception;
	
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

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

}
