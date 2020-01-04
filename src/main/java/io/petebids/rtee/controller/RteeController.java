package io.petebids.rtee.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.apache.kafka.common.requests.CreateTopicsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.petebids.rtee.model.Batch;
import io.petebids.rtee.payload.CreateTopicRequest;
import io.petebids.rtee.payload.CreateTopicResponse;
import io.petebids.rtee.payload.QueueResponse;
import io.petebids.rtee.service.AdminService;
import io.petebids.rtee.service.BatchService;
import io.petebids.rtee.service.ProducerService;

@RestController
@RequestMapping("/api/v1/")
public class RteeController {

    @Autowired
    private BatchService batchService;


    @Autowired
    private AdminService adminService;
    // create new queue
    @PostMapping("queue")
    ResponseEntity<CreateTopicResponse> createQueue(@Valid @RequestBody CreateTopicRequest payload)
            throws ExecutionException, InterruptedException {
        return adminService.createTopic(payload);
    }
    // create new batch
    @PostMapping("batch")
    ResponseEntity<Batch> createBatch(@Valid @RequestBody Batch batch){
        return batchService.createAndEnqueueBatch(batch);

    }

    //get aLL BATCHES IN QUEUE
    @GetMapping("queue/{queuename}/")
    ResponseEntity<List<Batch>> getQueueByName(@PathVariable(value = "queuename") final String queueName){
        return batchService.getBatchesByQueueName(queueName);
    }

    @GetMapping("batch/{id}")
    ResponseEntity<Optional<Batch>> getBatchById(@PathVariable(value="Id") final Long batchId){
        return batchService.getById(batchId);
    }

}