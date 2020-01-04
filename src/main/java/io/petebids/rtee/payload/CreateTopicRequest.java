package io.petebids.rtee.payload;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CreateTopicRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @NotNull
    private String topicName;

    public CreateTopicRequest() {
    }

    public CreateTopicRequest(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }



    @Override
    public String toString() {
        return "{" +
            " topicName='" + getTopicName() + "'" +
            "}";
    }

}
