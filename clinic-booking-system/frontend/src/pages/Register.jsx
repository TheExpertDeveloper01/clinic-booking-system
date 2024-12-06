import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import { useState } from 'react';


const Register = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const { setToken } = useAuth();
    const naviagte = useNavigate();

    const handleRegister = () => {
        setToken("this is a test token");
        naviagte("/", { replace: true });
    };

    // setTimeout(() => {
    //     handleRegister();

    // }, 3 * 1000);

    return (
        <form onSubmit={handleRegister}>
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
};

export default Register;