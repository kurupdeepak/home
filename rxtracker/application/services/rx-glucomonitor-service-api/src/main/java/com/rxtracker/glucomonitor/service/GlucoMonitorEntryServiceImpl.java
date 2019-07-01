package com.rxtracker.glucomonitor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.rxtracker.glucomonitor.dao.GlucoMonitorEntry;
import com.rxtracker.glucomonitor.dao.GlucoMonitorRepository;
import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;

@Service
public class GlucoMonitorEntryServiceImpl implements GlucoMonitorEntryService {

	@Autowired
	GlucoMonitorRepository repository;
	
	@Autowired
	Mapper dozerMapper;
	
	public GlucoMonitorEntryServiceImpl() {
	}

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
		
		repository.save(dozerMapper.map(entry, GlucoMonitorEntry.class));;
		return entry.getEntryId();
	}

	@Override
	public GlucoMonitorEntryVO getEntry(Long id) throws GlucoMonitorServiceFailureException {
		GlucoMonitorEntry result = repository.getOne(id);
		return dozerMapper.map(result, GlucoMonitorEntryVO.class);
	}

	@Override
	public List<GlucoMonitorEntryVO> getEntries(Long userId) {
		List<GlucoMonitorEntry> results = repository.findEntriesByUserId(userId);
		List<GlucoMonitorEntryVO> destList = new ArrayList<>();
		results.stream().forEach(result -> destList.add(dozerMapper.map(result, GlucoMonitorEntryVO.class)));
		return destList;
	}
}
