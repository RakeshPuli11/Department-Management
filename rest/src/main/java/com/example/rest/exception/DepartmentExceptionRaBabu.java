package com.example.rest.exception;

public class DepartmentExceptionRaBabu extends Exception{
    public DepartmentExceptionRaBabu() {
        super();
    }

    public DepartmentExceptionRaBabu(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentExceptionRaBabu(String message) {
        super(message);
    }

    public DepartmentExceptionRaBabu(Throwable cause) {
        super(cause);
    }

    protected DepartmentExceptionRaBabu(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}