package com.flab.cafeguidebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.flab.cafeguidebook.Fixture.CafeFixture;
import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CafeServiceTest {

    @Mock
    private CafeMapper cafeMapper;

    @InjectMocks
    private CafeService cafeService;

    private static CafeFixture cafeFixture;

    @BeforeAll
    public static void setUp() {
        cafeFixture = new CafeFixture();
    }

    @AfterAll
    public static void tearDown() {
        cafeFixture = null;
    }

    @Test
    public void addCafe() {
        CafeDTO cafeDTO = cafeFixture.getCafeFixture1();

        given(cafeMapper.insertCafe(cafeDTO)).willReturn(1);
        assertThat(cafeService.addCafe(cafeDTO)).isEqualTo(true);
    }
}

