package com.example.JavaMainService.globalException;

public record GlobalErrorResponse(
        String code,
        String message,
        String traceId,
        String timestamp,
        String path
) {
}
