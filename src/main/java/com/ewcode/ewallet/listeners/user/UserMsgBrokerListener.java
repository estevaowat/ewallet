package com.ewcode.ewallet.listeners.user;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserMsgBrokerListener {
    private static final String QUEUE_USER_SAVE = "/queue/user/save";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_USER_SAVE, true);
    }

    @RabbitListener(queues = {
            QUEUE_USER_SAVE
    })
    public void save(@Payload String message) {
        System.out.println("message = " + message);
    }

}
