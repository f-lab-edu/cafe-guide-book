package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.*;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class CafeServiceTest {

    @Autowired
    private CafeMapper cafeMapper;

    public String testId = "testId";

    public CafeDTO testFixture1() {
        String id = this.testId;
        CafeDTO cafeDTO1 = new CafeDTO();
        cafeDTO1.setCafeId("testCafeId1");
        cafeDTO1.setId(id);
        cafeDTO1.setCafeName("testId의 첫번째 카페");
        cafeDTO1.setTel("010-1234-5678");
        return cafeDTO1;
    }

    public CafeDTO testFixture2() {
        String id = this.testId;
        CafeDTO cafeDTO2 = new CafeDTO();
        cafeDTO2.setId(id);
        cafeDTO2.setCafeId("testCafeId2");
        cafeDTO2.setCafeName("testId의 두번째 카페");
        cafeDTO2.setTel("010-2345-6789");
        return cafeDTO2;
    }

    @BeforeAll
    public void deleteTestFixtures(){
        cafeMapper.deleteAllCafe();
    }

    @Test
    public void addCafe() {
        CafeDTO cafeDTO = testFixture1();
        cafeMapper.insertCafe(cafeDTO);
    }

    @Test
    public void getMyAllCafe() {
        cafeMapper.selectMyAllCafe(this.testId);
    }

    @Test
    public void validateMyCafe() {
        CafeDTO cafeDTO = testFixture1();
        System.out.println(cafeDTO.getCafeId());
        cafeMapper.isMyCafe(cafeDTO.getCafeId(), cafeDTO.getId());
    }

    @Test
    public void getMyCafe(){
        CafeDTO cafeDTO = testFixture1();
        System.out.println(cafeDTO.getCafeId());
        cafeMapper.selectMyCafe(cafeDTO.getCafeId(), cafeDTO.getId());
    }
}
