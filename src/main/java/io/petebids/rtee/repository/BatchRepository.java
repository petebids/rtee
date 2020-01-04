package io.petebids.rtee.repository;

import io.petebids.rtee.model.Batch;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface BatchRepository extends CrudRepository<Batch , Long>{
    
    
    List<Batch> findByqueuename(String queueName);
    
}