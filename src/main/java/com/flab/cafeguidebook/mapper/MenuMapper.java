package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

  public int insertMenu(MenuDTO menuDTO);

  public int updateMenu(MenuDTO menuDTO);
}
