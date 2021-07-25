package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.*;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CafeServiceTest {

    @Autowired
    private CafeMapper cafeMapper;

    @Test
    public void addCafe() {
        String id = "testId";
        CafeDTO cafeDTO = new CafeDTO();
        cafeDTO.setId(id);
        cafeDTO.setCafeName("테스트카페");
        cafeDTO.setTel("010-1234-5678");

        cafeMapper.insertCafe(cafeDTO);
    }

    @Test
    public void myAllCafe(){
        String id = "testId";
        cafeMapper.selectMyAllCafe(id);
    }
}
