package com.flab.cafeguidebook.service;

import static com.flab.cafeguidebook.enumeration.CafeRegistration.APPROVAL;
import static com.flab.cafeguidebook.enumeration.CafeRegistration.DENY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.converter.CafeConverter.CafeDTOToCafeConverter;
import com.flab.cafeguidebook.domain.Cafe;
import com.flab.cafeguidebook.fixture.CafeDTOListFixtureProvider;
import com.flab.cafeguidebook.fixture.CafeFixtureProvider;
import com.flab.cafeguidebook.mapper.CafeMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, CafeDTOFixtureProvider.class,
    CafeDTOListFixtureProvider.class, CafeFixtureProvider.class})
@SpringBootTest
public class CafeServiceTest {

  @Mock
  private CafeMapper cafeMapper;

  @Mock
  private CafeDTOToCafeConverter cafeDTOToCafeConverter;

  @InjectMocks
  private CafeService cafeService;

  @Test
  public void addCafe(CafeDTO testCafeDTO, Cafe testCafe) {
    when(cafeDTOToCafeConverter.convert(testCafeDTO)).thenReturn(testCafe);
    given(cafeMapper.insertCafe(testCafe)).willReturn(1);
    assertThat(cafeService.addCafe(testCafeDTO)).isEqualTo(true);
  }

  @Test
  public void approveRegistrationCafeSuccess() {
    given(cafeMapper.updateRegistration(33333L, APPROVAL))
        .willReturn(1);

    assertThat(cafeService.approveRegistration(33333L)).isEqualTo(true);
  }

  @Test
  public void denyRegistrationCafeSuccess() {
    given(cafeMapper.updateRegistration(33333L, DENY))
        .willReturn(1);

    assertThat(cafeService.denyRegistration(33333L)).isEqualTo(true);
  }

  @Test
  public void deleteCafe(CafeDTO testCafeDTO) {
    given(cafeMapper.deleteCafe(testCafeDTO.getCafeId())).willReturn(1);
    assertThat(cafeService.deleteCafe(testCafeDTO.getCafeId())).isEqualTo(true);
    verify(cafeMapper).deleteCafe(testCafeDTO.getCafeId());
  }

  @Test
  public void getMyAllCafe(List<CafeDTO> testCafeDTOList) {
    given(cafeMapper.selectMyAllCafe(testCafeDTOList.get(0).getUserId()))
        .willReturn(testCafeDTOList);
    assertThat(cafeService.getMyAllCafe(testCafeDTOList.get(0).getUserId()))
        .isEqualTo(testCafeDTOList);
  }

  @Test
  public void getMyCafe(CafeDTO testCafeDTO) {
    given(cafeMapper.selectMyCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId()))
        .willReturn(testCafeDTO);
    assertThat(cafeService.getMyCafe(testCafeDTO.getCafeId(), testCafeDTO.getUserId()))
        .isEqualTo(testCafeDTO);
  }

  @Test
  public void updateCafe(CafeDTO testCafeDTO, Cafe testCafe) {
    when(cafeDTOToCafeConverter.convert(testCafeDTO)).thenReturn(testCafe);
    given(cafeMapper.updateCafe(testCafe)).willReturn(1);
    assertThat(cafeService.updateCafe(testCafeDTO)).isEqualTo(true);
  }
}
