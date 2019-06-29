package com.rxtracker.prescription.service;

import java.util.List;

import com.rxtracker.prescription.vo.PrescriptionVO;

public interface PrescriptionService {

	Long addPrescription(PrescriptionVO p) throws PrescriptionServiceException;
	Long deletePrescription(Long id) throws PrescriptionNotFoundException;
	Long updatePrescription(PrescriptionVO p) throws PrescriptionNotFoundException;
	PrescriptionVO getPrescription(Long id) throws PrescriptionNotFoundException;
	List<PrescriptionVO> getPrescriptions();
}
