package com.dolomanji.common.exception;

public class CommonException extends RuntimeException {
    public String getSource() {
        return "Application";
    }

    public String getField() {
        return "";
    }
}
