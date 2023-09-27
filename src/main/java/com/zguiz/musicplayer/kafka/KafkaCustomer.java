package com.zguiz.musicplayer.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaCustomer {
    @KafkaListener(topics= "topicName",groupId = "consumerGroup")
    public void consumMessage(String msg){
        System.out.println("Message is :" +msg);
    }
}
