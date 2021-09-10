package com.flab.cafeguidebook.service;

import static com.flab.cafeguidebook.enumeration.CafeRegistration.APPROVAL;
import static com.flab.cafeguidebook.enumeration.CafeRegistration.DENY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, CafeDTOFixtureProvider.class})
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
}
