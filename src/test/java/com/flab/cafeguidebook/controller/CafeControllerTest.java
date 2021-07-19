package com.flab.cafeguidebook.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CafeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void addCafe() throws Exception {
        CafeDTO cafeDTO = new CafeDTO();
        cafeDTO.setId("testId");
        cafeDTO.setCafeName("테스트카페");
        cafeDTO.setTel("010-1234-5678");

        mockMvc.perform(post("/owner/cafe/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(cafeDTO)))
            .andDo(print())
            .andExpect(status().isOk());
    }
}
