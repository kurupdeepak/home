package com.self.organizer.dailycounter.service;

import com.self.organizer.dailycounter.dao.CounterRepository;
import com.self.organizer.dailycounter.dao.EntryRepository;
import com.self.organizer.dailycounter.domain.Counter;
import com.self.organizer.dailycounter.domain.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DailyCounterServiceImplTest {
    DailyCounterServiceImpl dailyCounter;

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    CounterRepository counterRepository;

    @BeforeEach
    void setUp() {
        dailyCounter = new DailyCounterServiceImpl(entryRepository,counterRepository);
    }

    @Test
    void addDailyCounterLabel() throws DailyCounterServiceException {
        assertThat(createCounter()).isNotNull();
    }

    @Test
    void addEntry() throws DailyCounterServiceException {
       Counter counter = createCounter();
        Entry entry = createEntry(counter);
        dailyCounter.addEntry(entry);
        assertThat(dailyCounter.getEntries(counter.getName())).hasSize(1);
    }

    @Test
    void deleteEntry() throws DailyCounterServiceException {
        Counter counter = createCounter();
        Entry entry = createEntry(counter);
        dailyCounter.addEntry(entry);
        Entry entry1 = dailyCounter.getEntries(counter.getName()).get(0);
        dailyCounter.deleteEntry(counter.getName(), entry1.getId());
        assertThat(dailyCounter.getEntries(counter.getName())).isEmpty();
    }

    protected Counter createCounter() throws DailyCounterServiceException {
        String name = "TestCounter";
        dailyCounter.addDailyCounterLabel(name);
        Counter counter = dailyCounter.getCounter(name);
        return counter;
    }

    protected Entry createEntry(Counter counter){
        Entry entry = new Entry();
        entry.setCounterName(counter.getName());
        entry.setTimeOfEntry(LocalDateTime.now());
        entry.setValue(5);
        return entry;
    }
}