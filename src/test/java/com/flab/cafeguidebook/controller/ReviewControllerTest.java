package com.flab.cafeguidebook.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.fixture.ReviewDTOFixtureProvider;
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

@ExtendWith({SpringExtension.class, ReviewDTOFixtureProvider.class})
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
    addReview(review);
    addReview(review);
    addReview(review);

    mockMvc.perform(get("/users/" + review.getUserId() + "/reviews")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(review))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(4)));
  }

  @Test
  public void getCafesReviewSuccess(ReviewDTO review) throws Exception {
    addReview(review);
    addReview(review);
    addReview(review);
    addReview(review);

    mockMvc.perform(get("/cafes/" + review.getCafeId() + "/reviews")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(review))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(4)));
  }
}
