package com.P2.CBS.service;

import com.P2.CBS.model.Patient;
import com.P2.CBS.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
