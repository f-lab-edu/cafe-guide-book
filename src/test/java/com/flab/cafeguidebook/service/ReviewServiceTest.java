package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
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
  @Disabled
  public void addReviewSuccess(CafeDTO cafe, ReviewDTO reviewDTO, Review review) {
    when(reviewMapper.insertReview(cafe.getCafeId(), review)).thenReturn(1);

    assertTrue(reviewService.addReview(cafe.getCafeId(), reviewDTO));

    verify(reviewMapper).insertReview(cafe.getCafeId(), review);
  }

  @Test
  public void updateReviewSuccess(ReviewDTO review) {
    when(reviewMapper.updateReview(review.getId(), review.getContent() + "Modifying Contents"))
        .thenReturn(1);

    assertTrue(
        reviewService.updateReview(review.getId(), review.getContent() + "Modifying Contents"));

    verify(reviewMapper).updateReview(review.getId(), review.getContent() + "Modifying Contents");
  }

  @Test
  public void updateReviewSuccess(ReviewDTO review) {
    when(reviewMapper.updateReview(review.getId(), review.getUserId(),
        review.getContent() + "Modifying Contents"))
        .thenReturn(1);

    assertTrue(
        reviewService.updateReview(review.getId(), review.getUserId(),
            review.getContent() + "Modifying Contents"));

    verify(reviewMapper).updateReview(review.getId(), review.getUserId(),
        review.getContent() + "Modifying Contents");
  }

  @Test
  public void getUsersReviewSuccess(ReviewDTO review) {
    final List<ReviewDTO> reviewList = new ArrayList<>();
    reviewList.add(review);
    reviewList.add(review);
    reviewList.add(review);
    when(reviewMapper.selectReviews(review.getUserId())).thenReturn(reviewList);

    assertEquals(reviewService.getUsersReviews(review.getUserId()).size(), 3);

    verify(reviewMapper).selectReviews(review.getUserId());
  }
}
