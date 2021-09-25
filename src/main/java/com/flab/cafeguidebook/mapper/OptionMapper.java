package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Option;
import com.flab.cafeguidebook.dto.OptionDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper {

  public int insertOption(Option optionDTO);

  public int updateOption(Option optionDTO);

  public List<OptionDTO> selectAllOption(long menuId);

  public OptionDTO selectOption(long optionId);
}
