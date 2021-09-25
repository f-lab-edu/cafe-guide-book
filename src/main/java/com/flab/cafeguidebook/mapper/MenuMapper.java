package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Menu;
import com.flab.cafeguidebook.dto.MenuDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

  public int insertMenu(Menu menu);

  public int updateMenu(Menu menu);

  public List<MenuDTO> selectAllMenu(long cafeId);

  public MenuDTO selectMenu(long menuId);
}
