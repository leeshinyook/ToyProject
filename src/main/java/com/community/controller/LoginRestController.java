package com.community.controller;

import com.community.domain.User;
import com.community.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


// Login API
@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    private UserRepository userRepository;

    public LoginRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> checkUser(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        User findUser = userRepository.findByEmailAndPassword(email,password);
        if(findUser != null) {
            return new ResponseEntity<>("{}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }
    }

}
