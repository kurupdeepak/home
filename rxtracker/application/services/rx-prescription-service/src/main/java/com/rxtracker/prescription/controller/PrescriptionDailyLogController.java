package com.rxtracker.prescription.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;
import com.rxtracker.prescription.service.PrescriptionDailyLogEntryService;

@RestController
@RequestMapping("/api/users/{userId}/prescriptions")
public class PrescriptionDailyLogController {
	@Autowired 
	PrescriptionDailyLogEntryService service;
	
	@PostMapping("/entries")
	public Long addPrescription(@PathVariable("userId") Long userId,PrescriptionDailyLogEntry p) {
		//TODO
		return service.addUsage(p);
	}
	
	@DeleteMapping("/entries/{id}")
	public Long deletePrescription(@PathVariable("userId") Long userId,@PathVariable("id") Long id) {
		//TODO
		return service.deleteUsage(id);
	}
	
	@PutMapping("/entries/{id}")
	public Long updatePrescription(@PathVariable("userId") Long userId,@PathVariable("id") Long id,@RequestBody PrescriptionDailyLogEntry p) {
		//TODO
		p.setPrescriptionId(id);
		return service.updateUsage(p);
	}
	
	@GetMapping("/entries/{id}")
	public PrescriptionDailyLogEntry getPrescription(@PathVariable("userId") Long userId,@PathVariable("id") Long id) {
		//TODO
		return service.getPrescriptionUsage(id);
	}
	
	@GetMapping("/entries")
	public List<PrescriptionDailyLogEntry> allPrescriptions(@PathVariable("userId") Long userId) {
		//TODO
		return service.getAll(LocalDateTime.now().toLocalDate());
	}
	
	@GetMapping("/entries/{from}/{to}")
	public List<PrescriptionDailyLogEntry> allPrescriptions(@PathVariable("userId") Long userId,@PathVariable("from") LocalDate from,@PathVariable("to") LocalDate to) {
		//TODO
		return service.getAllBetweenDates(from,to);
	}
	
	@GetMapping("/entries/{month}")
	public List<PrescriptionDailyLogEntry> allPrescriptions(@PathVariable("userId") Long userId,@PathVariable("month") String month) {
		//TODO
		throw new RuntimeException("Not Implemented yet!!");
	}
	
}
