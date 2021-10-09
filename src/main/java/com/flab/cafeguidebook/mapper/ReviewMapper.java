package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Review;
import com.flab.cafeguidebook.dto.ReviewDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {

  public int insertReview(@Param("cafeId") Long cafeId, @Param("review") Review review);

  public List<ReviewDTO> selectReviews(Long userId);

  public List<ReviewDTO> selectCafesReviews(@Param("cafeId") Long cafeId);

  public int deleteReview(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  public int updateReview(@Param("reviewId") Long reviewId, @Param("userId") Long userId,
      @Param("newContent") String newContent);

  public Long selectReviewOwnerId(@Param("reviewId") Long reviewId);
}

