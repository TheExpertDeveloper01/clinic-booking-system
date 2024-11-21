import React, { useEffect, useState } from 'react'
import axios from 'axios';

function MyAppointments()  {
    const [appointments, setAppointments] = useState([]);

    useEffect(() =>{
        axios.get('http://localhost:8080/api/appointments/myappointments', {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then(response => setAppointments(response.data))
        .catch(error => console.error('Error fetching appointments', error));
    }, []);

    return (
        <div>
        <h2>My Appointments</h2>
        {appointments.map((appointment, index) => (
            <div key={index}>
                <p>{appointment.date} at {appointment.time}</p>
                </div>
        ))}
        
        </div>
    );
}

export default MyAppointments;