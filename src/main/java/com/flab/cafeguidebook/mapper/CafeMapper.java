package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.CafeDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeMapper {

    public int insertCafe(CafeDTO cafeDTO);
}

