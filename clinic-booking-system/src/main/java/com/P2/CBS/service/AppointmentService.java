package com.P2.CBS.service;

import com.P2.CBS.dto.AppointmentDTO;
import com.P2.CBS.model.Appointment;
import com.P2.CBS.model.Employee;
import com.P2.CBS.model.Patient;
import com.P2.CBS.repository.AppointmentRepository;
import com.P2.CBS.service.PatientService;
import com.P2.CBS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final EmployeeService employeeService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService, EmployeeService employeeService){
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.employeeService = employeeService;
    }

    public List<Appointment> getAvailableAppointments(){
        return appointmentRepository.findAll()
                .stream()
                .filter(appointment -> "AVAILABLE".equalsIgnoreCase(appointment.getStatus()))
                .toList();
    }

    public Appointment bookAppointment(Long appointmentId, Long patientId){
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found >:p"));
        Patient patient = patientService.getPatientById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found :o"));
        
        if (!"AVAILABLE".equalsIgnoreCase(appointment.getStatus())){
            throw new IllegalArgumentException("Appointment is not available. Aw shucks");
        }

        appointment.setStatus("BOOKED");
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }


    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(AppointmentDTO appointmentDTO){
        // Fetch patient and doctor based on IDs from the DTO
        Patient patient = patientService.getPatientById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Employee doctor = employeeService.getEmployeeById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        // Business logic to avoid overlapping appointments
        List<Appointment> existingAppointments = appointmentRepository.findAppointmentsByDoctorAndDate(doctor.getId(), appointmentDTO.getDate());
        if (existingAppointments.stream().anyMatch(a -> a.getTime().equals(appointmentDTO.getTime()))){
            throw new IllegalArgumentException("The doctor is not available at this time");
        }

        // Create the Appointment object
        Appointment appointment = new Appointment(
                appointmentDTO.getDate(),
                appointmentDTO.getTime(),
                appointmentDTO.getStatus(),
                patient,
                doctor
        );

        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO){
        // Fetch patient and doctor based on IDs from the DTO
        Patient patient = patientService.getPatientById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Employee doctor = employeeService.getEmployeeById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        // Get the existing appointment
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        // Update the fields
        existingAppointment.setDate(appointmentDTO.getDate());
        existingAppointment.setTime(appointmentDTO.getTime());
        existingAppointment.setStatus(appointmentDTO.getStatus());
        existingAppointment.setPatient(patient);
        existingAppointment.setDoctor(doctor);

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId){
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId){
        return appointmentRepository.findByPatientId(patientId);
    }
}


