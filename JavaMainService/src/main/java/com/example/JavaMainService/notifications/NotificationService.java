package com.example.JavaMainService.notifications;

import com.example.JavaMainService.notifications.model.NotificationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final KafkaNotifyProducer kafkaNotifyProducer;

    public String notificationsHandle(NotificationDTO notifications) {
        // Логика с бд и прочее...
        kafkaNotifyProducer.sendNotify(notifications);

        return "OK";
    }
}
