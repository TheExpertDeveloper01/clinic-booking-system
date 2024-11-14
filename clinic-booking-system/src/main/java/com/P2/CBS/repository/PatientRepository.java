package com.P2.CBS.repository;

import com.P2.CBS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    // Find a patient by email
    Optional<Patient> findByEmail(String email);


}
