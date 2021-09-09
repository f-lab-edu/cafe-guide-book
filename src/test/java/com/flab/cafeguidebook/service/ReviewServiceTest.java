package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.fixture.ReviewDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, ReviewDTOFixtureProvider.class})
@SpringBootTest
public class ReviewServiceTest {

  @Mock
  private ReviewMapper reviewMapper;

  @InjectMocks
  private ReviewService reviewService;

  @Test
  public void addReviewSuccess(ReviewDTO review) {
    when(reviewMapper.insertReview(review)).thenReturn(1);

    assertTrue(reviewService.addReview(review));

    verify(reviewMapper).insertReview(review);
  }
}
