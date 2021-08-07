package com.flab.cafeguidebook.Fixture;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;

public class CafeFixture {

    public String testId = "testId";

    public CafeDTO getCafeFixture1() {
        String id = this.testId;
        CafeDTO cafeDTO1 = new CafeDTO();
        cafeDTO1.setCafeId("testCafeId1");
        cafeDTO1.setUserId(id);
        cafeDTO1.setCafeName("testId의 첫번째 카페");
        cafeDTO1.setTel("010-1234-5678");
        return cafeDTO1;
    }

    public CafeDTO getCafeFixture2() {
        String id = this.testId;
        CafeDTO cafeDTO2 = new CafeDTO();
        cafeDTO2.setCafeId("testCafeId2");
        cafeDTO2.setUserId(id);
        cafeDTO2.setCafeName("testId의 두번째 카페");
        cafeDTO2.setTel("010-2345-6789");
        return cafeDTO2;
    }

}
