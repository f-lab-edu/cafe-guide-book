package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.HeartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartMapper {

  public int insertHeart(Long userId, Long cafeId);

  public HeartDTO selectHeart(Long userId, Long cafeId);

  public int deleteHeart(Long userId, Long cafeId);
}
