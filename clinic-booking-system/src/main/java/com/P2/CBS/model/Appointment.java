package com.P2.CBS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDate date;

    @NotNull
    @Column(nullable = false)
    private LocalTime time;

    @NotNull
    @Column(nullable = false)
    private String status; // Example: "Scheduled", "Completed", "Cancelled"

    @NotNull
    @Column(name = "patient_name")
    private String patientName;

    @NotNull
    @Column(name = "doctor_name")
    private String doctorName;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Employee doctor;

    // Constructors
    public Appointment() {}

    public Appointment(LocalDate date, LocalTime time, String status, String patientName, String doctorName, Patient patient, Employee doctor) {
        this.date = date;
        this.time = time;
        this.status = status;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.patient = patient;
        this.doctor = doctor;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}

//package com.P2.CBS.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//@Entity
//@Table(name = "appointment")
//public class Appointment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
//    private Long id;
//
//    @NotNull
//    @Column(nullable = false)
//    private LocalDate date;
//
//    @NotNull
//    @Column(nullable = false)
//    private LocalTime time;
//
//    @NotNull
//    @Column(nullable = false)
//    private String status; // Example: "Scheduled", "Completed", "Cancelled"
//
//    @NotNull
//    @Column(nullable = false)
//    private String patientName;
//
//    @NotNull
//    @Column(nullable = false)
//    private String doctorName;
//
//    @NotNull
//    @Column(nullable=false)
//    private Patient patient;
//
//    @NotNull
//    @Column(nullable=false)
//    private Employee doctor;
//    // Can have a many-to-one relationship with Patients and Doctors entities, depending on the scope.
//
//    public Appointment(LocalDate date, LocalTime time, String status, String patientName, String doctorName){
//        this.date = date;
//        this.time = time;
//        this.status = status;
//        this.patientName = patientName;
//        this.doctorName = doctorName;
//    }
//
//    // Getters and Setters
//    public Long getId(){
//        return id;
//    }
//
//    public void setId(Long id){
//        this.id = id;
//    }
//
//    public LocalDate getDate(){
//        return date;
//    }
//
//    public void setDate(LocalDate date){
//        this.date = date;
//    }
//
//    public LocalTime getTime(){
//        return time;
//    }
//
//    public void setTime(LocalTime time){
//        this.time = time;
//    }
//
//    public String getStatus(){
//        return status;
//    }
//
//    public void setStatus(String status){
//        this.status = status;
//    }
//
//    public String getPatientName(){
//        return patientName;
//    }
//
//    public void setPatientName(String patientName){
//        this.patientName = patientName;
//    }
//
//    public String getDoctorName(){
//        return doctorName;
//    }
//
//    public void setDoctorName(String doctorName){
//        this.doctorName = doctorName;
//    }
//
//    @Override
//    public String toString(){
//        return "Appointment{" +
//                "id=" +
//                ", date=" + date +
//                ", time=" + time +
//                ", status=" + status + '\'' +
//                ", patientName=" + patientName + '\'' +
//                ", doctorName=" + doctorName + '\'' +
//                '}';
//    }
//



























