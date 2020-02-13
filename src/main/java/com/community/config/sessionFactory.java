package com.community.config;

import com.community.domain.User;
import com.community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//세션을 구성하는 클래스
@Component
public class sessionFactory {

    private UserRepository userRepository;

    public sessionFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void setSession(HttpServletRequest request, String email) {
        User user = userRepository.findByEmail(email);
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("name", user.getName());
    }

}
