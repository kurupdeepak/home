package com.self.organizer.dailycounter.service;

public class DailyCounterServiceException extends Exception{
    public DailyCounterServiceException() {
    }

    public DailyCounterServiceException(String message) {
        super(message);
    }

    public DailyCounterServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DailyCounterServiceException(Throwable cause) {
        super(cause);
    }

    public DailyCounterServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
