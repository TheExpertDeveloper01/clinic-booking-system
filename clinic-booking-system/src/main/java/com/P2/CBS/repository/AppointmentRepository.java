package com.P2.CBS.repository;

import com.P2.CBS.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

// Find appointments by doctor ID
    List<Appointment> findByDoctorId(Long doctorId);

    // Find appointments for patient by patient Id
    List<Appointment> findByPatientId(Long patientId);

    // Find appointments by doctor and date
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.date = :date")
    List<Appointment> findAppointmentsByDoctorAndDate(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);

}
