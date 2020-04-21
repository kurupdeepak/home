package com.self.organizer.dailycounter.controller;

import com.self.organizer.dailycounter.domain.Counter;

import java.util.List;

public class CounterList {
    List<Counter> counterList ;

    public CounterList() {
    }

    public CounterList(List<Counter> counterList) {
        this.counterList = counterList;
    }

    public List<Counter> getCounterList() {
        return counterList;
    }

    public void setCounterList(List<Counter> counterList) {
        this.counterList = counterList;
    }
}
