package com.kurup.cainerscrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class Job {
    @Id
    String jobID;

    LocalDateTime jobRunDate;

    String status;

    String errorMsg;


    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public LocalDateTime getJobRunDate() {
        return jobRunDate;
    }

    public void setJobRunDate(LocalDateTime jobRunDate) {
        this.jobRunDate = jobRunDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
