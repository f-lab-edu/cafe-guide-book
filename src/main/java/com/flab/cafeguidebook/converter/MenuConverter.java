package com.flab.cafeguidebook.converter;

import com.flab.cafeguidebook.domain.Menu;
import com.flab.cafeguidebook.dto.MenuDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class MenuConverter {

  @Component
  public static class MenuDTOToMenuConverter implements Converter<MenuDTO, Menu> {

    @Override
    public Menu convert(MenuDTO menuDTO) {
      Menu menu = new Menu(menuDTO.getMenuId(), menuDTO.getCafeId(), menuDTO.getMenuName(),
          menuDTO.getMenuPrice(), menuDTO.getMenuPhoto(), menuDTO.getMenuInfo(),
          menuDTO.getMenuPriority(), menuDTO.getCreateMenuDate(), menuDTO.getUpdateMenuDate(),
          menuDTO.getMenuGroup(), menuDTO.getMenuStatus());
      return menu;
    }
  }

  @Component
  public static class MenuToMenuDTOConverter implements Converter<Menu, MenuDTO> {

    @Override
    public MenuDTO convert(Menu menu) {
      MenuDTO menuDTO = new MenuDTO(menu.getMenuId(), menu.getCafeId(), menu.getMenuName(),
          menu.getMenuPrice(), menu.getMenuPhoto(), menu.getMenuInfo(),
          menu.getMenuPriority(), menu.getCreateMenuDate(), menu.getUpdateMenuDate(),
          menu.getMenuGroup(), menu.getMenuStatus());
      return menuDTO;
    }

  }
}
