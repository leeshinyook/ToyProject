package com.community.controller;


import com.community.config.CustomAuthenticationProvider;
import com.community.config.sessionFactory;
import com.community.domain.User;
import com.community.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/signUp")
public class SecurityLoginRestController {

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    private UserRepository userRepository;

    public SecurityLoginRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody User user, HttpServletRequest request) {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        user.setPassword(pe.encode(user.getPassword()));

        // 기존에 가입된 회원인지 확인
        User searchUser = userRepository.findByEmail(user.getEmail());
        if(searchUser == null) {
            userRepository.save(user);
        }

        // 로그인 처리 진행
        // 세션 처리
        sessionFactory.setSession(request, user.getEmail());
        //Auth 처리




    }

}
