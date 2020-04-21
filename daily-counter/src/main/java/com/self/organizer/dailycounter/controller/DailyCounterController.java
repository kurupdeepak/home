package com.self.organizer.dailycounter.controller;

import com.self.organizer.dailycounter.controller.vo.CounterVO;
import com.self.organizer.dailycounter.controller.vo.EntryVO;
import com.self.organizer.dailycounter.domain.Counter;
import com.self.organizer.dailycounter.domain.Entry;
import com.self.organizer.dailycounter.service.DailyCounterServiceException;
import com.self.organizer.dailycounter.service.DailyCounterService;
import com.self.organizer.dailycounter.service.DailyCounterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/self/daily")
public class DailyCounterController {

    DailyCounterService dailyCounterService;

    public DailyCounterController(DailyCounterServiceImpl dailyCounterService) {
        this.dailyCounterService = dailyCounterService;
    }

    @PostMapping("/counter/{counter}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCounter(@PathVariable("counter") String name){
        try {
            dailyCounterService.addDailyCounterLabel(name);
        } catch (DailyCounterServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/counter/{counter}/entries",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEntry(@PathVariable("counter") String name, @RequestBody EntryVO entryVO){
        try {
            Entry entry = new Entry();
            entry.setCounterName(name);
            entry.setDetails(entryVO.getDetails());
            entry.setValue(entryVO.getValue());
            entry.setTimeOfEntry(LocalDateTime.now());
            dailyCounterService.addEntry(entry);
        } catch (DailyCounterServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/counter/{counter}/entries")
    @ResponseStatus(HttpStatus.OK)
    public List<EntryVO> getEntries(@PathVariable("counter") String name)
    {
        List<EntryVO> entryList;
        try {
            List<Entry> entries = dailyCounterService.getEntries(name);
            entryList = entries.stream().map(entry -> {
                EntryVO entryVO = new EntryVO();
                entryVO.setCounterName(entry.getCounterName());
                entryVO.setId(entry.getId());
                entryVO.setDetails(entry.getDetails());
                entryVO.setValue(entry.getValue());
                entryVO.setTimeOfEntry(entry.getTimeOfEntry());
                return entryVO;
            }).collect(Collectors.toList());
        } catch (DailyCounterServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return entryList;
    }

    @GetMapping("/counter")
    @ResponseStatus(HttpStatus.OK)
    public List<CounterVO> getCounters()
    {
        List<CounterVO> counterVOList ;
        try {
            List<Counter> counters = dailyCounterService.getAllCounters();
           counterVOList =  counters.stream().map(counter -> {
                CounterVO counterVO = new CounterVO();
                counterVO.setName(counter.getName());
                counterVO.setId(counter.getId());
                return counterVO;
            }).collect(Collectors.toList());
        } catch (DailyCounterServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return counterVOList;
    }

    @GetMapping("/counter/all")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,List<EntryVO>> getCountersWithEntries()
    {
        Map<String,List<EntryVO>> counterEntriesMap = new HashMap<>();
        try {
            List<Counter> counters = dailyCounterService.getAllCounters();
            for(Counter counter: counters){
                counterEntriesMap.put(counter.getName(),getEntries(counter.getName()));
            }
        } catch (DailyCounterServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return counterEntriesMap;
    }

}
