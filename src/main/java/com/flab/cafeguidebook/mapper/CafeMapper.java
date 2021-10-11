package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Cafe;
import com.flab.cafeguidebook.dto.CafeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {

  public int insertCafe(Cafe cafe);

  public List<CafeDTO> selectMyAllCafe(long userId);

  public boolean isMyCafe(@Param("cafeId") long cafeId, @Param("userId") long userId);

  public CafeDTO selectMyCafe(@Param("cafeId") long cafeId, @Param("userId") long userId);

  public void deleteAllCafe();

  public int updateCafe(Cafe cafe);

  public int updateRegistration(@Param("id") Long id,
      @Param("registration") CafeRegistration registration);

}
