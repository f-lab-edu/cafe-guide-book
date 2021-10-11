package com.flab.cafeguidebook.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.ReviewDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.UserDTOFixtureProvider;
import com.flab.cafeguidebook.util.SessionKeys;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

@ExtendWith({SpringExtension.class, UserDTOFixtureProvider.class, CafeDTOFixtureProvider.class,
    ReviewDTOFixtureProvider.class})
@SpringBootTest
public class ReviewControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void init() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @AfterEach
  public void tearDown(UserDTO user, CafeDTO cafe, ReviewDTO review) throws Exception {
    removeReview(review);
  }

  private void removeReview(ReviewDTO review) throws Exception {
    System.out.println("called!");
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, review.getUserId());
    mockMvc
        .perform(delete("/cafes/" + review.getCafeId() + "/reviews/" + review.getId())
            .session(session))
        .andDo(print());
  }

  @Test
  public void addReviewSuccess(ReviewDTO review)
      throws Exception {

    mockMvc.perform(post("/cafes/" + review.getCafeId() + "/reviews")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(review))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("userId").value(review.getUserId()))
        .andExpect(jsonPath("cafeId").value(review.getCafeId()))
        .andExpect(jsonPath("score").value(review.getScore()))
        .andExpect(jsonPath("content").value(review.getContent()));
  }

  private void addReview(ReviewDTO review) throws Exception {
    mockMvc.perform(post("/cafes/" + review.getCafeId() + "/reviews")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(review))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("userId").value(review.getUserId()))
        .andExpect(jsonPath("cafeId").value(review.getCafeId()))
        .andExpect(jsonPath("score").value(review.getScore()))
        .andExpect(jsonPath("content").value(review.getContent()));
  }

  @Test
  public void getUsersReviewSuccess(ReviewDTO review) throws Exception {
    addReview(review);

    mockMvc.perform(get("/users/" + review.getUserId() + "/reviews")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(review))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));
  }

  @Test
  public void getCafesReviewSuccess(ReviewDTO review) throws Exception {
    addReview(review);

    mockMvc.perform(get("/cafes/" + review.getCafeId() + "/reviews")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(review))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));
  }

  @Test
  @Disabled
  public void updateReviewSuccess(ReviewDTO review) throws Exception {
    addReview(review);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute(SessionKeys.USER_ID, review.getUserId());
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    final String newContent = "I want to modify my review.";

    mockMvc.perform(patch("/reviews/" + review.getId())
        .param("newContent", newContent)
        .session(session))
        .andExpect(status().isOk())
        .andDo(print());
  }

  @Test
  public void deleteReviewSuccess(ReviewDTO review) throws Exception {
    addReview(review);

    mockMvc.perform(delete("/reviews/" + review.getId()))
        .andExpect(status().isOk())
        .andDo(print());
  }
}
