package com.sony.cloudtest.entities;

public class ErrorResponse {
    private int errorCode;
    private String errorMsg;

    public ErrorResponse() {}
    
    public ErrorResponse(String error, int ecode) {
        this.errorMsg = error;
        this.errorCode = ecode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
