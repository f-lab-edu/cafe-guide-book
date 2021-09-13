package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

  public int insertMenu(Menu menu);

  public int updateMenu(Menu menu);
}
