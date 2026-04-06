package com.example.JavaMainService.auth.errors;

public class LoginBusyException extends RuntimeException {
    public LoginBusyException(String message) {
        super(message);
    }
}
