package com.customerreview.module.review.controller;

import com.customerreview.module.ControllerError;
import com.customerreview.module.curseword.service.NotFoundException;
import com.customerreview.module.review.service.InvalidReviewException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(InvalidReviewException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ControllerError handleInvalidReview(Exception e, WebRequest request){
        ControllerError error = new ControllerError();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setException(e.getStackTrace());
        error.setMessage(e.getMessage());
        error.setRequest(request.getParameterMap());
        return error;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ControllerError handleNotFound(Exception e,WebRequest request){
        ControllerError error = new ControllerError();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setException(e.getStackTrace());
        error.setMessage(e.getMessage());
        error.setRequest(request.getParameterMap());
        return error;
    }
}
