package io.petebids.rtee.payload;

import java.io.Serializable;

public class CreateTopicResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private String topicName;
    private String message;

    public CreateTopicResponse() {
    }

    public CreateTopicResponse(String topicName, String message) {
        this.topicName = topicName;
        this.message = message;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    @Override
    public String toString() {
        return "{" +
            " topicName='" + getTopicName() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }


}