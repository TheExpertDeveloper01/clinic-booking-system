import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import RegisterForm from './components/RegsiterForm';

import './App.css';

function App() {
  return (
   
<Router>
<div className="App">
  <Routes>
  <Route path="/login element={<LoginForm />}"/>
  <Route path="/register element={<RegisterForm />}"/>
  </Routes>


</div>

</Router>

  );
}

export default App;
