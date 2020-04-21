package com.self.organizer.dailycounter.controller.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EntryVO implements Serializable {
    int id;

    String counterName;

    int value;

    String details;

    LocalDateTime timeOfEntry;

    public int getId() {
        return id;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeOfEntry(LocalDateTime timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

}
