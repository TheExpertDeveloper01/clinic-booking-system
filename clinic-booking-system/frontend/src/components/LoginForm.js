import React, { useState } from 'react';
import axios from 'axios';

import { useNavigate } from 'react-router-dom';

function LoginForm(){

    // const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');

    const [password, setPassword] = useState('');

    const navigate = useNavigate(); // Hook to handle navigation
    
    const handleSubmit = async (e) =>{


        

        e.preventDefault();
        try{
            const response = await axios.post('http://localhost:8080/auth/login', {
                username,
                password,
            }, {
                headers: {
                    'Content-Type': 'application/json',
                    
                }
            });
            // START OF WORKING CODE
            // Handle successful login
            console.log(response.data);

            
            // localStorage.setItem('token', response.data.token); // Store JWT token

            const { jwt } = response.data; // Extract JWT token
            localStorage.setItem('token', jwt); // Store JWT token



            // navigate('/profile'); // Redirect to profile page

            // Adding a slight delay to ensure token is stored before redirecting
            setTimeout(() => {
                navigate('/profile'); 
            }, 200);
            // END OF WORKING CODE

            
            
            


        } catch(error){
            // Error handling
            console.error('Error loggin in!', error);
        }

    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Login</h2>
            <label>
                Email: <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />

            </label>
            <label>
                Password: <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                
            </label>
            <button type="submit">Login</button>


        </form>
    );
}

export default LoginForm;