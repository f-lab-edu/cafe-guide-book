package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.CafeDTO;
import org.apache.ibatis.annotations.Param;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {

  public int insertCafe(CafeDTO cafeDTO);

  public int updateRegistration(@Param("id") Long id,
      @Param("registration") CafeRegistration registration);

  public int deleteCafe(@Param("cafeId") Long cafeId);
}
