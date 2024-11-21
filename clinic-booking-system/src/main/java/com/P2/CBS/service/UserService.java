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

    // Fetch user details by username
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new RuntimeException("User not found");
        }
        return user;
    }

    // Update user information
    public User updateUser(String username, User updatedUser) {
        User existingUser = findByUsername(username);
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
