package io.petebids.rtee.payload;

import io.petebids.rtee.model.Batch;

public class QueueResponse{

    private Batch[] batches ; 

    public QueueResponse() {
    }

    public QueueResponse(Batch[] batches) {
        this.batches = batches;
    }

    public Batch[] getBatches() {
        return this.batches;
    }

    public void setBatches(Batch[] batches) {
        this.batches = batches;
    }



    @Override
    public String toString() {
        return "{" +
            " batches='" + getBatches() + "'" +
            "}";
    }

}