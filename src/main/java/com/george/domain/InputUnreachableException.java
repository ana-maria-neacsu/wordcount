package com.george.domain;

public class InputUnreachableException extends RuntimeException {

    public InputUnreachableException(String message, Throwable e) {
        super(message, e);
    }

}
