package com.community;


import com.community.domain.Board;
import com.community.domain.User;
import com.community.domain.enums.BoardType;
import com.community.domain.enums.UserType;
import com.community.repository.BoardRepository;
import com.community.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Local;
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

import java.rmi.server.ExportException;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BoardApiTest {

    public static User user;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;



    @Test
    public void POST_BOARD() throws Exception {
        Board board = Board.builder()
                    .title("Test")
                    .subTitle("subtitle")
                    .content("test")
                    .boardType(BoardType.free)
                    .createdDate(LocalDateTime.now())
                    .build();
        mockMvc.perform(post("/api/boards")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON_UTF8)
                .content(objectMapper.writeValueAsString(board)))
            .andDo(print())
            .andExpect(status().isCreated());
    }
    @Test
    public void GET_BOARD() throws Exception {
        mockMvc.perform(get("/api/boards")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void GET_ONE_BOARD() throws Exception {
        mockMvc.perform(get("/api/boards/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void DELETE_BOARD() throws Exception {
        mockMvc.perform(delete("/api/boards/1")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
