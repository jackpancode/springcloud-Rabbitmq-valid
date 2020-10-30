package com.besti.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.besti.springcloud.Rabbitmq.Receiver;
import com.besti.springcloud.Rabbitmq.Sender;
import com.besti.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@RestController
@RequestMapping("/user")
public class ConsumerUserController {


    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    private String exchange = "exchange-test";
    private String routekey = "topic.find.routingkey";


    @GetMapping(value = "/deleteById/{id}")    //layui模板前端发送来的删除数据请求为GET，所以此处必须使用GET请求
    public void deleteById(@PathVariable("id") long id){
        User user = new User();
        sender.sendTopic(exchange,routekey,id);
        // return  receiver.process(msg);
//        String json_string = JSON.toJSONString(receiver.process(user));
//        System.out.println("收到查询到的用户信息为："+json_string);



    }
}
