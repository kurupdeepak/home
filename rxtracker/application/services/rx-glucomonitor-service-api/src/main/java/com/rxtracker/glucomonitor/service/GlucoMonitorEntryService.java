package com.rxtracker.glucomonitor.service;

import java.util.List;

import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;

public interface GlucoMonitorEntryService {
	Long addEntry(GlucoMonitorEntryVO entry) throws GlucoMonitorServiceFailureException;
	Long deleteEntry(Long id) throws GlucoMonitorServiceFailureException;
	Long modifyEntry(GlucoMonitorEntryVO entry) throws GlucoMonitorServiceFailureException;
	GlucoMonitorEntryVO getEntry(Long id) throws GlucoMonitorServiceFailureException;
	List<GlucoMonitorEntryVO> getEntries(Long userId);
}
