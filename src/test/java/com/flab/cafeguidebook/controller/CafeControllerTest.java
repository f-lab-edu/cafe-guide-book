package com.flab.cafeguidebook.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.service.CafeService;
import java.util.ArrayList;
import java.util.List;
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
    CafeService cafeService;

    @Test
    public void addCafe() throws Exception {
        String id = "testId";
        CafeDTO cafeDTO = new CafeDTO();
        cafeDTO.setCafeId("testCafeId1");
        cafeDTO.setId(id);
        cafeDTO.setCafeName("testId의 첫번째 카페");
        cafeDTO.setTel("010-1234-5678");

        mockMvc.perform(post("/owner/cafe/")
            .sessionAttr("id", id)
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(mapper.writeValueAsString(cafeDTO))
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void myAllCafe() throws Exception {
        String id = "testId";
        List<CafeDTO> myAllCafe = new ArrayList<>();

        CafeDTO cafeDTO1 = new CafeDTO();
        cafeDTO1.setId(id);
        cafeDTO1.setCafeId("testCafeId1");
        cafeDTO1.setCafeName("testId의 첫번째 카페");
        cafeDTO1.setTel("010-1234-5678");

        CafeDTO cafeDTO2 = new CafeDTO();
        cafeDTO2.setId(id);
        cafeDTO1.setCafeId("testCafeId2");
        cafeDTO2.setCafeName("testId의 두번째 카페");
        cafeDTO2.setTel("010-2345-6789");

        myAllCafe.add(cafeDTO1);
        myAllCafe.add(cafeDTO2);

        given(cafeService.myAllCafe(id)).willReturn(myAllCafe);

        mockMvc.perform(get("/owner/cafe/")
            .sessionAttr("id", id)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());
    }
}


