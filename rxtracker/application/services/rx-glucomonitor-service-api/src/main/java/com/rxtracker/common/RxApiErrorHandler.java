package com.rxtracker.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rxtracker.glucomonitor.service.GlucoMonitorServiceFailureException;

public class RxApiErrorHandler {

	@ExceptionHandler(value = GlucoMonitorServiceFailureException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public RxApiError handleGlucoMonitorErrors(Exception e) {
		e.printStackTrace();
		return RxApiErrorBuilder.builder()
		.message(e.getMessage())
		.exception(e)
		.httpStatus(HttpStatus.CONFLICT)
		.build();
	}
	
	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ResponseBody
	public RxApiError handleException(Throwable e) {
		e.printStackTrace();
		return RxApiErrorBuilder.builder()
		.message(e.getMessage())
		.exception(e)
		.httpStatus(HttpStatus.SERVICE_UNAVAILABLE)
		.build();
	}

}
