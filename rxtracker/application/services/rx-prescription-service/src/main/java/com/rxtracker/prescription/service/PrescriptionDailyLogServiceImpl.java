package com.rxtracker.prescription.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxtracker.prescription.dao.PrescriptionDailyLogRepository;
import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;

@Service
public class PrescriptionDailyLogServiceImpl implements PrescriptionDailyLogEntryService {
	@Autowired
	PrescriptionDailyLogRepository repository;
	
	@Override
	public Long addUsage(PrescriptionDailyLogEntry p) throws PrescriptionDailyLogServiceException {
		PrescriptionDailyLogEntry result = repository.save(p);
		return result.getUsageId();
	}

	@Override
	public Long deleteUsage(Long id) throws PrescriptionDailyLogServiceException {
		try {
			getPrescriptionUsage(id);	
		}catch(Exception e) {
			throw new PrescriptionDailyLogServiceException("Cannot delete : prescription " + e.getMessage());
		}
		repository.delete(id);
		return id;
	}

	@Override
	public Long updateUsage(PrescriptionDailyLogEntry p) throws PrescriptionDailyLogServiceException {
		try {
			getPrescriptionUsage(p.getUsageId());	
		}catch(Exception e) {
			throw new PrescriptionDailyLogServiceException("Cannot update : prescription " + e.getMessage());
		}
		PrescriptionDailyLogEntry result = repository.save(p);
		return result.getUsageId();
	}

	@Override
	public PrescriptionDailyLogEntry getPrescriptionUsage(Long id) throws PrescriptionDailyLogServiceException {
		PrescriptionDailyLogEntry p = repository.findOne(id);
		if(p == null)
			throw new PrescriptionDailyLogServiceException();
		return p;
	}


	@Override
	public List<PrescriptionDailyLogEntry> getAll(LocalDate day) {
		return repository.findAll();
	}

	@Override
	public List<PrescriptionDailyLogEntry> getAll(LocalDate start, LocalDate end) {
		return repository.findAll();	}

	@Override
	public List<PrescriptionDailyLogEntry> getAllBetweenDates(LocalDate start, LocalDate end) {
		 return repository.findAll();
	}

}
