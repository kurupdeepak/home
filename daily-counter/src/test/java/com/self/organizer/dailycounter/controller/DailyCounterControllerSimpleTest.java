package com.self.organizer.dailycounter.controller;

import com.self.organizer.dailycounter.controller.vo.EntryVO;
import com.self.organizer.dailycounter.dao.CounterRepository;
import com.self.organizer.dailycounter.dao.EntryRepository;
import com.self.organizer.dailycounter.service.DailyCounterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DailyCounterControllerSimpleTest {

    DailyCounterController dailyCounterController;

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    CounterRepository counterRepository;

    @BeforeEach
    void setup(){
        dailyCounterController= new DailyCounterController(new DailyCounterServiceImpl(entryRepository,counterRepository));
    }

    @Test
    void test_CreateCounter(){
        String name = "SimpleCounter";
        dailyCounterController.createCounter("SimpleCounter");
        List<EntryVO> entryList = dailyCounterController.getEntries(name);
        assertThat(entryList).isNullOrEmpty();
    }

    @Test
    void test_CreateEntry(){
        String name = "SimpleCounter";
        dailyCounterController.createCounter("SimpleCounter");
        EntryVO entry = new EntryVO();
        entry.setValue(10);
        entry.setDetails("Some text value");
        dailyCounterController.createEntry(name,entry);
        List<EntryVO> entryList = dailyCounterController.getEntries(name);
        assertThat(entryList).hasSize(1);
    }

}