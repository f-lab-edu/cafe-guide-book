package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  @Autowired
  private MenuMapper menuMapper;

  public boolean addMenu(MenuDTO menuDTO) {
    int insertMenu = menuMapper.insertMenu(menuDTO);
    return insertMenu == 1;
  }

  public boolean updateMenu(MenuDTO menuDTO) {
    int updateMenu = menuMapper.updateMenu(menuDTO);
    return updateMenu == 1;
  }
}
