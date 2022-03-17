package com.example.banksystem.cbts.response;

public class CBTSResponse {

    private String message;

    public CBTSResponse() {
    }

    public CBTSResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
