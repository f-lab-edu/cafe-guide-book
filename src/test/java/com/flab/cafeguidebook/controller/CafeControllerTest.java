package com.flab.cafeguidebook.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.CafeDTOListFixtureProvider;
import com.flab.cafeguidebook.mapper.CafeMapper;
import java.util.List;
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

@ExtendWith({SpringExtension.class, CafeDTOFixtureProvider.class, CafeDTOListFixtureProvider.class})
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
  public void addCafe(CafeDTO testCafeDTO) throws Exception {

    mockMvc.perform(post("/owner/cafe/")
        .sessionAttr("userId", testCafeDTO.getUserId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testCafeDTO))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("userId").value(testCafeDTO.getUserId()))
        .andExpect(jsonPath("cafeId").value(testCafeDTO.getCafeId()))
        .andExpect(jsonPath("cafeName").value(testCafeDTO.getCafeName()))
        .andExpect(jsonPath("tel").value(testCafeDTO.getTel()));
  }

  @Test
  public void getMyAllCafe(List<CafeDTO> testCafeDTOList) throws Exception {
    for (int i = 0; i < testCafeDTOList.size(); i++) {
      addCafe(testCafeDTOList.get(i));
    }

    mockMvc.perform(get("/owner/cafe/")
        .sessionAttr("userId", testCafeDTOList.get(0).getUserId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  public void updateCafe(CafeDTO testCafeDTO) throws Exception {

    final long CAFEID = 1;
    testCafeDTO.setCafeId(CAFEID);
    addCafe(testCafeDTO);

    mockMvc.perform(patch("/owner/cafe/" + CAFEID)
        .sessionAttr("userId", testCafeDTO.getUserId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testCafeDTO))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("userId").value(testCafeDTO.getUserId()))
        .andExpect(jsonPath("cafeId").value(testCafeDTO.getCafeId()))
        .andExpect(jsonPath("cafeName").value(testCafeDTO.getCafeName()))
        .andExpect(jsonPath("tel").value(testCafeDTO.getTel()));
  }

}
