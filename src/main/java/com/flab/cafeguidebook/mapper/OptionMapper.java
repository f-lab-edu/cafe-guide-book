package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Option;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper {

  public int insertOption(Option optionDTO);

  public int updateOption(Option optionDTO);
}
