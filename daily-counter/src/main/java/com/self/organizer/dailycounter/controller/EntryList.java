package com.self.organizer.dailycounter.controller;

import com.self.organizer.dailycounter.domain.Entry;

import java.util.List;

public class EntryList {
    List<Entry> entryList;

    public EntryList() {
    }

    public EntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}
