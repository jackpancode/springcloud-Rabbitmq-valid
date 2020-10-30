package com.besti.rabbitmqclient.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class RabbitReceiver {


    @RabbitListener(queues = "topic.resp")
    public String getMessage(String msg){
        return msg;

    }
}
