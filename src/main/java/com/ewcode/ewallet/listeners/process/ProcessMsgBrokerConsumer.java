package com.ewcode.ewallet.listeners.process;

import liquibase.repackaged.org.apache.commons.lang3.NotImplementedException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ProcessMsgBrokerConsumer {
    private static final String QUEUE_PROCESS_SLOW = "/queue/process/slow";

    @Bean
    Queue processSlowQueue() {
        return new Queue(QUEUE_PROCESS_SLOW, true);
    }

    @RabbitListener(queues = {QUEUE_PROCESS_SLOW})
    public void processSlow() {
        throw new NotImplementedException();
    }
}
