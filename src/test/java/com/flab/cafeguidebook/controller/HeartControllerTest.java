package com.flab.cafeguidebook.controller;

import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentRequest;
import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentResponse;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.UserDTOFixtureProvider;
import com.flab.cafeguidebook.service.HeartService;
import com.flab.cafeguidebook.util.SessionKeys;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({SpringExtension.class, UserDTOFixtureProvider.class, CafeDTOFixtureProvider.class,
    RestDocumentationExtension.class})
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
  public void init(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();
  }

  @AfterEach
  private void tearDown(UserDTO user, CafeDTO cafe) throws Exception {
    removeHeart(user, cafe);
  }

  private void addHeart(UserDTO user, CafeDTO cafe) throws Exception {
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, user.getId());
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("userId", user.getId().toString());

    mockMvc.perform(post("/cafes/" + cafe.getCafeId() + "/hearts")
        .session(session)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .params(map))
        .andDo(print());
  }

  private void removeHeart(UserDTO user, CafeDTO cafe) throws Exception {
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, user.getId());
    mockMvc
        .perform(delete("/cafes/" + cafe.getCafeId() + "/hearts")
            .session(session));
  }

  @Test
  public void addHeartSuccess(UserDTO user, CafeDTO cafe) throws Exception {
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, user.getId());

    mockMvc
        .perform(RestDocumentationRequestBuilders.post("/cafes/{cafeId}/hearts", cafe.getCafeId())
            .session(session))
        .andDo(print())
        .andDo(document("add-heart",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("cafeId").description("카페의 ID")
            )
        ));
  }

  @Test
  public void addHeartFailWithSignOut(UserDTO user, CafeDTO cafe) throws Exception {
    mockMvc.perform(post("/cafes/" + cafe.getCafeId() + "/hearts"))
        .andExpect(status().isUnauthorized())
        .andDo(print());
  }

  @Test
  public void removeHeartSuccess(UserDTO user, CafeDTO cafe) throws Exception {
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, user.getId());

    mockMvc
        .perform(RestDocumentationRequestBuilders.delete("/cafes/{cafeId}/hearts", cafe.getCafeId())
            .session(session))
        .andDo(print())
        .andDo(document("remove-heart",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("cafeId").description("카페의 ID")
            )
        ));

    assertNull(heartService.getHeart(user.getId(), cafe.getCafeId()));
  }

  @Test
  public void removeHeartFailWithSignOut(UserDTO user, CafeDTO cafe) throws Exception {
    mockMvc.perform(post("/cafes/" + cafe.getCafeId() + "/hearts"))
        .andExpect(status().isUnauthorized())
        .andDo(print());
  }

  @Test
  public void getUsersHeartsSuccess(UserDTO user, CafeDTO cafe) throws Exception {
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, user.getId());
    addHeart(user, cafe);
    addHeart(user, cafe);
    addHeart(user, cafe);

    mockMvc.perform(get("/users/" + user.getId() + "/hearts")
        .session(session)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(3)));
  }

  @Test
  public void getUsersHeartsSuccessWithNull(UserDTO user, CafeDTO cafe) throws Exception {
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, user.getId());

    mockMvc.perform(get("/users/" + user.getId() + "/hearts")
        .session(session)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }

  @Test
  public void getCafesHeartsSuccess(UserDTO user, CafeDTO cafe) throws Exception {
    addHeart(user, cafe);
    addHeart(user, cafe);
    addHeart(user, cafe);
    addHeart(user, cafe);

    mockMvc.perform(get("/owner/cafe/hearts/" + cafe.getCafeId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(4)));
  }
}
