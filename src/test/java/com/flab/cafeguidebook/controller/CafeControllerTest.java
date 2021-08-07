package com.flab.cafeguidebook.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.service.CafeService;
import java.util.ArrayList;
import java.util.List;

import com.flab.cafeguidebook.fixture.CafeFixture;
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
            .sessionAttr("userId", cafeDTO.getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(mapper.writeValueAsString(cafeDTO))
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value(cafeDTO.getUserId()))
            .andExpect(jsonPath("cafeId").value(cafeDTO.getCafeId()))
            .andExpect(jsonPath("cafeName").value(cafeDTO.getCafeName()))
            .andExpect(jsonPath("tel").value(cafeDTO.getTel()));
    }

    @Test
    public void getMyAllCafe() throws Exception {
        List<CafeDTO> myAllCafe = new ArrayList<>();

        CafeDTO cafeDTO1 = cafeFixture.getCafeFixture1();
        CafeDTO cafeDTO2 = cafeFixture.getCafeFixture2();

        myAllCafe.add(cafeDTO1);
        myAllCafe.add(cafeDTO2);

        given(cafeService.getMyAllCafe(cafeDTO1.getUserId())).willReturn(myAllCafe);

        mockMvc.perform(get("/owner/cafe/")
            .sessionAttr("id", cafeDTO1.getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getMyCafe() throws Exception {
        CafeDTO cafeDTO = cafeFixture.getCafeFixture1();

        given(cafeService.getMyCafe(cafeDTO.getCafeId(), cafeDTO.getUserId())).willReturn(cafeDTO);

        mockMvc.perform(get("/owner/cafe/testCafeId1")
            .sessionAttr("userId", cafeDTO.getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value(cafeDTO.getUserId()))
            .andExpect(jsonPath("cafeId").value(cafeDTO.getCafeId()))
            .andExpect(jsonPath("cafeName").value(cafeDTO.getCafeName()))
            .andExpect(jsonPath("tel").value(cafeDTO.getTel()));;
    }
}
