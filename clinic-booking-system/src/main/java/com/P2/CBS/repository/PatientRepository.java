package com.P2.CBS.repository;

import com.P2.CBS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    // Custom queries can be added here as needed

}
