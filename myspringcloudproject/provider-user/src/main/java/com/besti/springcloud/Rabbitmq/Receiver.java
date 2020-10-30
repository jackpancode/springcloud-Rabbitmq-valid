package com.besti.springcloud.Rabbitmq;

import com.alibaba.fastjson.JSON;
import com.besti.springcloud.entity.User;
import com.besti.springcloud.repository.UserRepository;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class Receiver {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    private String exchange = "exchange-test";
    private String routekey = "topic.resp.routingkey";


//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "topic.find",durable = "true"),
//            exchange = @Exchange(value = "exchange-test",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
//            key = {"topic.find.routingkey"}
//    ))
    @RabbitListener(queues = "topic.find")
    public void process(long msg) throws Exception{
        //String id = msg;
       // long id = Long.valueOf(msg).longValue();
        userRepository.deleteById(msg);
        //String RespMsg = JSON.toJSONString(user);
        //sender.sendTopic(exchange,routekey,user);
    }
}
