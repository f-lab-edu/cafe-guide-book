package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.UpdateCafeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeMapper {

    public int insertCafe(CafeDTO cafeDTO);

    public List<CafeDTO> selectMyAllCafe(String id);

    public boolean isMyCafe(@Param("cafeId") String cafeId, @Param("userId") String userId);

    public CafeDTO selectMyCafe(@Param("cafeId") String cafeId, @Param("userId") String userId);

    public void deleteAllCafe();

    public int updateCafe(UpdateCafeDTO updateCafeDTO);
}
