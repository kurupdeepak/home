package com.self.organizer.dailycounter.service;

public class InvalidCounterException extends DailyCounterServiceException {
    public InvalidCounterException() {
    }

    public InvalidCounterException(String message) {
        super(message);
    }

    public InvalidCounterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCounterException(Throwable cause) {
        super(cause);
    }

    public InvalidCounterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
