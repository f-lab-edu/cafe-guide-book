package com.flab.cafeguidebook.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.Fixture.CafeFixture;
import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.service.CafeService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CafeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CafeService cafeService;

    private static CafeFixture cafeFixture;

    @BeforeAll
    public static void setUp() {
        cafeFixture = new CafeFixture();
    }

    @AfterAll
    public static void tearDown() {
        cafeFixture = null;
    }

    @Test
    public void addCafe() throws Exception {
        CafeDTO cafeDTO = cafeFixture.getCafeFixture1();

        given(cafeService.addCafe(cafeDTO)).willReturn(true);

        mockMvc.perform(post("/owner/cafe/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(cafeDTO))
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value(cafeDTO.getUserId()))
            .andExpect(jsonPath("cafeId").value(cafeDTO.getCafeId()))
            .andExpect(jsonPath("cafeName").value(cafeDTO.getCafeName()))
            .andExpect(jsonPath("tel").value(cafeDTO.getTel()));
    }
}

