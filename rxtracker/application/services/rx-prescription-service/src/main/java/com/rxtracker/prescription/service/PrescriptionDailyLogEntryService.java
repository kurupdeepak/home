package com.rxtracker.prescription.service;

import java.time.LocalDate;
import java.util.List;

import com.rxtracker.prescription.vo.PrescriptionDailyLogEntryVO;

public interface PrescriptionDailyLogEntryService {

	Long addUsage(PrescriptionDailyLogEntryVO p) throws PrescriptionDailyLogServiceException;
	Long deleteUsage(Long id) throws PrescriptionDailyLogServiceException;
	Long updateUsage(PrescriptionDailyLogEntryVO p) throws PrescriptionDailyLogServiceException;
	PrescriptionDailyLogEntryVO getPrescriptionUsage(Long id) throws PrescriptionDailyLogServiceException;
	List<PrescriptionDailyLogEntryVO> getAll(LocalDate day);
	List<PrescriptionDailyLogEntryVO> getAll(LocalDate start,LocalDate end);
	List<PrescriptionDailyLogEntryVO> getAllBetweenDates(LocalDate start,LocalDate end);
}
