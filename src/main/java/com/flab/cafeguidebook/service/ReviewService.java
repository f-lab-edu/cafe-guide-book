package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.domain.Review;
import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.mapper.ReviewMapper;
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
}
