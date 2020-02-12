package com.community;

import com.community.domain.User;
import com.community.domain.enums.UserType;
import com.community.repository.UserRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserApiTest {
    private final String email = "test@gmail.com";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void POST_USER() throws Exception {
        User user = User.builder()
                .name("ha")
                .password("test")
                .email(email)
                .userType(UserType.admin)
                .createdDate(LocalDateTime.now())
                .build();

        mockMvc.perform(post("/api/users")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaTypes.HAL_JSON_UTF8)
                    .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void GET_USER() throws Exception {
        mockMvc.perform(get("/api/users")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void GET_ONE_USER() throws Exception {
        mockMvc.perform(get("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
