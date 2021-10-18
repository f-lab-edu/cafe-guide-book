package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.converter.MenuConverter.MenuDTOToMenuConverter;
import com.flab.cafeguidebook.converter.MenuConverter.MenuToMenuDTOConverter;
import com.flab.cafeguidebook.domain.Menu;
import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.mapper.MenuMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  @Autowired
  private MenuDTOToMenuConverter menuDTOToMenuConverter;

  @Autowired
  MenuToMenuDTOConverter menuToMenuDTOConverter;

  @Autowired
  private MenuMapper menuMapper;

  public boolean addMenu(MenuDTO menuDTO) {
    int insertMenu = menuMapper.insertMenu(menuDTOToMenuConverter.convert(menuDTO));
    return insertMenu == 1;
  }

  public boolean updateMenu(MenuDTO menuDTO) {
    int updateMenu = menuMapper.updateMenu(menuDTOToMenuConverter.convert(menuDTO));
    return updateMenu == 1;
  }

  public List<MenuDTO> getAllMenu(long cafeId) {
    List<MenuDTO> selectAllMenu = menuMapper.selectAllMenu(cafeId);
    return selectAllMenu;
  }

  public MenuDTO getMenu(long menuId) {
    MenuDTO selectMenu = menuMapper.selectMenu(menuId);
    return selectMenu;
  }

  public boolean deleteMenu(long menuId) {
    int deleteMenu = menuMapper.deleteMenu(menuId);
    return deleteMenu == 1;
  }
}
