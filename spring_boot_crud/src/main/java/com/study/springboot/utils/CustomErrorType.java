package com.study.springboot.utils;

public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        setErrorMessage(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
