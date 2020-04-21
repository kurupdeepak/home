package com.self.organizer.dailycounter.dao;

import com.self.organizer.dailycounter.domain.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends CrudRepository<Entry,Integer> {
    List<Entry> findAllByCounterName(String name);
}
