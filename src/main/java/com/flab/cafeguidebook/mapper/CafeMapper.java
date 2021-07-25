package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeMapper {

    public int insertCafe(CafeDTO cafeDTO);

    public List<CafeDTO> selectMyAllCafe(String id);

    public boolean isMyCafe(@Param("cafeId") String cafeId, @Param("id") String id);

    public CafeDTO selectMyCafe(@Param("cafeId") String cafeId, @Param("id") String id);

    public void deleteAllCafe();
}

