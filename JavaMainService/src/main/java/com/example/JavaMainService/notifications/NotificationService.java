package com.example.JavaMainService.notifications;

import com.example.JavaMainService.notifications.model.Communication;
import com.example.JavaMainService.notifications.model.NotificationDTO;
import com.example.JavaMainService.notifications.model.UserCallDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final KafkaNotifyProducer kafkaNotifyProducer;

    //TODO: сделать нормальный ответ
    //TODO: сделать больше проверок + оптимизация стримов
    //TODO: топики хранить где то статически
    public String notificationsHandle(NotificationDTO notifications) {
        String emailTopic = "notifications-email";

        String message = notifications.message();

        List<UserCallDTO> kafkaMailMessage = notifications.userCallList().stream().filter(userCallDTO ->
            userCallDTO.communicationPlatform().equals(Communication.Mail)
        ).toList();
        kafkaNotifyProducer.sendNotify(new NotificationDTO(kafkaMailMessage, message), emailTopic);

        return "OK";
    }
}
