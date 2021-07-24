package com.flab.cafeguidebook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.enumeration.UserType;
import com.flab.cafeguidebook.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  WebApplicationContext webApplicationContext;

  @Autowired
  MockMvc mockMvc;

  @MockBean
  UserService userService;

  private User testUser;

  @BeforeEach
  public void init() {
    testUser = User.builder()
        .email("yssj2049@gmail.com")
        .password("Cafe1234!")
        .name("김민성")
        .phone("010-8358-2049")
        .address("경기도 화성시 호수공원")
        .userType(UserType.USER)
        .build();
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @DisplayName("회원가입 컨트롤러 진입 테스트")
  void signUpSuccess() throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    mockMvc.perform(post("/users/signUp")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(print());
  }


  @Test
  @DisplayName("회원가입 컨트롤러 진입 실패 테스트(입력값 누락)")
  void signUpFailWithMissingParam() throws Exception {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("email", "yssj2049@gmail.com");
    map.add("password", "Cafe1234!");
//    map.add("name", "김민성"); 이름이 누락된 경우
    map.add("phone", "010-8358-2049");
    map.add("address", "경기도 화성시 호수공원");
    map.add("type", "0");

    mockMvc.perform(post("/users/signUp")
        .params(map))
        .andExpect(status().isBadRequest());
  }
}
