package com.rxtracker.prescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rxtracker.prescription.service.PrescriptionService;
import com.rxtracker.prescription.vo.PrescriptionVO;

@RestController
@RequestMapping("/api/users/{userId}")
public class PrescriptionController {
	@Autowired 
	PrescriptionService service;
	
	@PostMapping("/prescriptions")
	public Long addPrescription(@PathVariable("userId") Long userId,PrescriptionVO p) {
		p.setUserId(userId);
		return service.addPrescription(p);
	}
	
	@DeleteMapping("/prescriptions/{id}")
	public Long deletePrescription(@PathVariable("userId") Long userId,@PathVariable("id") Long id) {
		//TODO user ID
		return service.deletePrescription(id);
	}
	
	@PutMapping("/prescriptions/{id}")
	public Long updatePrescription(@PathVariable("userId") Long userId,@PathVariable("id") Long id,@RequestBody PrescriptionVO p) {
		p.setPrescriptionId(id);
		p.setUserId(userId);
		return service.updatePrescription(p);
	}
	
	@GetMapping("/prescriptions/{id}")
	public PrescriptionVO getPrescription(@PathVariable("userId") Long userId,@PathVariable("id") Long id) {
		//TODO
		return service.getPrescription(id);
	}
	
	@GetMapping("/prescriptions")
	public List<PrescriptionVO> allPrescriptions(@PathVariable("userId") Long userId) {
		//TODO
		return service.getPrescriptions();
	}
	
}
