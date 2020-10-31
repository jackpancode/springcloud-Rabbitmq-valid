package com.besti.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange topicEchange(){
        return new TopicExchange("exchange-test");
    }

    @Bean(name="delete_message")
    public Queue deletequeue(){
        return  new Queue("topic.find");
    }

    @Bean(name="createuser_message")
    public Queue createqueue(){
        return  new Queue("topic.createuser");
    }

    @Bean
    public Binding deleteByid_binding(@Qualifier("delete_message") Queue queue, TopicExchange topicExchange){

        return BindingBuilder.bind(queue).to(topicExchange).with("topic.find.routingkey");
    }

    @Bean
    public Binding createUser_binding(@Qualifier("createuser_message") Queue queue,TopicExchange topicExchange){

        return BindingBuilder.bind(queue).to(topicExchange).with("topic.createuser.routingkey");
    }
}
