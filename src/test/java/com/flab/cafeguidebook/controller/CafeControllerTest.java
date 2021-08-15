package com.flab.cafeguidebook.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.domain.UpdateCafe;
import com.flab.cafeguidebook.extension.CafeFixtureListProvider;
import com.flab.cafeguidebook.extension.UpdateCafeFixtureProvider;
import com.flab.cafeguidebook.mapper.CafeMapper;
import java.util.List;
import com.flab.cafeguidebook.domain.Cafe;
import com.flab.cafeguidebook.extension.CafeFixtureProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({SpringExtension.class, CafeFixtureProvider.class, CafeFixtureListProvider.class,
    UpdateCafeFixtureProvider.class})
@SpringBootTest
public class CafeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CafeMapper cafeMapper;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @BeforeEach
    public void deleteAllCafe() {
        cafeMapper.deleteAllCafe();
    }

    @Test
    public void addCafe(Cafe testCafe) throws Exception {

        mockMvc.perform(post("/owner/cafe/")
            .sessionAttr("userId", testCafe.getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(testCafe))
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value(testCafe.getUserId()))
            .andExpect(jsonPath("cafeId").value(testCafe.getCafeId()))
            .andExpect(jsonPath("cafeName").value(testCafe.getCafeName()))
            .andExpect(jsonPath("tel").value(testCafe.getTel()));
    }

    @Test
    public void getMyAllCafe(List<Cafe> testCafeList) throws Exception {
        for (int i = 0; i < testCafeList.size(); i++) {
            addCafe(testCafeList.get(i));
        }

        mockMvc.perform(get("/owner/cafe/")
            .sessionAttr("userId", testCafeList.get(0).getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getMyCafe(Cafe testCafe) throws Exception {
        addCafe(testCafe);

        mockMvc.perform(get("/owner/cafe/testCafeId1")
            .sessionAttr("userId", testCafe.getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value(testCafe.getUserId()))
            .andExpect(jsonPath("cafeId").value(testCafe.getCafeId()))
            .andExpect(jsonPath("cafeName").value(testCafe.getCafeName()))
            .andExpect(jsonPath("tel").value(testCafe.getTel()));
    }

    @Test
    public void updateCafe(Cafe testCafe, UpdateCafe updateTestCafe) throws Exception {
        addCafe(testCafe);

        mockMvc.perform(patch("/owner/cafe/testCafeId1")
            .sessionAttr("userId", updateTestCafe.getUserId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(updateTestCafe))
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value(updateTestCafe.getUserId()))
            .andExpect(jsonPath("cafeId").value(updateTestCafe.getCafeId()))
            .andExpect(jsonPath("cafeName").value(updateTestCafe.getCafeName()))
            .andExpect(jsonPath("tel").value(updateTestCafe.getTel()));
    }

}
