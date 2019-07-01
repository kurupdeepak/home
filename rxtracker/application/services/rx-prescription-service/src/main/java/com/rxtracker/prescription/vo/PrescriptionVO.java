package com.rxtracker.prescription.vo;

import java.time.LocalDateTime;

public class PrescriptionVO {

	private Long prescriptionId;
	
	private String rxName;
	
	private int rxPrescribedUnit;
	
	private String rxUnitType;
	
	private String prescribedBy;
	
	private LocalDateTime dateOfPurchase;
	
	private boolean active;

	private Long userId;
	
	private String rxUsageInterval;
	
	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getRxName() {
		return rxName;
	}

	public void setRxName(String rxName) {
		this.rxName = rxName;
	}

	public int getRxPrescribedUnit() {
		return rxPrescribedUnit;
	}

	public void setRxPrescribedUnit(int i) {
		this.rxPrescribedUnit = i;
	}

	public String getRxUnitType() {
		return rxUnitType;
	}

	public void setRxUnitType(String rxUnitType) {
		this.rxUnitType = rxUnitType;
	}

	public String getPrescribedBy() {
		return prescribedBy;
	}

	public void setPrescribedBy(String prescribedBy) {
		this.prescribedBy = prescribedBy;
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRxUsageInterval() {
		return rxUsageInterval;
	}

	public void setRxUsageInterval(String rxUsageIntervals) {
		this.rxUsageInterval = rxUsageIntervals;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", rxName=" + rxName + ", rxPrescribedUnit="
				+ rxPrescribedUnit + ", rxUnitType=" + rxUnitType + ", prescribedBy=" + prescribedBy + ", rxUsageTimes="
				+ rxUsageInterval + ", dateOfPurchase=" + dateOfPurchase + ", active=" + active + ", userId=" + userId
				+ "]";
	}
	
}
