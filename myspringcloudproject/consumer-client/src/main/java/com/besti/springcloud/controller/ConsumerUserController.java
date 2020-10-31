package com.besti.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.besti.springcloud.Rabbitmq.Receiver;
import com.besti.springcloud.Rabbitmq.Sender;
import com.besti.springcloud.entity.Menu;
import com.besti.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    private String delete_routekey = "topic.find.routingkey";
    private String createuser_routekey = "topic.createuser.routingkey";


    @GetMapping(value = "/deleteById/{id}")    //layui模板前端发送来的删除数据请求为GET，所以此处必须使用GET请求
    public void deleteById(@PathVariable("id") long id){
        sender.sendTopicDelete(exchange,delete_routekey,id);
    }

    @PostMapping("/create")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date()); //获取系统时间，添加到user对象
        String json_object = JSONObject.toJSONString(user);
        sender.sendTopicCreateUser(exchange,createuser_routekey,json_object);
    }
}
