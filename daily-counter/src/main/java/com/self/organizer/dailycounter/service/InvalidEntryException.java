package com.self.organizer.dailycounter.service;

public class InvalidEntryException extends DailyCounterServiceException {
    public InvalidEntryException() {
    }

    public InvalidEntryException(String message) {
        super(message);
    }

    public InvalidEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntryException(Throwable cause) {
        super(cause);
    }

    public InvalidEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
