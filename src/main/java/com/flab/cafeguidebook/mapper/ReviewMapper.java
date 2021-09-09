package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

  public int insertReview(ReviewDTO reviewDTO);
}

