import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav, Container } from 'react-bootstrap';

function CoolNavbar(){
    return(
    <Navbar bg="dark" variant="dark" expand="lg">
        <Container>
            <Navbar.Brand as={Link} to="/">Clinic Booking System</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
                <Nav.Link as={Link} to="/">Home</Nav.Link>
                <Nav.Link as={Link} to="/login">Patient Login</Nav.Link>
                <Nav.Link as={Link} to="/register">Patient Register</Nav.Link>
                <Nav.Link as={Link} to="/staff/login">Staff Login</Nav.Link>



            </Nav>

            </Navbar.Collapse>


        </Container>
    </Navbar>
    );
}

export default CoolNavbar;