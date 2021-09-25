package com.flab.cafeguidebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.converter.MenuConverter.MenuDTOToMenuConverter;
import com.flab.cafeguidebook.domain.Menu;
import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.fixture.MenuDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.MenuDTOListFixtureProvider;
import com.flab.cafeguidebook.fixture.MenuFixtureProvider;
import com.flab.cafeguidebook.mapper.MenuMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, MenuDTOFixtureProvider.class, MenuFixtureProvider.class,
    MenuDTOListFixtureProvider.class})
@SpringBootTest
public class MenuServiceTest {

  @Mock
  private MenuMapper menuMapper;

  @Mock
  private MenuDTOToMenuConverter menuDTOToMenuConverter;

  @InjectMocks
  private MenuService menuService;

  @Test
  public void addMenu(MenuDTO testMenuDTO, Menu testMenu) {
    when(menuDTOToMenuConverter.convert(testMenuDTO)).thenReturn(testMenu);
    given(menuMapper.insertMenu(testMenu)).willReturn(1);
    assertThat(menuService.addMenu(testMenuDTO)).isEqualTo(true);
  }

  @Test
  public void updateMenu(MenuDTO testMenuDTO, Menu testMenu) {
    when(menuDTOToMenuConverter.convert(testMenuDTO)).thenReturn(testMenu);
    given(menuMapper.updateMenu(testMenu)).willReturn(1);
    assertThat(menuService.updateMenu(testMenuDTO)).isEqualTo(true);
  }

  @Test
  public void selectAllMenu(List<MenuDTO> testMenuDTOList) {
    given(menuMapper.selectAllMenu(testMenuDTOList.get(0).getCafeId())).willReturn(testMenuDTOList);
    assertThat(menuService.getAllMenu(testMenuDTOList.get(0).getCafeId())).isEqualTo(testMenuDTOList);
  }

  @Test
  public void selectMenu(MenuDTO testMenuDTO) {
    given(menuMapper.selectMenu(testMenuDTO.getMenuId())).willReturn(testMenuDTO);
    assertThat(menuService.getMenu(testMenuDTO.getMenuId())).isEqualTo(testMenuDTO);
  }
}
