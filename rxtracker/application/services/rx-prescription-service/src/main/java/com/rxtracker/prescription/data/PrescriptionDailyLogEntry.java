package com.rxtracker.prescription.data;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PrescriptionDailyLogEntry {
	@Id
	@GeneratedValue
	private Long usageId;
	
	private Long prescriptionId;
	
	private Double unitsTaken;
	
	private LocalDateTime usageTime;

	public Long getUsageId() {
		return usageId;
	}

	public void setUsageId(Long usageId) {
		this.usageId = usageId;
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Double getUnitsTaken() {
		return unitsTaken;
	}

	public void setUnitsTaken(Double unitsTaken) {
		this.unitsTaken = unitsTaken;
	}

	public LocalDateTime getUsageTime() {
		return usageTime;
	}

	public void setUsageTime(LocalDateTime usageTime) {
		this.usageTime = usageTime;
	}
	
	
}
