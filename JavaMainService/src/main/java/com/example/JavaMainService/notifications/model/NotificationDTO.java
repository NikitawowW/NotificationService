package com.example.JavaMainService.notifications.model;

import java.util.List;

public record NotificationDTO(
        List<UserCallDTO> userCallList,
        String message
) {
}
