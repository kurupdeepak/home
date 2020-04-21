package com.lab.counter;

import java.time.LocalDateTime;

public interface DailyCounter {
    void addDailyCounterLabel(String name);
    void addEntry(Entry entry);
    void deleteEntry(Entry entry);
}
