package com.self.organizer.dailycounter.dao;

import com.self.organizer.dailycounter.domain.Counter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter,Integer> {
    Counter findByName(String name);
}
