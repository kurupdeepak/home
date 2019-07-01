package com.rxtracker.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rxtracker.glucomonitor.dao.GlucoMonitorEntry;
import com.rxtracker.glucomonitor.dao.GlucoMonitorRepository;
import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;

@Component
public class GlucoMonitorObjectFactory extends AbstractObjectTestFactory<GlucoMonitorEntryVO> {

	@Autowired
	GlucoMonitorRepository repository;
	
	@Override
	public GlucoMonitorEntryVO createTestObject() {
		return dozerMapper.map(repository.save(initObject()), GlucoMonitorEntryVO.class);
	}
	
	
	@Override
	public List<GlucoMonitorEntryVO> createTestObject(int noOfObjects) {
		List<GlucoMonitorEntryVO> tmpList = new ArrayList<>();
		for(int i = 0 ; i < noOfObjects;i++) {
			tmpList.add(dozerMapper.map(repository.save(initObject()), GlucoMonitorEntryVO.class));
		}
		return tmpList;
	}

	protected GlucoMonitorEntry initObject() {
		Long random = (long) rg.nextInt((50 - 10) + 10);
		GlucoMonitorEntryVO entryObject = new GlucoMonitorEntryVO();
		entryObject.setEntryId(random * 10);
		entryObject.setLevelEntered((float) (random/10));
		entryObject.setNotes("This is a dummy notes for test");
		entryObject.setUserId(1L);
		return dozerMapper.map(entryObject, GlucoMonitorEntry.class);
	}
	
}
