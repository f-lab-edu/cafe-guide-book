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
    CafeService cafeService;

    public String testId = "testId";

    public CafeDTO testFixture1() {
        String id = this.testId;
        CafeDTO cafeDTO1 = new CafeDTO();
        cafeDTO1.setCafeId("testCafeId1");
        cafeDTO1.setId(id);
        cafeDTO1.setCafeName("testId의 첫번째 카페");
        cafeDTO1.setTel("010-1234-5678");
        return cafeDTO1;
    }

    public CafeDTO testFixture2() {
        String id = this.testId;
        CafeDTO cafeDTO2 = new CafeDTO();
        cafeDTO2.setId(id);
        cafeDTO2.setCafeId("testCafeId2");
        cafeDTO2.setCafeName("testId의 두번째 카페");
        cafeDTO2.setTel("010-2345-6789");
        return cafeDTO2;
    }

    @Test
    public void addCafe() throws Exception {
        CafeDTO cafeDTO = testFixture1();

        mockMvc.perform(post("/owner/cafe/")
            .sessionAttr("id", testFixture1().getId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(mapper.writeValueAsString(cafeDTO))
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void getMyAllCafe() throws Exception {
        List<CafeDTO> myAllCafe = new ArrayList<>();

        CafeDTO cafeDTO1 = testFixture1();
        CafeDTO cafeDTO2 = testFixture2();

        myAllCafe.add(cafeDTO1);
        myAllCafe.add(cafeDTO2);

        given(cafeService.getMyAllCafe(cafeDTO1.getId())).willReturn(myAllCafe);

        mockMvc.perform(get("/owner/cafe/")
            .sessionAttr("id", cafeDTO1.getId())
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void getMyCafe() throws Exception {
        CafeDTO cafeDTO = testFixture1();

        given(cafeService.getMyCafe(cafeDTO.getCafeId(), cafeDTO.getId())).willReturn(cafeDTO);

        mockMvc.perform(get("/owner/cafe/testCafeId1")
            .sessionAttr("id", cafeDTO.getId())
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());

    }
}


