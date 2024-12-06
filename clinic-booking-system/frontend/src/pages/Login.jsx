import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import React, { useEffect, useState, FormEvent } from 'react';


const Login = () => {
    // const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const { setToken } = useAuth();
    const navigate = useNavigate();

    const handleLogin = (e: FormEvent) => {
        e.preventDefault(); // Prevent page refresh


        // Simulate login and set token
        setToken("this is a test token");
        navigate("/", { replace: true });
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