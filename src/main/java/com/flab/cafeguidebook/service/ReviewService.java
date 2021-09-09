package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

  @Autowired
  private ReviewMapper reviewMapper;

  public boolean addReview(ReviewDTO reviewDTO) {
    int insertReviewResult = reviewMapper.insertReview(reviewDTO);
    return insertReviewResult == 1;
  }
}
