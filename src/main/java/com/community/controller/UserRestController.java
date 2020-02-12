package com.community.controller;

import com.community.domain.User;
import com.community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user) {
        user.setCreatedDate(LocalDateTime.now());
        userRepository.save(user);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

}
