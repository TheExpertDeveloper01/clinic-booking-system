package com.P2.CBS.service;

import com.P2.CBS.model.Appointment;
import com.P2.CBS.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment){
        // Business logic to avoid overlapping appointments
        List<Appointment> existingAppointments = appointmentRepository.findAppointmentsByDoctorAndDate(appointment.getDoctor().getId(), appointment.getDate());
        if (existingAppointments.stream().anyMatch(a.getTime().equals(appointment.getTime()))){
            throw new IllegalArgumentException("The doctor is not available at this time");

        }
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
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


