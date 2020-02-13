package com.community;


import com.community.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class LoginApiTest {
    private final String email = "testEmail";
    private final String password = "testPassword";
    private static User user;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void init() throws Exception {
        user = User.builder()
                .email(email)
                .password(password)
                .build();
        mockMvc.perform(post("/api/users")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(user)));

    }

    @Test
    public void LOGIN_SUCCESS_TEST()throws Exception {
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void LOGIN_FAILURE_TEST() throws Exception {
        User failUser = User.builder()
                .email("")
                .password("")
                .build();
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON_UTF8)
                .content(objectMapper.writeValueAsString(failUser)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
