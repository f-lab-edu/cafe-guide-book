package com.flab.cafeguidebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.flab.cafeguidebook.dto.UpdateCafeDTO;
import com.flab.cafeguidebook.extension.CafeDTOFisxtureListProvider;
import com.flab.cafeguidebook.extension.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.extension.UpdateCafeDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.CafeMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, CafeDTOFixtureProvider.class,
    CafeDTOFisxtureListProvider.class, UpdateCafeDTOFixtureProvider.class})
@SpringBootTest
public class CafeServiceTest {

    @Mock
    private CafeMapper cafeMapper;

    @InjectMocks
    private CafeService cafeService;

    @Test
    public void addCafe(CafeDTO testCafeDTO) {
        given(cafeMapper.insertCafe(testCafeDTO)).willReturn(1);
        assertThat(cafeService.addCafe(testCafeDTO)).isEqualTo(true);
    }

    @Test
    public void getMyAllCafe(List<CafeDTO> testCafeDTOList) {
        given(cafeMapper.selectMyAllCafe(testCafeDTOList.get(0).getUserId()))
            .willReturn(testCafeDTOList);
        assertThat(cafeService.getMyAllCafe(testCafeDTOList.get(0).getUserId()))
            .isEqualTo(testCafeDTOList);
    }

    @Test
    public void validateMyCafe(CafeDTO testCafeDTO) {
        given(cafeMapper.isMyCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId()))
            .willReturn(true);
        assertThat(cafeService.validateMyCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId()))
            .isEqualTo(true);

    }

    @Test
    public void getMyCafe(CafeDTO testCafeDTO) {
        given(cafeMapper.selectMyCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId()))
            .willReturn(testCafeDTO);
        assertThat(cafeService.getMyCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId()))
            .isEqualTo(testCafeDTO);
    }

    @Test
    public void updateCafe(UpdateCafeDTO updateTestCafeDTO) {
        given(cafeMapper.updateCafe(updateTestCafeDTO)).willReturn(1);
        assertThat(cafeService.updateCafe(updateTestCafeDTO)).isEqualTo(true);
    }

    @Test
    public void deleteCafe(CafeDTO testCafeDTO) {
        given(cafeMapper.deleteCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId())).willReturn(1);
        assertThat(cafeService.deleteCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId())).isEqualTo(true);
    }

}
