package com.itheima.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {
    @Autowired
    private ObjectMapper objectMapper;
    //用来接收消息
    //监听kafka的服务端
    //topics：用于指定要监听的主题
    @KafkaListener(topics = {"heima"})
    public void receiveMessage(ConsumerRecord<String,String> record) throws JsonProcessingException {
        System.out.println("=================222222222222================");
            //record 就是消息内容所在的对象
        String value = record.value();
        System.out.println("偏移量："+record.offset());
        System.out.println(value);
        System.out.println("接收到的消息:"+objectMapper.readValue(value, Message.class).getMsg());
    }
}
