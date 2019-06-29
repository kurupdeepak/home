package com.rxtracker.prescription.service;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxtracker.prescription.dao.PrescriptionRepository;
import com.rxtracker.prescription.data.Prescription;
import com.rxtracker.prescription.vo.PrescriptionVO;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	PrescriptionRepository repository;
	
	@Autowired
	Mapper dozerMapper ;
	
	
	
	@Override
	public Long addPrescription(PrescriptionVO p) throws PrescriptionServiceException {
		Prescription result = repository.save(dozerMapper.map(p, Prescription.class));
		return result.getPrescriptionId();
	}

	@Override
	public Long deletePrescription(Long id) throws PrescriptionNotFoundException {
		try {
			getPrescription(id);	
		}catch(Exception e) {
			throw new PrescriptionNotFoundException("Cannot delete : prescription " + e.getMessage());
		}
		repository.delete(id);
		return id;
	}

	@Override
	public Long updatePrescription(PrescriptionVO p) throws PrescriptionNotFoundException {
		try {
			getPrescription(p.getPrescriptionId());	
		}catch(Exception e) {
			throw new PrescriptionNotFoundException("Cannot update : prescription " + e.getMessage());
		}
		Prescription result = repository.save(dozerMapper.map(p, Prescription.class));
		return result.getPrescriptionId();
	}

	@Override
	public PrescriptionVO getPrescription(Long id) throws PrescriptionNotFoundException {
		Prescription p = repository.findOne(id);
		if(p == null)
			throw new PrescriptionNotFoundException();
		return dozerMapper.map(p, PrescriptionVO.class);
	}


	@Override
	public List<PrescriptionVO> getPrescriptions() {
		return dozerMapper.map(repository.findAll(),List.class);
	}

}
