package com.es.utils.rabbitmq;

import com.es.config.RabbitmqConf;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg<T> {


    //注入消息模板
    @Autowired
    private AmqpTemplate amqp;

    public void send(T t)
    {
        amqp.convertAndSend(RabbitmqConf.QUEUE1,t);
    }
}
