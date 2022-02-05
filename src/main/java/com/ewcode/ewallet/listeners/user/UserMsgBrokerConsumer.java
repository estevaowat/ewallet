package com.ewcode.ewallet.listeners.user;

import com.ewcode.ewallet.business.user.UserService;
import com.ewcode.ewallet.dtos.user.SaveUserDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserMsgBrokerConsumer {
    private static final String QUEUE_USER_SAVE = "/queue/user/save";
    private final UserService userService;

    public UserMsgBrokerConsumer(UserService userService) {
        this.userService = userService;
    }

    @Bean
    Queue queue() {
        return new Queue(QUEUE_USER_SAVE, true);
    }

    @RabbitListener(queues = {QUEUE_USER_SAVE})
    public void save(@Payload String message) {
        SaveUserDto userToSave = new SaveUserDto(message, message);
        userService.insertOrUpdate(userToSave);
    }

}
