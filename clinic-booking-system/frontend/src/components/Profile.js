import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Profile() {
    const [user, setUser] = useState({
        firstName: '',
        lastName: '',
        email: '',
    });

    const [editMode, setEditMode] = useState(false);


    useEffect(() => {

        // Fetch user data on component mount
        const fetchUserData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/users/profile', {
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem('token')}`,

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
            await axios.put('http://localhost:8080/api/users/profile', user, {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`,
                },
            });
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