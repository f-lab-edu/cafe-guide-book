package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.dto.HeartDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HeartMapper {

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int insertHeart(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public HeartDTO selectHeart(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public List<HeartDTO> selectUsersHearts(@Param("userId") Long userId);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int deleteHeart(@Param("userId") Long userId, @Param("cafeId") Long cafeId);
}
