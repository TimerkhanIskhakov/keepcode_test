package com.keepcode.tests.test1.exception;

public class RequestException extends RuntimeException {

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
