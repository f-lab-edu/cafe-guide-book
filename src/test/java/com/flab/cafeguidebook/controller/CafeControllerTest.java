package com.flab.cafeguidebook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.domain.Cafe;
import com.flab.cafeguidebook.fixture.CafeFixtureProvider;
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

@ExtendWith({SpringExtension.class, CafeFixtureProvider.class})
@SpringBootTest
public class CafeControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void init() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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
}
