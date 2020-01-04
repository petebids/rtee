package io.petebids.rtee.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class ProducerService{

    @Autowired
    KafkaTemplate<String , String> kafkaTemplate;

    // at present a do nothing wrapper , will add saving instance to db later 
    public void sendMessage(String topic, String message){
        kafkaTemplate.send(topic , message);

    }


}