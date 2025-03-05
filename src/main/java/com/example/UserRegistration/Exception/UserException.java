package com.example.UserRegistration.Exception;

public class UserException extends RuntimeException {
    private String message;

    public UserException(String message) {
        super(message);
    }
}
