package com.P2.CBS.repository;

import com.P2.CBS.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    // Custom queries can be added here

}
