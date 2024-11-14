package com.P2.CBS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // This corresponds to src/main/resources/templates/index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // This corresponds to src/main/resources/templates/login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register";  // This corresponds to src/main/resources/templates/register.html
    }
}


//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
//    @GetMapping("/")
//    public String home() {
//        return "Welcome to the Clinic Booking System!";
//    }
//}
