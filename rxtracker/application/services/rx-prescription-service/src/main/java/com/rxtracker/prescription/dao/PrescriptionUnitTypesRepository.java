package com.rxtracker.prescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rxtracker.prescription.data.UnitType;

public interface PrescriptionUnitTypesRepository extends JpaRepository<UnitType, Long> {

}
