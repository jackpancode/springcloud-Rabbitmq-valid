package com.besti.rabbitmqclient.controller;

import com.besti.rabbitmqclient.RabbitMQ.RabbitReceiver;
import com.besti.rabbitmqclient.RabbitMQ.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@RestController
public class UserController {

    @Autowired
    private RabbitReceiver rabbitReceiver;

    @Autowired
    private RabbitSender rabbitSender;

    private String exchange = "exchange-test";
    private String routekey = "topic.getmessage.key";


//    @GetMapping(value = "findById/{id}")
//    public void findById(@PathVariable("id") String id){
//        String msg="";
//        rabbitSender.sendTopic(exchange,routekey,id);
//        String getmsg =  rabbitReceiver.getMessage(msg);
//        System.out.println("收到User发来的消息:"+getmsg);
//    }
}
