package com.rxtracker.prescription.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.rxtracker.prescription.dao.PrescriptionDailyLogRepository;
import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;
import com.rxtracker.prescription.vo.PrescriptionDailyLogEntryVO;

@Service
public class PrescriptionDailyLogServiceImpl implements PrescriptionDailyLogEntryService {
	@Autowired
	PrescriptionDailyLogRepository repository;
	
	@Autowired 
	Mapper dozerMapper;
	
	@Override
	public Long addUsage(PrescriptionDailyLogEntryVO p) throws PrescriptionDailyLogServiceException {
		PrescriptionDailyLogEntry result = repository.save(dozerMapper.map(p,PrescriptionDailyLogEntry.class));
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
	public Long updateUsage(PrescriptionDailyLogEntryVO p) throws PrescriptionDailyLogServiceException {
		try {
			getPrescriptionUsage(p.getUsageId());	
		}catch(Exception e) {
			throw new PrescriptionDailyLogServiceException("Cannot update : prescription " + e.getMessage());
		}
		PrescriptionDailyLogEntry result = repository.save(dozerMapper.map(p,PrescriptionDailyLogEntry.class));
		return result.getUsageId();
	}

	@Override
	public PrescriptionDailyLogEntryVO getPrescriptionUsage(Long id) throws PrescriptionDailyLogServiceException {
		PrescriptionDailyLogEntry p = repository.findOne(id);
		if(p == null)
			throw new PrescriptionDailyLogServiceException();
		return dozerMapper.map(p,PrescriptionDailyLogEntryVO.class);
	}


	@Override
	public List<PrescriptionDailyLogEntryVO> getAll(LocalDate day) {
		return map(repository.findAll());
	}

	@Override
	public List<PrescriptionDailyLogEntryVO> getAll(LocalDate start, LocalDate end) {
		return map(repository.findAll());	}

	@Override
	public List<PrescriptionDailyLogEntryVO> getAllBetweenDates(LocalDate start, LocalDate end) {
		 return map(repository.findAll());
	}

	protected List<PrescriptionDailyLogEntryVO> map(List<PrescriptionDailyLogEntry> results){
		List<PrescriptionDailyLogEntryVO> destList = new ArrayList<>();
		results.stream().forEach(result -> destList.add(dozerMapper.map(repository.findAll(),PrescriptionDailyLogEntryVO.class)));
		dozerMapper.map(results,destList);
		return destList;
	}
}
