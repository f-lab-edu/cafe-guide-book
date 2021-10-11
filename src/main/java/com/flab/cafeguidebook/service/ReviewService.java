package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.domain.Review;
import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.exception.UnautorizedException;
import com.flab.cafeguidebook.mapper.ReviewMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

  @Autowired
  private ReviewMapper reviewMapper;

  public boolean addReview(Long cafeId, ReviewDTO reviewDTO) {
    Review review = Review.builder()
        .id(reviewDTO.getId())
        .userId(reviewDTO.getUserId())
        .cafeId(reviewDTO.getCafeId())
        .content(reviewDTO.getContent())
        .score(reviewDTO.getScore())
        .build();
    int insertReviewResult = reviewMapper.insertReview(cafeId, review);
    return insertReviewResult == 1;
  }

  public List<ReviewDTO> getUsersReviews(Long userId) {
    return reviewMapper.selectReviews(userId);
  }

  public List<ReviewDTO> getCafesReviews(Long cafeId) {
    return reviewMapper.selectCafesReviews(cafeId);
  }

  public boolean removeReview(Long userId, Long cafeId) {
    int deleteReviewResult = reviewMapper.deleteReview(userId, cafeId);
    return deleteReviewResult == 1;
  }

  public boolean updateReview(Long reviewId, Long userId, String newContent) {
    Long ownerId = reviewMapper.selectReviewOwnerId(reviewId);
    if (!userId.equals(ownerId)) {
      throw new UnautorizedException();
    }
    return reviewMapper.updateReview(reviewId, newContent) == 1;
  }

  public boolean deleteReview(Long reviewId, Long userId) {
    Long ownerId = reviewMapper.selectReviewOwnerId(reviewId);
    if (!userId.equals(ownerId)) {
      throw new UnautorizedException();
    }
    return reviewMapper.deleteReview(reviewId) == 1;
  }
}
