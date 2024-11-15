package com.P2.CBS.controller;

import com.P2.CBS.model.Appointment;
import com.P2.CBS.service.AppointmentService;
import com.P2.CBS.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // Disable security filters for testing
@TestPropertySource(properties = {
        "jwt.secret=dGhpcy1pcy1hLXZlcnktc2VjdXJlLWFuZC1sb25nLXNlY3JldC1rZXktZm9yLWp3dA==",
        "jwt.expiration=36000000"
})
public class AppointmentControllerTest {

    @MockBean
    private AppointmentService appointmentService;

    @MockBean
    private JwtUtil jwtUtil; // Mock JwtUtil to avoid initialization issues

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAllAppointments() throws Exception {
        Appointment appointment = new Appointment(LocalDate.of(2024, 11, 20), LocalTime.of(10, 0), "Scheduled", "John Doe", "Dr. Smith", null, null);
        given(appointmentService.getAllAppointments()).willReturn(Collections.singletonList(appointment));

        mockMvc.perform(get("/appointments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].status").value("Scheduled"));
    }

    @Test
    public void shouldCreateNewAppointment() throws Exception {
        String appointmentJson = "{\"date\": \"2024-11-20\", \"time\": \"10:00\", \"status\": \"Scheduled\"}";

        // Mock the service call for appointment creation
        given(appointmentService.createAppointment(any(Appointment.class)))
                .willReturn(new Appointment(LocalDate.of(2024, 11, 20), LocalTime.of(10, 0), "Scheduled", "John Doe", "Dr. Smith", null, null));

        mockMvc.perform(post("/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(appointmentJson))
                .andExpect(status().isOk());
    }
}

