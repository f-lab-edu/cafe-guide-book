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
}

