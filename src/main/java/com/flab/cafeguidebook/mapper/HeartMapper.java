package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.HeartDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartMapper {

  public int insertHeart(Long userId, Long cafeId);

  public HeartDTO selectHeart(Long userId, Long cafeId);

  public List<HeartDTO> selectUsersHearts(Long userId);

  public int deleteHeart(Long userId, Long cafeId);
}
