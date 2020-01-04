package io.petebids.rtee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.petebids.rtee.model.Batch;
import io.petebids.rtee.payload.QueueResponse;
import io.petebids.rtee.repository.BatchRepository;

@Service
public class BatchService {

    @Autowired
    BatchRepository batchRepository;

    @Autowired
    ProducerService producerService;

    ResponseEntity<List<Batch>> getBatchesByQueueName(String queueName) {
        List<Batch> response = batchRepository.findByqueuename(queueName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    ResponseEntity<Batch> createAndEnqueueBatch(Batch batch) {
        batchRepository.save(batch);
        producerService.sendMessage(batch.getQueueName(), batch.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(batch);
    }

    ResponseEntity<Optional<Batch>> getById(Long batchID){
        Optional<Batch> batch =  batchRepository.findById(batchID);
        return ResponseEntity.status(HttpStatus.OK).body(batch);

        
        
    }


}