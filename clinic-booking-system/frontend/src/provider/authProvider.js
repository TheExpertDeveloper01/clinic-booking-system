import axios from "axios";
import { 
    createContext,
    useContext,
    useEffect,
    useMemo,
    useState,
} from "react";

// This will create an empty context object that will share the authentication state and functions betweeen components
const AuthContext = createContext();

// Following component serves as the provider for the authentication context
// Receives children as a prop, which represents the child components that will have access to the authentication context.
const AuthProvider = ({ children }) => {
    
    // The token represents the authentication token
    // it retrieves the token value from the local storage if it exists
    const [token, setToken_] = useState(localStorage.getItem("token"));

    // Update the authentication token and stores in the local storage
    const setToken = (newToken) => {
        setToken_(newToken);
    };

    // Set the default authorisation header in axios and store value in local storage
    useEffect(() => {
        if (token) {
            axios.defaults.headers.common["Authorization"] = "Bearer " + token;
            localStorage.setItem('token', token);
        } else {
            delete axios.defaults.headers.common["Authorization"];
            localStorage.removeItem('token')
        }
    }, [token]);

    // Memomised context value
    const contextValue = useMemo(
        () => ({
            token,
            setToken,
        }),
        [token]
    );

    // Provide authentication context to the child component
    return(
        <AuthContext.Provider value ={contextValue}>
            {children}
        </AuthContext.Provider>
    )
};

export const useAuth = () =>  {
    return useContext(AuthContext);
};

export default AuthProvider;


// import axios from 'axios';
// import React, { createContext, useContext, useMemo, useState, useEffect, ReactNode } from 'react';

// interface AuthContextType {
//     token: string | null;
//     setToken: (token: string | null) => void;
// }

// const AuthContext = createContext<AuthContextType | undefined>(undefined);

// interface AuthProviderProps {
//     children: ReactNode;
// }

// const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
//     // Initialise token from localStorage on first loaf
//     const [token, setToken_] = useState<string | null>(() => {
//         return localStorage.getItem("token") || null;
//     });

//     const setToken = (newToken: string | null) => {
//         if (newToken) {
//             localStorage.setItem('token', newToken);
//             setToken_(newToken);
//         } else {
//             localStorage.removeItem('token');
//             setToken_(null);
//         }
//     };

//     useEffect(() => {
//         if (token) {
//             console.log("Setting default Authorization header:", token);
//             axios.defaults.headers.common["Authorization"] = "Bearer " + token;
//         } else{
//             delete axios.defaults.headers.common["Authorization"];
//         }
//     }, [token]);

//     // Memmoised value of the authentication context
//     const contextValue = useMemo(() => ({ token, setToken }), [token]);

//     return (
//         <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
//     );
// };

// export const useAuth = (): AuthContextType => {
//     const context = useContext(AuthContext);
//     if (context === undefined){
//         throw new Error('useAuth must be used within an AuthProvider');
//     }
//     return context;
// };

// export default AuthProvider;



// import axios from 'axios';
// import { createContext, useContext, useMemo, useState } from 'react';
// import { useEffect } from 'react';

// const AuthContext = createContext();

// // const AuthProvider = ({ children }) => {
// //     // State to hold the authentication token
// //     const [token, setToken_] = useState(localStorage.getItem("token"));

// //     // Function to set the new authentication token
// //     const setToken = (newToken) => {
// //         setToken_(newToken);
// //     };

// const AuthProvider = ({ children }) => {
//     // Initialise token from localstorage on first load
//     const [token, setToken_] = useState(() => {
//         return localStorage.getItem("token") || null;
//     });

//     // Function to set the new authentication token
//     const setToken = (newToken) => {
//         if (newToken) {
//             localStorage.setItem('token', newToken);
//             setToken_(newToken);
//         } else {
//             localStorage.removeItem('token');
//             setToken_(null);
//         }
//     };


//     useEffect(()=> {
//         if (token) {
//             // Debug
//             console.log("Setting default Authorization header:", token);
//             axios.defaults.headers.common["Authorization"] = "Bearer " + token;
            
//         } else {
//             delete axios.defaults.headers.common["Authorization"];
            
//         }
//     }, [token]);


//     // Memoised value of the authentication context
//     const contextValue = useMemo(
//         () => ({
//             token,
//             setToken,
//         }),
//         [token]
//     );

//     // Provide the authentication context to the children components
//     return (
//         <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
//     );
// };

// export const useAuth = () => {
//     return useContext(AuthContext);
// };

// export default AuthProvider;
