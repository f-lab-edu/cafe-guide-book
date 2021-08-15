package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.CafeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {

    public int insertCafe(CafeDTO cafeDTO);

    public List<CafeDTO> selectMyAllCafe(String userId);

    public boolean isMyCafe(@Param("cafeId") String cafeId, @Param("userId") String userId);

    public CafeDTO selectMyCafe(@Param("cafeId") String cafeId, @Param("userId") String userId);

    public void deleteAllCafe();
}
