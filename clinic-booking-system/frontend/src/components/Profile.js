import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Profile() {
    const [user, setUser] = useState({
        firstName: '',
        lastName: '',
        email: '',
        patientId: ''
    });

    const [editMode, setEditMode] = useState(false);


    useEffect(() => {

        // Fetch user data on component mount
        const fetchUserData = async () => {

            let token = localStorage.getItem('token');

            // Retry mechanism if token is not immediately available
            if (!token){
                console.error('Token not available. Retying in 100ms...');
                setTimeout(fetchUserData, 100);
                return;
            }

            // Token validation check
            if (!token.includes('.') || token.split('.').length !== 3){
                console.error('Invalid token format:', token);
                return;
            }

            console.log('Using token:', token); // Add log to verify token

            try {
                // const token = localStorage.getItem('token');
                // console.log('Using token:', token); // Add log to verify token
                const response = await axios.get('http://localhost:8080/users/profile', {
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization':`Bearer ${token}`,

                    },
                });
                setUser(response.data);
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };
        fetchUserData();

    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUser({ ...user, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const token = localStorage.getItem('token');
            console.log('Using token:', token); // Add log to verify token

            const response = await axios.put('http://localhost:8080/users/profile', user, {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization':`Bearer ${token}`,
                },
            });
            console.log("User data updated successfully: ", response.data);
            setEditMode(false);

        } catch (error) {
            console.error('Error updating user data:', error);
        }
    };

    return(
        <div className="profile-container">
            <h2>Profile Information</h2>
            {!editMode ? (

                <div>
                    <p><strong>Patient Id:</strong> {user.patientId}</p>
                    <p><strong>First Name:</strong> {user.firstName}</p>
                    <p><strong>lastName:</strong> {user.lastName}</p>
                    <p><strong>email:</strong> {user.email}</p>
                    <button onClick={() => setEditMode(true)}>Edit Profile</button>
                </div>
                
            ) : (

                <form onSubmit={handleSubmit}>
                    <label>
                        First Name:
                        <input
                        type="text"
                        name="firstName"
                        value={user.firstName}
                        onChange={handleChange}
                        />
                    </label>
                    <label>
                        Last Name:
                        <input
                        type="text"
                        name="lastName"
                        value={user.lastName}
                        onChange={handleChange}
                        />
                    </label>
                    <label>
                        Email:
                        <input
                        type="email"
                        name="email"
                        value={user.email}
                        onChange={handleChange}
                        />
                    </label>
                    <button type="submit">Save</button>
                    <button onClick={() => setEditMode(false)}>Cancel</button>



                </form>



            )}
        </div>
    );


}

export default Profile;