package com.self.organizer.dailycounter.controller;

import com.self.organizer.dailycounter.service.DailyCounterServiceException;
import com.self.organizer.dailycounter.service.InvalidCounterException;
import com.self.organizer.dailycounter.service.InvalidEntryException;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DailyCounterExceptionHandler {

    @ExceptionHandler({InvalidCounterException.class, InvalidEntryException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleError(Throwable t){
        t.printStackTrace(System.out);
        return t.getMessage();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGlobalError(Throwable t){
        t.printStackTrace(System.out);
        return t.getMessage();
    }
}
