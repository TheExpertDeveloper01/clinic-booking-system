import React, { useState } from 'react';
import axios from 'axios';

import { useNavigate } from 'react-router-dom';

function RegisterForm(){
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try{
            const response = await axios.post('http://localhost:8080/auth/register', {
                firstName,
                lastName,
                email,
                password,
            }, {
                headers: {
                    'Content-Type': 'application/json',
                }
            });

            // Handle successful regsitration
            console.log(response.data);
            localStorage.setItem('token', response.data.token); // storing the jwt token
            navigate('/login')
        } catch (error) {
            // Error handling
            console.error('Error registering!', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Register</h2>
            <label>
                First Name:
                <input type="text" value={firstName} onChange={(e) => setFirstName(e.target.value)}/>
                
            </label>
            <label>
                last Name:
                <input type="text" value={lastName} onChange={(e) => setLastName(e.target.value)}/>
                
            </label>
            <label>
                Email:
                <input type="email" value={email} onChange={(e) => setEmail(e.target.value)}/>
                
            </label>
            <label>
                Password:
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                
            </label>
            
            <button type="submit">Register</button>


        </form>
    );
}

export default RegisterForm;