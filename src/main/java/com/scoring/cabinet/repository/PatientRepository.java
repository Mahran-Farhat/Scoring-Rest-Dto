package com.scoring.cabinet.repository;

import com.scoring.cabinet.model.Doctor;
import com.scoring.cabinet.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
