package com.flab.cafeguidebook.converter;

import com.flab.cafeguidebook.domain.Option;
import com.flab.cafeguidebook.dto.OptionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class OptionConverter {

  @Component
  public static class OptionDTOToOptionConverter implements Converter<OptionDTO, Option> {

    @Override
    public Option convert(OptionDTO optionDTO) {
      Option option = new Option(optionDTO.getOptionId(), optionDTO.getOptionName(), optionDTO.getMenuId(),
          optionDTO.getOptionPrice(), optionDTO.getOptionStatus());
      return option;
    }
  }

  @Component
  public static class OptionToOptionDTOConverter implements Converter<Option, OptionDTO> {

    @Override
    public OptionDTO convert(Option option) {
      OptionDTO optionDTO = new OptionDTO(option.getOptionId(), option.getOptionName(), option.getMenuId(),
          option.getOptionPrice(), option.getOptionStatus());
      return optionDTO;
    }
  }

}
