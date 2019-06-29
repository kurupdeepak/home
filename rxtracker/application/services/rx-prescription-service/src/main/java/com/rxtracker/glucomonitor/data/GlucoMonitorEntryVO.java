package com.rxtracker.glucomonitor.data;

import java.time.LocalDateTime;

public class GlucoMonitorEntryVO {

	private Long entryId;
	
	private Long userId;
	
	private Float levelEntered;
	
	private String notes;
	
	private LocalDateTime levelEntryTime;

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Float getLevelEntered() {
		return levelEntered;
	}

	public void setLevelEntered(Float levelEntered) {
		this.levelEntered = levelEntered;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getLevelEntryTime() {
		return levelEntryTime;
	}

	public void setLevelEntryTime(LocalDateTime levelEntryTime) {
		this.levelEntryTime = levelEntryTime;
	}

	@Override
	public String toString() {
		return "GlucoMonitorEntry [entryId=" + entryId + ", userId=" + userId + ", levelEntered=" + levelEntered
				+ ", notes=" + notes + ", levelEntryTime=" + levelEntryTime + "]";
	}
	
	
	
}
