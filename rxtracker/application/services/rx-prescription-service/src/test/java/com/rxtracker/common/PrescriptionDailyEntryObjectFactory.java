package com.rxtracker.common;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rxtracker.prescription.dao.PrescriptionDailyLogRepository;
import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;
import com.rxtracker.prescription.vo.PrescriptionDailyLogEntryVO;

@Component
public class PrescriptionDailyEntryObjectFactory extends AbstractObjectTestFactory<PrescriptionDailyLogEntryVO> {

	@Autowired
	protected PrescriptionDailyLogRepository repository;
	
	@Override
	public PrescriptionDailyLogEntryVO createTestObject() {
		return dozerMapper.map(repository.save(initObject()), PrescriptionDailyLogEntryVO.class);
	}
	
	
	@Override
	public List<PrescriptionDailyLogEntryVO> createTestObject(int noOfObjects) {
		List<PrescriptionDailyLogEntryVO> tmpList = new ArrayList<>();
		for(int i = 0 ; i < noOfObjects;i++) {
			tmpList.add(dozerMapper.map(repository.save(initObject()), PrescriptionDailyLogEntryVO.class));
		}
		return tmpList;
	}

	protected PrescriptionDailyLogEntry initObject() {
		Long random = (long) rg.nextInt((50 - 10) + 10);
		PrescriptionDailyLogEntry entryObject = new PrescriptionDailyLogEntry();
		entryObject.setPrescriptionId(random * 10);
		entryObject.setPrescriptionId(1L);
		entryObject.setUsageTime(LocalDateTime.now());
		entryObject.setUnitsTaken(1000D);
		return entryObject;
	}
	
}
