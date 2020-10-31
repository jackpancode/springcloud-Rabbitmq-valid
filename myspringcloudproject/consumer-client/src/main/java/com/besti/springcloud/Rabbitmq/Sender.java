package com.besti.springcloud.Rabbitmq;

import com.besti.springcloud.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class Sender {

    @Autowired
    public AmqpTemplate rabbitAmqpTemplate;


    public void sendTopicDelete(String exchange,String routekey,long msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        rabbitAmqpTemplate.convertAndSend(exchange,routekey,msg);

    }

    public void sendTopicCreateUser(String exchange,String routekey,String msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        rabbitAmqpTemplate.convertAndSend(exchange,routekey,msg);

    }
}
