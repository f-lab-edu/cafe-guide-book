package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.domain.Option;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper {

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int insertOption(Option optionDTO);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int updateOption(Option optionDTO);
}
