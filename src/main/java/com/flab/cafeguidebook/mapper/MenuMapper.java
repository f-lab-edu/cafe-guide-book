package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int insertMenu(Menu menu);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int updateMenu(Menu menu);
}
