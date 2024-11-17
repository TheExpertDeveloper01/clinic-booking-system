import React, { useState } from 'react';
import axios from 'axios';

function LoginForm(){

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    
    const handleSubmit = async (e) =>{

        e.preventDefault();
        try{
            const response = await axios.post('http://localhost:8080/api/auth/login', {
                username,
                password,
            });

            // Handle successful login
            console.log(response.data);
        } catch(error){
            // Error handling
            console.error('Error loggin in!', error);
        }

    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Login</h2>
            <label>
                Username: <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />

            </label>
            <label>
                Password: <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                
            </label>
            <button type="submit">Login</button>


        </form>
    );
}

export default LoginForm;