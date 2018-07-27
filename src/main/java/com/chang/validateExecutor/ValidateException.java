package com.chang.validateExecutor;

public class ValidateException extends RuntimeException {

    public ValidateException() {
        super("Fail validate!!");
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }
}
