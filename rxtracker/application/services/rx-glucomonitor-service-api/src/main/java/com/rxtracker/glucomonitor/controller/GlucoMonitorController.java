package com.rxtracker.glucomonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;
import com.rxtracker.glucomonitor.service.GlucoMonitorEntryService;

@RestController
@RequestMapping("/api/users/{userId}/glucomonitor/entries")
public class GlucoMonitorController {

	@Autowired
	GlucoMonitorEntryService service;
	
	@PostMapping
	public Long addEntry(GlucoMonitorEntryVO entry) {
		return service.addEntry(entry);
	}
	
	
	@DeleteMapping("/{id}")
	public Long deleteEntry(@PathVariable Long userId,@PathVariable Long id) {
		return service.deleteEntry(id);
	}
	
	@PutMapping("/{id}")
	public Long updateEntry(@PathVariable Long userId,@PathVariable Long id,GlucoMonitorEntryVO entry) {
		entry.setEntryId(id);
		return service.modifyEntry(entry);
	}
	
	@GetMapping("/{id}")
	public GlucoMonitorEntryVO getEntry(@PathVariable Long userId,@PathVariable Long id) {
		return service.getEntry(id);
	}
	
	@GetMapping
	public List<GlucoMonitorEntryVO> getAllEntries(@PathVariable Long userId) {
		return service.getEntries(userId);
	}
}
