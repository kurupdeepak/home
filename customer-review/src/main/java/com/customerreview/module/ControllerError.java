package com.customerreview.module;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ControllerError {
    HttpStatus status;
    String message ;
    String exception;
    Map<String, String[]> request;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(StackTraceElement[] exception) {
        StringBuilder sb = new StringBuilder();
        for(StackTraceElement elem : exception){
            sb.append(elem.toString());
        }
    }

    public Map<String, String[]> getRequest() {
        return request;
    }

    public void setRequest(Map<String, String[]> request) {
        this.request = request;
    }
}
