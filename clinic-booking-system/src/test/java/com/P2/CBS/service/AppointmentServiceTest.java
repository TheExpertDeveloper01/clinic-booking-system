package com.P2.CBS.service;

import com.P2.CBS.model.Appointment;
import com.P2.CBS.model.Employee;
import com.P2.CBS.model.Patient;
import com.P2.CBS.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PatientService patientService;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    void testGetAllAppointments() {
        List<Appointment> mockAppointments = new ArrayList<>();

        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");

        Employee doctor = new Employee();
        doctor.setFirstName("Dr.");
        doctor.setLastName("Smith");

        mockAppointments.add(new Appointment(LocalDate.now(), LocalTime.of(10, 0), "Scheduled", patient, doctor));

        when(appointmentRepository.findAll()).thenReturn(mockAppointments);

        List<Appointment> result = appointmentService.getAllAppointments();
        assertEquals(1, result.size());
    }
}
