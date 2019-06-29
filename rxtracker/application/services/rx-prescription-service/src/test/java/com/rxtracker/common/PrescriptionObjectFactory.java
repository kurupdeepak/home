package com.rxtracker.common;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rxtracker.prescription.dao.PrescriptionRepository;
import com.rxtracker.prescription.data.Prescription;
import com.rxtracker.prescription.vo.PrescriptionVO;

@Component
public class PrescriptionObjectFactory extends AbstractObjectTestFactory<PrescriptionVO> {

	@Autowired
	PrescriptionRepository repository;

	@Override
	public PrescriptionVO createTestObject() {
		return dozerMapper.map(repository.save(initObject()), PrescriptionVO.class);
	}
	
	
	@Override
	public List<PrescriptionVO> createTestObject(int noOfObjects) {
		List<PrescriptionVO> tmpList = new ArrayList<>();
		for(int i = 0 ; i < noOfObjects;i++) {
			tmpList.add(dozerMapper.map(repository.save(initObject()), PrescriptionVO.class));
		}
		return tmpList;
	}

	protected Prescription initObject() {
		Long random = (long) rg.nextInt((50 - 10) + 10);
		Prescription entryObject = new Prescription();
		entryObject.setPrescriptionId(random * 10);
		entryObject.setActive(true);
		entryObject.setDateOfPurchase(LocalDateTime.now());
		entryObject.setRxName("Tylenol");
		entryObject.setRxUnitType("mg");
		entryObject.setRxPrescribedUnit(1000);
		entryObject.setUserId(1L);
		entryObject.setRxUsageInterval("DAILY_ONCE");
		return entryObject;
	}
	
}
