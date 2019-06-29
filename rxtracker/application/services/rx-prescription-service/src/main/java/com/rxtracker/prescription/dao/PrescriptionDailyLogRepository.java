package com.rxtracker.prescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;

public interface PrescriptionDailyLogRepository extends JpaRepository<PrescriptionDailyLogEntry, Long> {

}
