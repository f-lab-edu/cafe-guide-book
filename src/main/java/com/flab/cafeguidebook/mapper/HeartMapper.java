package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.HeartDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HeartMapper {

  public int insertHeart(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  public HeartDTO selectHeart(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  public List<HeartDTO> selectUsersHearts(@Param("userId") Long userId);

  public int deleteHeart(@Param("userId") Long userId, @Param("cafeId") Long cafeId);

  public List<HeartDTO> selectCafesHearts(@Param("userId") Long userId);
}
