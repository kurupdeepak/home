package com.customerreview.module.common.controller;

import com.customerreview.module.common.service.NotFoundException;
import com.customerreview.module.review.service.InvalidReviewException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(InvalidReviewException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleInvalidReview(Exception e){
       
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound(Exception e){

    }
}
