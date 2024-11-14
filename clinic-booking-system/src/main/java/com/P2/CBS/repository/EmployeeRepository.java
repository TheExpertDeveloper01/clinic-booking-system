package com.P2.CBS.repository;

import com.P2.CBS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query to find employees by last name
    List<Employee> findByLastName(String lastName);

    // Find all doctors available on a given date
    @Query("SELECT e FROM e WHERE e.id NOT IN (SELECT a.doctor.id FROM appointment a WHERE a.date = :date)")
    List<Employee> findAvailableDoctorsByDate(@Param("date")LocalDate date);

}