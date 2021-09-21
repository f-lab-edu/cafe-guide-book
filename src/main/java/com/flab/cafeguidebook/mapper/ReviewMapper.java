package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {

  public int insertReview(@Param("cafeId") Long cafeId, @Param("review") Review review);
}

