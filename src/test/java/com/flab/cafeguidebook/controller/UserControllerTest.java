package com.flab.cafeguidebook.controller;

import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentRequest;
import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.domain.UserSignInRequest;
import com.flab.cafeguidebook.exception.DuplicatedEmailException;
import com.flab.cafeguidebook.exception.UserNotFoundException;
import com.flab.cafeguidebook.fixture.UserFixtureProvider;
import com.flab.cafeguidebook.service.UserService;
import com.flab.cafeguidebook.util.SessionKeys;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

@ExtendWith({SpringExtension.class, UserFixtureProvider.class, RestDocumentationExtension.class})
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
  public void init(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();
    httpSession = new MockHttpSession();
  }

  @AfterEach
  void tearDown(User testUser) throws Exception {
    withdrawTestUser(testUser);
  }

  @Test
  @Disabled
  @DisplayName("회원가입 컨트롤러 진입 테스트")
  void signUpSuccess(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    mockMvc.perform(RestDocumentationRequestBuilders.post("/users/signUp")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(print())
        .andDo(document("sign-up",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일 (필수)"),
                fieldWithPath("password").type(JsonFieldType.STRING)
                    .description("패스워드 (필수. 영문, 숫자, 특수문자를 반드시 포함 8~20자리)"),
                fieldWithPath("name").type(JsonFieldType.STRING).description("이름 (필수)"),
                fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호 (필수)"),
                fieldWithPath("address").type(JsonFieldType.STRING).description("주소 (필수)"),
                fieldWithPath("userType").type(JsonFieldType.STRING)
                    .description("유저타입 (필수, 일반회원 : 1, 카페사장님 : 2, 어드민 : 3)").optional()
            )
        ));
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
  @Disabled
  @DisplayName("이메일 중복시 회원가입 실패(422리턴 및 DuplicatedEmailException throw)")
  void signUpFailWithDuplicatedEmail(User testUser) throws Exception {
    signUpTestUser(testUser);
    String content = objectMapper.writeValueAsString(testUser);

    Exception e = assertThrows(NestedServletException.class,
        () -> {
          mockMvc.perform(post("/users/signUp")
              .content(content)
              .contentType(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isUnprocessableEntity())
              .andDo(print());
        });

    assertEquals(DuplicatedEmailException.class, e.getCause().getClass());
    withdrawTestUser(testUser);
  }

  @Test
  @Disabled
  @DisplayName("이메일, 패스워드가 DB에 등록된 정보와 일치하면 로그인에 성공하고 200을 리턴함")
  public void signInUserTestWithSuccess(User testUser) throws Exception {
    signUpTestUser(testUser);

    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.add("email", testUser.getEmail());
    paramMap.add("password", testUser.getPassword());
    signUpTestUser(testUser);
    String content = objectMapper
        .writeValueAsString(new UserSignInRequest(testUser.getEmail(), testUser.getPassword()));

    mockMvc.perform(
        post("/users/signIn")
            .content(content)
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andDo(document("sign-in",
            getDocumentRequest(),
            getDocumentResponse(),
            requestParameters(
                parameterWithName("email").description("이메일 (필수)"),
                parameterWithName("password").description("패스워드 (필수)")
            )
        )).andExpect(status().isOk());

    withdrawTestUser(testUser);
  }

  void signUpTestUser(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    mockMvc.perform(post("/users/signUp")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(print());
  }

  void withdrawTestUser(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);
    userService.deleteUser(testUser.getEmail());
  }

  void signInTestUser(User testUser) throws Exception {
    String content = objectMapper
        .writeValueAsString(new UserSignInRequest(testUser.getEmail(), testUser.getPassword()));

    mockMvc.perform(post("/users/signIn")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());
  }

  void signOutTestUser() throws Exception {
    userService.signOut();
  }

  @Test
  @Disabled
  @DisplayName("회원정보 조회 통합 테스트")
  void getUserSuccess(User testUser) throws Exception {
    signUpTestUser(testUser);
    String content = objectMapper.writeValueAsString(testUser);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, testUser.getEmail());

    mockMvc.perform(RestDocumentationRequestBuilders.get("/users/{email}", testUser.getEmail())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("get-user",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("email").description("이메일")
            ),
            responseFields(
                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호").optional(),
                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                fieldWithPath("address").type(JsonFieldType.STRING).description("주소"),
                fieldWithPath("userType").type(JsonFieldType.STRING)
                    .description("유저타입 (필수, 일반회원 : 1, 카페사장님 : 2, 어드민 : 3)").optional()
            )
        ));
    mockMvc.perform(get("/users/" + testUser.getEmail())
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .session(session))
        .andExpect(status().isOk())
        .andDo(print());

    withdrawTestUser(testUser);
  }

  @Test
  @DisplayName("로그인이 안되어 있는 경우 회원정보 조회 실패 통합 테스트, 401 리턴")
  void getUserFailWithNotSignIn(User testUser) throws Exception {
    String content = objectMapper.writeValueAsString(testUser);

    mockMvc.perform(get("/users/" + testUser.getEmail())
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized())
        .andDo(print());
  }

  @Test
  @Disabled
  @DisplayName("존재하지 않는 회원정보 조회 통합 테스트")
  void getUserFailWithNoUserExist(User testUser) throws Exception {
    signUpTestUser(testUser);
    signInTestUser(testUser);
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
    signOutTestUser();
    withdrawTestUser(testUser);
  }

  @Test
  @Disabled
  @DisplayName("로그아웃 성공시 200을 리턴함")
  public void signOutTestWithSuccess(User testUser) throws Exception {
    signUpTestUser(testUser);
    String content = objectMapper.writeValueAsString(testUser);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, testUser.getEmail());

    mockMvc.perform(get("/users/signOut"))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("sign-out",
            getDocumentRequest(),
            getDocumentResponse()
        ));

    assertNull(httpSession.getAttribute(SessionKeys.USER_ID));
    withdrawTestUser(testUser);
  }

  @Test
  @DisplayName("로그아웃 실패시 200을 리턴함")
  public void signOutTestFailWithNotSignIn(User testUser) throws Exception {
    mockMvc.perform(
        get("/users/signOut"))
        .andExpect(status().isUnauthorized())
        .andDo(print());

    assertNull(httpSession.getAttribute(SessionKeys.USER_ID));
  }

  @Test
  @Disabled
  @DisplayName("비밀번호 업데이트 성공시 204를 리턴함")
  public void updatePasswordTestWithSuccess(User testUser) throws Exception {
    signUpTestUser(testUser);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, testUser.getEmail());
    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.add("email", testUser.getEmail());
    paramMap.add("newPassword", testUser.getPassword() + "newPassword");

    mockMvc.perform(
        RestDocumentationRequestBuilders.patch("/users/password")
            .params(paramMap)
            .session(session))
        .andExpect(status().isNoContent())
        .andDo(print())
        .andDo(document("update-password",
            getDocumentRequest(),
            getDocumentResponse(),
            requestParameters(
                parameterWithName("email").description("비밀번호를 변경할 계정의 이메일"),
                parameterWithName("newPassword").description("변경할 새로운 패스워드")
            )
        ));

    assertNull(httpSession.getAttribute(SessionKeys.USER_ID));
  }

  @Test
  @DisplayName("로그아웃일 경우 비밀번호 업데이트 성공시 204를 리턴함")
  public void updatePasswordTestFailWithSignOut(User testUser) throws Exception {
    signUpTestUser(testUser);

    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.add("email", testUser.getEmail());
    paramMap.add("newPassword", testUser.getPassword() + "newPassword");

    mockMvc.perform(
        patch("/users/password")
            .contentType(MediaType.APPLICATION_JSON)
            .params(paramMap))
        .andExpect(status().isUnauthorized())
        .andDo(print());

    assertNull(httpSession.getAttribute(SessionKeys.USER_ID));
  }

  @Test
  @DisplayName("회원탈퇴 성공시 200을 리턴함")
  public void withdrawalTestWithSuccess(User testUser) throws Exception {
    signUpTestUser(testUser);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, testUser.getId());

    mockMvc.perform(
        RestDocumentationRequestBuilders.delete("/users/{email}", testUser.getEmail())
            .session(session))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("withdrawal",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("email").description("회원탈퇴할 계정의 이메일")
            )
        ));
  }

  @Test
  @Disabled
  @DisplayName("로그아웃 상태시 회원탈퇴 실패 401 Unauthorized 리턴")
  public void withdrawalTestFailWithSignOut(User testUser) throws Exception {
    signUpTestUser(testUser);

    mockMvc.perform(
        delete("/users/withdrawal/" + testUser.getEmail()))
        .andDo(print())
        .andExpect(status().isUnauthorized())
        .andDo(print());
    assertNull(httpSession.getAttribute(SessionKeys.USER_ID));
  }
}
