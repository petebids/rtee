package io.petebids.rtee.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;


import io.petebids.rtee.payload.CreateTopicRequest;
import io.petebids.rtee.payload.CreateTopicResponse;

public class AdminService{

    @Autowired
    AdminClient adminClient;

    public ResponseEntity<CreateTopicResponse> createTopic(CreateTopicRequest payload) throws ExecutionException , InterruptedException{
        CreateTopicResponse response = new CreateTopicResponse();
        try {
        
        Collection<TopicListing> topics = adminClient.listTopics().listings().get();
        for (TopicListing t : topics){
            if (t.name().equalsIgnoreCase(payload.getTopicName())){
                
                response.setMessage("Queue " + payload.getTopicName() + " Already exists");
                response.setTopicName(payload.getTopicName());
                return ResponseEntity.status(HttpStatus.OK).body(response) ;
            }
            else{
                CreateTopicsResult result = adminClient.createTopics(Collections.singleton(new NewTopic(payload.getTopicName() , 1 , (short) 1)));
                response.setMessage("Queue " + payload.getTopicName() + " sucessfully created");
                response.setTopicName(payload.getTopicName());
                return ResponseEntity.status(HttpStatus.CREATED).body(response) ; 
            }
        }}
        catch (ExecutionException | InterruptedException ex) {
            response.setMessage(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response) ; 
        }
        return null;
        
    }
    
}