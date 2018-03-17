package com.elyashevich.task1.exception;

public class SphereTechnicalException extends Exception {
    public SphereTechnicalException() {
    }

    public SphereTechnicalException(String message, Throwable exception) {
        super(message, exception);
    }

    public SphereTechnicalException(String message) {
        super(message);
    }

    public SphereTechnicalException(Throwable exception) {
        super(exception);
    }

}
