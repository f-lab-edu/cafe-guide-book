package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CafeServiceTest {

    @Autowired
    private CafeMapper cafeMapper;

    @Test
    public void addCafe() {
        CafeDTO cafeDTO = new CafeDTO();
        cafeDTO.setId("testId");
        cafeDTO.setCafeName("테스트카페");
        cafeDTO.setTel("010-1234-5678");

        cafeMapper.insertCafe(cafeDTO);
    }
}
