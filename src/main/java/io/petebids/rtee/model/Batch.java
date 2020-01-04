package io.petebids.rtee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
public class Batch implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String status;
    @NotNull
    private String queueName;
    @NotNull
    private Date expiresOn;

    public Batch() {
    }

    public Batch(Long id, String status, String queueName, Date expiresOn) {
        this.id = id;
        this.status = status;
        this.queueName = queueName;
        this.expiresOn = expiresOn;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Date getExpiresOn() {
        return this.expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", queueName='" + getQueueName() + "'" +
            ", expiresOn='" + getExpiresOn() + "'" +
            "}";
    }

}