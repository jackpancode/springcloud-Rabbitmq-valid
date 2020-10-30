package com.besti.springcloud.Rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class Receiver {


    @RabbitListener(queues ="topic.resp")
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "topic.resp",durable = "true"),
//            exchange = @Exchange(value = "exchange-test",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
//            key = {"topic.resp.routingkey"}
//    ))
    public Object process(Object object) {

        return object;
    }
}
