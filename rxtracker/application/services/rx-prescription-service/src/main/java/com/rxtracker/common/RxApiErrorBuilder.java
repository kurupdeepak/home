package com.rxtracker.common;

import java.util.List;

import org.springframework.http.HttpStatus;

public class RxApiErrorBuilder {

	protected RxApiError error;

	private RxApiErrorBuilder() {
		error = new RxApiError();
	}

	public RxApiError getError() {
		return error;
	}

	public void setError(RxApiError error) {
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

	public RxApiErrorBuilder httpStatus(HttpStatus httpStatus) {
		error.httpStatus = httpStatus;
		return this;

	}

	public RxApiErrorBuilder errors(List<String> errors) {
		error.errorMsg = errors;
		return this;
	}

	public RxApiErrorBuilder message(String message) {
		error.genericMsg = message;
		return this;
	}
	
	public RxApiErrorBuilder exception(Throwable ex) {
		error.exception= ex;
		return this;
	}

	public RxApiError build() {
		return error;
	}

	public static RxApiErrorBuilder builder() {
		return new RxApiErrorBuilder();
	}

}
