package com.flab.cafeguidebook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.exception.UserNotFoundException;
import com.flab.cafeguidebook.fixture.UserFixtureProvider;
import com.flab.cafeguidebook.service.UserService;
import com.flab.cafeguidebook.util.SessionKeys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

@ExtendWith({SpringExtension.class, UserFixtureProvider.class})
@SpringBootTest
class UserControllerTest {

  MockHttpSession httpSession;
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private UserService userService;

  @BeforeEach
  public void init() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    httpSession = new MockHttpSession();
  }

  @Test
  @DisplayName("회원가입 컨트롤러 진입 테스트")
  void signUpSuccess(User testUser) throws Exception {
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
    map.add("phone", "010-8358-2049");
    map.add("address", "경기도 화성시 호수공원");
    map.add("type", "0");

    mockMvc.perform(post("/users/signUp")
        .params(map))
        .andExpect(status().isBadRequest());
  }

  @Test
  @DisplayName("이메일, 패스워드가 DB에 등록된 정보와 일치하면 로그인에 성공하고 200을 리턴함")
  public void signInUserTestWithSuccess(User testUser) throws Exception {

    insertTestUser(testUser);

    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.add("email", testUser.getEmail());
    paramMap.add("password", testUser.getPassword());

    mockMvc.perform(
        post("/users/signIn")
            .contentType(MediaType.APPLICATION_JSON)
            .params(paramMap))
        .andDo(print())
        .andExpect(status().isOk());

    deleteTestUser(testUser);
  }

  void insertTestUser(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    mockMvc.perform(post("/users/signUp")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(print());
  }

  void deleteTestUser(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);
    userService.deleteUser(testUser.getEmail());
  }

  @Test
  @DisplayName("회원정보 조회 통합 테스트")
  void getUserSuccess(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    mockMvc.perform(post("/users/signUp")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(print());

    mockMvc.perform(get("/users/" + testUser.getEmail())
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());
  }

  @Test
  @DisplayName("존재하지 않는 회원정보 조회 통합 테스트")
  void getUserFailWithNoUserExist(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    Exception e = assertThrows(NestedServletException.class,
        () -> {
          mockMvc.perform(get("/users/" + "NO_EXISTED_EMAIL")
              .content(content)
              .contentType(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isNotFound())
              .andDo(print());
        });
    assertEquals(UserNotFoundException.class, e.getCause().getClass());
  }

  @Test
  @DisplayName("로그아웃 성공시 200을 리턴함")
  public void signOutTestWithSuccess(User testUser) throws Exception {
    mockMvc.perform(
        get("/users/signOut"))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(print());

    assertNull(httpSession.getAttribute(SessionKeys.USER_EMAIL));
  }
}
