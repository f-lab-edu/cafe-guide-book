package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.CafeDTO;
<<<<<<< HEAD
import com.flab.cafeguidebook.dto.UpdateCafeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
=======
import com.flab.cafeguidebook.enumeration.CafeRegistration;
>>>>>>> develop
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CafeMapper {

<<<<<<< HEAD
    public int insertCafe(CafeDTO cafeDTO);

    public List<CafeDTO> selectMyAllCafe(String userId);

    public boolean isMyCafe(@Param("cafeId") String cafeId, @Param("userId") String userId);

    public CafeDTO selectMyCafe(@Param("cafeId") String cafeId, @Param("userId") String userId);

    public void deleteAllCafe();

    public int updateCafe(UpdateCafeDTO updateCafeDTO);
=======
  public int insertCafe(CafeDTO cafeDTO);

  public int updateRegistration(@Param("id") Long id,
      @Param("registration") CafeRegistration registration);
>>>>>>> develop
}
