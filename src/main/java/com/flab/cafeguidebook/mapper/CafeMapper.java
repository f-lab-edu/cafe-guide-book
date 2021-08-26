package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.CafeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {

  public int insertCafe(CafeDTO cafeDTO);
}

