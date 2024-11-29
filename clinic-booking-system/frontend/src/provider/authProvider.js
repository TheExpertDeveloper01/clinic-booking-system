import axios from 'axios';
import { createContext, useContext, useMemo, useState } from 'react';
import { useEffect } from 'react';

const AuthContext = createContext();

// const AuthProvider = ({ children }) => {
//     // State to hold the authentication token
//     const [token, setToken_] = useState(localStorage.getItem("token"));

//     // Function to set the new authentication token
//     const setToken = (newToken) => {
//         setToken_(newToken);
//     };

const AuthProvider = ({ children }) => {
    // Initialise token from localstorage on first load
    const [token, setToken_] = useState(() => {
        return localStorage.getItem("token") || null;
    });

    // Function to set the new authentication token
    const setToken = (newToken) => {
        if (newToken) {
            localStorage.setItem('token', newToken);
            setToken_(newToken);
        } else {
            localStorage.removeItem('token');
            setToken_(null);
        }
    };


    useEffect(()=> {
        if (token) {
            // Debug
            console.log("Setting default Authorization header:", token);
            axios.defaults.headers.common["Authorization"] = "Bearer " + token;
            
        } else {
            delete axios.defaults.headers.common["Authorization"];
            
        }
    }, [token]);


    // Memoised value of the authentication context
    const contextValue = useMemo(
        () => ({
            token,
            setToken,
        }),
        [token]
    );

    // Provide the authentication context to the children components
    return (
        <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
    );
};

export const useAuth = () => {
    return useContext(AuthContext);
};

export default AuthProvider;
