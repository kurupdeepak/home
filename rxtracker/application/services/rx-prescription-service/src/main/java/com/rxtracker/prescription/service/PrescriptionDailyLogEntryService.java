package com.rxtracker.prescription.service;

import java.time.LocalDate;
import java.util.List;

import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;

public interface PrescriptionDailyLogEntryService {

	Long addUsage(PrescriptionDailyLogEntry p) throws PrescriptionDailyLogServiceException;
	Long deleteUsage(Long id) throws PrescriptionDailyLogServiceException;
	Long updateUsage(PrescriptionDailyLogEntry p) throws PrescriptionDailyLogServiceException;
	PrescriptionDailyLogEntry getPrescriptionUsage(Long id) throws PrescriptionDailyLogServiceException;
	List<PrescriptionDailyLogEntry> getAll(LocalDate day);
	List<PrescriptionDailyLogEntry> getAll(LocalDate start,LocalDate end);
	List<PrescriptionDailyLogEntry> getAllBetweenDates(LocalDate start,LocalDate end);
}
