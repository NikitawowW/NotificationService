package com.example.JavaMainService.auth.errors;

public class EmailBusyException extends RuntimeException {
  public EmailBusyException(String message) {
    super(message);
  }
}
