package com.besti.rabbitmqclient.RabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    @Autowired
    private RabbitReceiver rabbitReceiver;

    public void SendTopic(){
        String msg="";
        rabbitAmqpTemplate.convertAndSend("exchange-test","topic.getmessage.key","1");
        String getmsg =  rabbitReceiver.getMessage(msg);
        System.out.println("收到User发来的消息:"+getmsg);
    }
}
