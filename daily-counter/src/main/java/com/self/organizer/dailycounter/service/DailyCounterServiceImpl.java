package com.self.organizer.dailycounter.service;

import com.self.organizer.dailycounter.dao.*;
import com.self.organizer.dailycounter.domain.Counter;
import com.self.organizer.dailycounter.domain.Entry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DailyCounterServiceImpl implements DailyCounterService {

    private final EntryRepository entryRepository;

    private final CounterRepository counterRepository;

    public DailyCounterServiceImpl(EntryRepository entryRepository, CounterRepository counterRepository) {
        this.entryRepository = entryRepository;
        this.counterRepository = counterRepository;
    }

    @Override
    public void addDailyCounterLabel(String name) {
       Counter counter = counterRepository.save(new Counter(name));
    }

    @Override
    public Counter getCounter(String name) throws DailyCounterServiceException {
        Counter counter = counterRepository.findByName(name);
        if(counter == null)
            throw new InvalidCounterException(name);
        return counter;
    }

    @Override
    public List<Counter> getAllCounters() throws DailyCounterServiceException {
        Iterable<Counter> counters = counterRepository.findAll();
        List<Counter> counterList = new ArrayList<>();
        counters.iterator().forEachRemaining(counter -> counterList.add(counter));
        return counterList;
    }

    @Override
    public List<Entry> getEntries(Counter counter) throws DailyCounterServiceException {
        Counter counter1 = counterRepository.findByName(counter.getName());
        if(counter1 == null)
            throw new InvalidCounterException(counter.getName());
        return entryRepository.findAllByCounterName(counter.getName());
    }

    @Override
    public List<Entry> getEntries(String name) throws DailyCounterServiceException {
        Counter counter1 = counterRepository.findByName(name);
        if(counter1 == null)
            throw new InvalidCounterException(name);
        return entryRepository.findAllByCounterName(name);
    }

    @Override
    public void addEntry(Entry entry) throws InvalidCounterException {
        Counter counter = counterRepository.findByName(entry.getCounterName());
        if(counter == null)
            throw new InvalidCounterException(entry.getCounterName());
        Entry entry1 = entryRepository.save(entry);
    }

    @Override
    public Entry getEntryById(int id) throws DailyCounterServiceException {
        Optional<Entry> entry = entryRepository.findById(id);
        if(!entry.isPresent())
            throw new InvalidEntryException("Entry :" + id);
        return entry.get();
    }

    @Override
    public void deleteEntry(String counterName,int entryId) throws InvalidCounterException, InvalidEntryException {
        Counter counter = counterRepository.findByName(counterName);
        if(counter == null)
            throw new InvalidCounterException(counterName);
        Optional<Entry> entry = entryRepository.findById(entryId);
        if(!entry.isPresent())
            throw new InvalidEntryException(counterName + " : " + entryId);
        entryRepository.delete(entry.get());
    }
}
