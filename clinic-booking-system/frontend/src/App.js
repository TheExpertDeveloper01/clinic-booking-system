import React from 'react';
//import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
//import LoginForm from './components/LoginForm.tsx';
import RegisterForm from './components/RegisterForm';
//import CoolNavbar from './components/CoolNavbar';
import NifftyCarousel from './components/NifftyCarousel';
import Profile from './components/Profile';
//import AuthProvider from "./provider/authProvider.tsx";

import AuthProvider from "./provider/authProvider";
import Routes from "./routes";



import './App.css';

function App(){

return (
  <div>
    <NifftyCarousel />
    <AuthProvider>
  <Routes />
  
</AuthProvider></div>
  
  
);
}

export default App;


// function App() {
//   return (
//     <AuthProvider>
// <Router>
// <div className="App">
//   <CoolNavbar />



//   <Routes>
//   <Route path="/" element={<h2>Welcome to the Clinic Booking System!</h2>}/>  
//   <Route path="/login" element={<LoginForm />}/>
//   <Route path="/register" element={<RegisterForm />}/>
//   <Route path="/profile" element={<Profile />} />
//   </Routes>


// </div>
// <div>

  
// </div>
// 
// </Router>
// </AuthProvider>

//   );
// }

// export default App;
