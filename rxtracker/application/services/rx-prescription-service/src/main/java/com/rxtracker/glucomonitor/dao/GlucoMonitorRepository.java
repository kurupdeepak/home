package com.rxtracker.glucomonitor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GlucoMonitorRepository extends JpaRepository<GlucoMonitorEntry, Long> {

	List<GlucoMonitorEntry> findEntriesByUserId(Long userId);

}
