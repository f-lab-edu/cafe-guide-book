package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.*;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
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