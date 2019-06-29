package com.rxtracker.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rxtracker.glucomonitor.service.GlucoMonitorServiceFailureException;
import com.rxtracker.prescription.service.PrescriptionDailyLogServiceException;
import com.rxtracker.prescription.service.PrescriptionNotFoundException;

public class RxApiErrorHandler {

	public RxApiErrorHandler() {
	}
	
	@ExceptionHandler(value = PrescriptionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public RxApiError handleNotFound(Exception e) {
		e.printStackTrace();
		return RxApiErrorBuilder.builder()
		.message(e.getMessage())
		.exception(e)
		.httpStatus(HttpStatus.NOT_FOUND)
		.build();
	}
	
	@ExceptionHandler(value = PrescriptionDailyLogServiceException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public RxApiError handleServiceErrors(Exception e) {
		e.printStackTrace();
		return RxApiErrorBuilder.builder()
		.message(e.getMessage())
		.exception(e)
		.httpStatus(HttpStatus.CONFLICT)
		.build();
	}
	
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
