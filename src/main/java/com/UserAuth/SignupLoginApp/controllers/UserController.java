package com.UserAuth.SignupLoginApp.controllers;

import com.UserAuth.SignupLoginApp.models.User;
import com.UserAuth.SignupLoginApp.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

//    @PostMapping("/signup")
//    public User addUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Logic for signup
        return ResponseEntity.ok("Signup successful!");
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if(foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "Login Successfull..!";
        } else {
            return "User not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User is Deleted";
    }
}
