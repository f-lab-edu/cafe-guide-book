package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeMapper {

    public int insertCafe(CafeDTO cafeDTO);

    public List<CafeDTO> selectMyAllCafe(String id);
}

