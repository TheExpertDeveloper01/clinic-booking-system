import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import RegisterForm from './components/RegisterForm';
import CoolNavbar from './components/CoolNavbar';
import NifftyCarousel from './components/NifftyCarousel';
import Profile from './components/Profile';
import AuthProvider from "./provider/authProvider";



import './App.css';

function App() {
  return (
   
<Router>
<div className="App">
  <CoolNavbar />


<AuthProvider>
  <Routes>
  <Route path="/" element={<h2>Welcome to the Clinic Booking System!</h2>}/>  
  <Route path="/login" element={<LoginForm />}/>
  <Route path="/register" element={<RegisterForm />}/>
  <Route path="/profile" element={<Profile />} />
  </Routes>
</AuthProvider>

</div>
<div>

  
</div>
{/* <NifftyCarousel/> */}
</Router>


  );
}

export default App;
