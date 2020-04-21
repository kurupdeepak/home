package com.self.organizer.dailycounter.service;

import com.self.organizer.dailycounter.domain.Counter;
import com.self.organizer.dailycounter.domain.Entry;

import java.util.List;

public interface DailyCounterService {
    void addDailyCounterLabel(String name) throws DailyCounterServiceException;

    Counter getCounter(String name) throws DailyCounterServiceException;

    List<Counter> getAllCounters() throws DailyCounterServiceException;

    List<Entry> getEntries(Counter counter) throws DailyCounterServiceException;

    List<Entry> getEntries(String name) throws DailyCounterServiceException;

    void addEntry(Entry entry) throws DailyCounterServiceException;

    Entry getEntryById(int id)  throws DailyCounterServiceException;

    void deleteEntry(String counterName,int entryId) throws DailyCounterServiceException;
}
