package com.P2.CBS.controller;


import com.P2.CBS.model.User;
import com.P2.CBS.dto.AppointmentDTO;
import com.P2.CBS.model.Appointment;
import com.P2.CBS.service.AppointmentService;
import com.P2.CBS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    // GET method to retrieve available appointments
    @GetMapping("/available")
    public ResponseEntity<List<Appointment>> getAvailableAppointments(){
        List<Appointment> appointments = appointmentService.getAvailableAppointments();
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Long appointmentId = appointmentDTO.getAppointmentId();
        Long patientId = appointmentDTO.getPatientId();
        Appointment appointment = appointmentService.bookAppointment(appointmentId, patientId);
        return ResponseEntity.ok(appointment);
    }

    // Get method to retrieve user specific appointments using patientId
    @GetMapping("/myappointments")
    public ResponseEntity<List<Appointment>> getUserAppointments(Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username); // Fetch the user object to get the patientId
        Long patientId = user.getPatientId();
        List<Appointment> userAppointments = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(userAppointments);
    }


    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment createdAppointment = appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok(createdAppointment);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.getAppointmentById(id)
                .map(existingAppointment -> {
                    Appointment updatedAppointment = appointmentService.updateAppointment(id, appointmentDTO);
                    return ResponseEntity.ok(updatedAppointment);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        if (appointmentService.getAppointmentById(id).isPresent()){
            appointmentService.deleteAppointment(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId){
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId){
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}/date/{date}")
    public List<Appointment> getAppointmentsByDoctorAndDate(@PathVariable Long doctorId, @PathVariable LocalDate date){
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

}
