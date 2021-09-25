package com.flab.cafeguidebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.converter.OptionConverter.OptionDTOToOptionConverter;
import com.flab.cafeguidebook.domain.Option;
import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.fixture.OptionDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.OptionDTOListFixtureProvider;
import com.flab.cafeguidebook.fixture.OptionFixtureProvider;
import com.flab.cafeguidebook.mapper.OptionMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, OptionDTOFixtureProvider.class, OptionFixtureProvider.class,
    OptionDTOListFixtureProvider.class})
@SpringBootTest
public class OptionServiceTest {

  @Mock
  private OptionMapper optionMapper;

  @Mock
  private OptionDTOToOptionConverter optionDTOToOptionConverter;

  @InjectMocks
  private OptionService optionService;

  @Test
  public void addOption(OptionDTO testOptionDTO, Option testOption) {
    when(optionDTOToOptionConverter.convert(testOptionDTO)).thenReturn(testOption);
    given(optionMapper.insertOption(testOption)).willReturn(1);
    assertThat(optionService.addOption(testOptionDTO)).isEqualTo(true);
  }

  @Test
  public void updateOption(OptionDTO testOptionDTO, Option testOption) {
    when(optionDTOToOptionConverter.convert(testOptionDTO)).thenReturn(testOption);
    given(optionMapper.updateOption(testOption)).willReturn(1);
    assertThat(optionService.updateOption(testOptionDTO)).isEqualTo(true);
  }

  @Test
  public void selectAllOption(List<OptionDTO> testOptionDTOList) {
    given(optionMapper.selectAllOption(testOptionDTOList.get(0).getMenuId())).willReturn(testOptionDTOList);
    assertThat(optionService.getAllOption(testOptionDTOList.get(0).getMenuId())).isEqualTo(testOptionDTOList);
  }

  @Test
  public void selectOption(OptionDTO testOptionDTO) {
    given(optionMapper.selectOption(testOptionDTO.getOptionId())).willReturn(testOptionDTO);
    assertThat(optionService.getOption(testOptionDTO.getOptionId())).isEqualTo(testOptionDTO);
  }

  @Test
  public void deleteOption(OptionDTO testOptionDTO) {
    given(optionMapper.deleteOption(testOptionDTO.getOptionId())).willReturn(1);
    assertThat(optionService.deleteOption(testOptionDTO.getOptionId())).isEqualTo(true);
  }

}
