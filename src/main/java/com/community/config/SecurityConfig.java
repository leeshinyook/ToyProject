//package com.community.config;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@Configuration
//@EnableWebMvc
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // static 디렉터리의 하위 파일 목록은 인증 무시 (=항상통과)
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//    }
//
//
//}
