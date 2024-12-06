import React from 'react';
import { BrowserRouter, Routes } from 'react-router-dom';
//import LoginForm from './components/LoginForm.tsx';
// import RegisterForm from './components/RegisterForm';
import CoolNavbar from './components/CoolNavbar';
import NifftyCarousel from './components/NifftyCarousel';
// import Profile from './components/Profile';
//import AuthProvider from "./provider/authProvider.tsx";

import AuthProvider from "./provider/authProvider";
import { publicRoutes, protectedRoutes } from "./routes/index";

import './App.css';

function App(){

return (
  <BrowserRouter>
  <AuthProvider>
    <CoolNavbar />
    
    <Routes>
      {publicRoutes}
      {protectedRoutes}
    </Routes>
    <NifftyCarousel />
  </AuthProvider>
  </BrowserRouter>
  
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
