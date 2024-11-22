import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function StaffLoginForm(){
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try{
            const response = await.axios.post('http://localhost:8080/auth/login', {
                email,
                password,
            });

            // Handle successful login
            console.log(response.data);
            localStorage.setItem('token', response.data.token); // Storing JWT token
            navigate('/staff/dashboard'); // Redirect to staff specific dashboard or Profile page


        } catch (error){
            console.error('Error logging in!', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Staff Login</h2>
            <label>
                Email: <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
            </label>
            <label>
                Password: <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </label>
            <button type ="submit">Login</button>


        </form>
    );
}

export default StaffLoginForm;