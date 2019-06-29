package com.rxtracker.prescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rxtracker.prescription.data.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
