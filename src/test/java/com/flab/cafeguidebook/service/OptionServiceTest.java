package com.flab.cafeguidebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.fixture.OptionDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.OptionMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, OptionDTOFixtureProvider.class})
@SpringBootTest
public class OptionServiceTest {

  @Mock
  private OptionMapper optionMapper;

  @InjectMocks
  private OptionService optionService;

  @Test
  public void addOption(OptionDTO testOptionDTO) {
    given(optionMapper.insertOption(testOptionDTO)).willReturn(1);
    assertThat(optionService.addOption(testOptionDTO)).isEqualTo(true);
  }

}
