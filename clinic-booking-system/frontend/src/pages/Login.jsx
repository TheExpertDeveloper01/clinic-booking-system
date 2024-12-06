import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import React, { useEffect, useState, FormEvent } from 'react';
import axios from 'axios';


const Login = () => {
    // const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const { setToken } = useAuth();
    const navigate = useNavigate();

    const handleLogin = async(e) => {
        e.preventDefault(); // Prevent page refresh

        try{
            const response = await axios.post('http://localhost:8080/auth/login', {
                email: username,
                password: password
            });

            // Simulate login and set token
        setToken(response.data);
        navigate("/", { replace: true });

        } catch (error) {
            console.error("Login failed:", error);
            alert("Invalid credentials");
        }
        

    };


    return (
        <form onSubmit={handleLogin}>
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
};

export default Login;