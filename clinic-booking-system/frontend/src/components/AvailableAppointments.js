import React, { useEffect, useState } from 'react'
import axios from 'axios';

function AvailableAppointments(){
    const[appointments, setAppointments] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/appointments/available')
        .then(response => setAppointments(response.data))
        .catch(error => console.error('Error fetching available appointments', error));
    }, []);

    return(
        <div>
            <h2>Available Appointments</h2>
            {appointments.map((appointment, index) => (
                <div key={index}>
                    <p>{appointment.date} at {appointment.time}</p>
                    <button>Book Appointment</button>
                    </div>
            ))}
        </div>
    );
}

export default AvailableAppointments;