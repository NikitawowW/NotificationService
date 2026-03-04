package com.example.JavaMainService.notifications;

import com.example.JavaMainService.notifications.model.NotificationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping()
    public ResponseEntity<String> sendNotify(@RequestBody NotificationDTO notifications) {
        log.info("Received http request with notifications: {}", notifications);
        String answer = notificationService.notificationsHandle(notifications);

        return ResponseEntity.ok(answer);
    }
}
