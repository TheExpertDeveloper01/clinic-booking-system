package com.P2.CBS.service;

import com.P2.CBS.model.User;
import com.P2.CBS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign a unique patientId incrementally
        Long patientId = userRepository.count() + 1; // Ensure the patientId is unique
        user.setPatientId(patientId);

        return userRepository.save(user);
    }

//    public User registerNewUser(User newUser){
//        // Encode password and set user details
//        newUser.setPassword((passwordEncoder.encode(newUser.getPassword())));
//
//        // Assign an auto-generated patientId
//        newUser.setPatientId(getNextPatientId());
//
//        return userRepository.save(newUser);
//    }

    // Generate patientId incrementally
    private Long getNextPatientId(){
        return (long) (userRepository.count() + 1);
    }

    // Fetch user details by email
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new RuntimeException("User not found");
        }
        return user;
    }

    // Update user information
    public User updateUser(String email, User updatedUser) {
        User existingUser = findByEmail(email);
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        return userRepository.save(existingUser);
    }
}

//    public User updateUser(String username, User updatedUser) {
//        Optional<User> existingUserOptional = userRepository.findByUsername(username);
//        if (existingUserOptional.isPresent()){
//            existingUser.setFirstName(updatedUser.getFirstName());
//            existingUser.setLastName(updatedUser.getLastName());
//            existingUser.setEmail(updatedUser.getEmail());
//            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
//                existingUser.setPassword()(passwordEncoder.encode(updatedUser.getPassword()));
//            }
//            return userRepository.save(existingUser);
//
//        } else{
//            throw new RuntimeException("User not found");
//        }
//    }
//}
