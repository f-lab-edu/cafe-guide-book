package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.domain.Review;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.ReviewDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.ReviewFixtureProvider;
import com.flab.cafeguidebook.mapper.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, CafeDTOFixtureProvider.class, ReviewDTOFixtureProvider.class,
    ReviewFixtureProvider.class})
@SpringBootTest
public class ReviewServiceTest {

  @Mock
  private ReviewMapper reviewMapper;

  @InjectMocks
  private ReviewService reviewService;

  @Test
  public void addReviewSuccess(CafeDTO cafe, ReviewDTO reviewDTO, Review review) {
    when(reviewMapper.insertReview(cafe.getCafeId(), review)).thenReturn(1);

    assertTrue(reviewService.addReview(cafe.getCafeId(), reviewDTO));

    verify(reviewMapper).insertReview(cafe.getCafeId(), review);
  }
}
