package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.OptionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper {

  public int insertOption(OptionDTO optionDTO);

  public int updateOption(OptionDTO optionDTO);
}
