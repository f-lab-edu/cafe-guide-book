package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.domain.Review;
import com.flab.cafeguidebook.dto.ReviewDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int insertReview(@Param("cafeId") Long cafeId, @Param("review") Review review);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public List<ReviewDTO> selectReviews(Long userId);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public List<ReviewDTO> selectCafesReviews(@Param("cafeId") Long cafeId);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int deleteReview(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int updateReview(@Param("reviewId") Long reviewId, @Param("newContent") String newContent);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public Long selectReviewOwnerId(@Param("reviewId") Long reviewId);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int deleteReview(@Param("reviewId") Long reviewId);
}

