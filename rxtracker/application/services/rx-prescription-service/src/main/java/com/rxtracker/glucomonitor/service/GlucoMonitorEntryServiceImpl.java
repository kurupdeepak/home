package com.rxtracker.glucomonitor.service;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxtracker.glucomonitor.dao.GlucoMonitorEntry;
import com.rxtracker.glucomonitor.dao.GlucoMonitorRepository;
import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;

@Service
public class GlucoMonitorEntryServiceImpl implements GlucoMonitorEntryService {

	@Autowired
	GlucoMonitorRepository repository;
	
	@Autowired
	Mapper dozerMapper;
	
	@Override
	public Long addEntry(GlucoMonitorEntryVO entry) throws GlucoMonitorServiceFailureException {
		GlucoMonitorEntry entity = repository.save(dozerMapper.map(entry, GlucoMonitorEntry.class));
		return entity.getEntryId();
	}

	@Override
	public Long deleteEntry(Long id) throws GlucoMonitorServiceFailureException {
		if(getEntry(id) == null)
			throw new GlucoMonitorServiceFailureException("Cannot delete !! no entry with " + id);
		repository.delete(id);
		return id;
	}

	@Override
	public Long modifyEntry(GlucoMonitorEntryVO entry) throws GlucoMonitorServiceFailureException {
		if(getEntry(entry.getEntryId()) == null)
			throw new GlucoMonitorServiceFailureException("Cannot update !! no entry with " + entry.getEntryId());
		
		GlucoMonitorEntry entity = repository.save(dozerMapper.map(entry, GlucoMonitorEntry.class));;
		return entry.getEntryId();
	}

	@Override
	public GlucoMonitorEntryVO getEntry(Long id) throws GlucoMonitorServiceFailureException {
		GlucoMonitorEntry result = repository.getOne(id);
		return dozerMapper.map(result, GlucoMonitorEntryVO.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GlucoMonitorEntryVO> getEntries(Long userId) {
		List<GlucoMonitorEntry> results = repository.findEntriesByUserId(userId);
		return dozerMapper.map(results, List.class);
	}
}
