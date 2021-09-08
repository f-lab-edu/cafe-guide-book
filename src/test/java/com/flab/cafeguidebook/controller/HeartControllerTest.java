package com.flab.cafeguidebook.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.UserDTOFixtureProvider;
import com.flab.cafeguidebook.service.HeartService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({SpringExtension.class, UserDTOFixtureProvider.class, CafeDTOFixtureProvider.class})
@SpringBootTest
public class HeartControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private HeartService heartService;

  @BeforeEach
  public void init() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @AfterEach
  private void tearDown(UserDTO user, CafeDTO cafe) throws Exception {
    removeHeart(user, cafe);
  }

  private void addHeart(UserDTO user, CafeDTO cafe) throws Exception {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("userId", user.getId().toString());

    mockMvc.perform(post("/heart/" + cafe.getCafeId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .params(map))
        .andDo(print());
  }

  private void removeHeart(UserDTO user, CafeDTO cafe) throws Exception {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("userId", user.getId().toString());
    addHeart(user, cafe);

    mockMvc.perform(delete("/heart/" + cafe.getCafeId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .params(map))
        .andDo(print());
  }

  @Test
  public void addHeartSuccess(UserDTO user, CafeDTO cafe) throws Exception {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("userId", user.getId().toString());

    mockMvc.perform(post("/heart/" + cafe.getCafeId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .params(map))
        .andDo(print());

    assertNotNull(heartService.getHeart(user.getId(), cafe.getCafeId()));
  }

  @Test
  public void removeHeartSuccess(UserDTO user, CafeDTO cafe) throws Exception {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("userId", user.getId().toString());
    addHeart(user, cafe);

    mockMvc.perform(delete("/heart/" + cafe.getCafeId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .params(map))
        .andDo(print());

    assertNull(heartService.getHeart(user.getId(), cafe.getCafeId()));
  }
}
