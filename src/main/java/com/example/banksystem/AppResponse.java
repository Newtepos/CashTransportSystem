package com.example.banksystem;

import org.springframework.http.HttpStatus;

public class AppResponse {

    private String message;

    public AppResponse() {
    }

    public AppResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
