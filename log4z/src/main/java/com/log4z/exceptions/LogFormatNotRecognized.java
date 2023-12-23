package com.log4z.exceptions;

public class LogFormatNotRecognized extends RuntimeException {
    public LogFormatNotRecognized(String message) {
        super(message);
    }
}
