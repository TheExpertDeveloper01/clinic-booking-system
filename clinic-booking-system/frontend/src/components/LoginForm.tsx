import React, { useState, FormEvent } from 'react';
import axios from 'axios';
import { useAuth } from "../provider/authProvider";
import { useNavigate } from 'react-router-dom';

const LoginForm: React.FC = () => {
    const [username, setUsername] = useState<string>('');
    const [password, setPassword] = useState<string>('');

    const navigate = useNavigate(); // Hook to handle navigation

    // Destructive setToken from useAuth to update the token
    const { setToken } = useAuth();

    const handleSubmit = async (e: FormEvent) => {
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

            const { jwt } = response.data; // Extract jwt token

            if (typeof jwt === 'string' && jwt) {
                setToken(jwt);
                console.log("Token set:", jwt); //debug
                navigate('/profile');
            } else {
                console.error("JWT token is undefined or not a string. Check backend response");
            }
        } catch (error) {
            console.error('Error logging in!', error);
            if (error.response){
                console.error('Error details', error.response.data);
            }
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Login</h2>
            <label>
                Username: <input type="text" value={username} onChange={(e) => setUsername(e.target.value)}/>
            </label>
            <label>
                Password: <input type="password" value={password} onChange={(e) => setPassword(e.target.value)}/>
            </label>
            <button type="submit">Login</button>
        </form>
    );

};

export default LoginForm;


// function LoginForm(){

//     // const [email, setEmail] = useState('');
//     const [username, setUsername] = useState('');

//     const [password, setPassword] = useState('');

//     const navigate = useNavigate(); // Hook to handle navigation

//     // Destructure setToken from useAuth to update the token
//     const { setToken } = useAuth();
    



    
//     const handleSubmit = async (e) =>{


        

//         e.preventDefault();
//         try{
//             const response = await axios.post('http://localhost:8080/auth/login', {
//                 username,
//                 password,
//             }, {
//                 headers: {
//                     'Content-Type': 'application/json',
                    
//                 }
//             });
//             console.log("Full response:", response); // Debug the full response

//             console.log("Response data:", response.data); // Debugging the response data

//             // Debugging step to log the received token
//             console.log("Received JWT token:", response.data.jwt);

//             // localStorage.setItem('token', response.data.token); // Store JWT token

//             const { jwt } = response.data; // Extract JWT token
            
//             // Debugging
//             if (jwt) {
//                 // Using the setToken method from AuthProvider
                
//                 setToken(jwt);
//                 console.log("Token set:", jwt); // Debug
                
//                 // Adding a slight delay to ensure token is stored before redirecting
//                 setTimeout(() => {
//                 navigate('/profile'); 
//             }, 200);
//             }else {

//                 console.error("JWT token is undefined or empty. Check backend response.");

//             }
            




//             // navigate('/profile'); // Redirect to profile page

            
//             // END OF WORKING CODE

            
            
            


//         } catch(error){
//             // Error handling
//             console.error('Error loggin in!', error);
//             if (error.response) {
//                 console.error('Error details:', error.response.data);
//             }
//         }

//     };

//     return (
//         <form onSubmit={handleSubmit}>
//             <h2>Login</h2>
//             <label>
//                 Email: <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />

//             </label>
//             <label>
//                 Password: <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                
//             </label>
//             <button type="submit">Login</button>


//         </form>
//     );
// }

// export default LoginForm;