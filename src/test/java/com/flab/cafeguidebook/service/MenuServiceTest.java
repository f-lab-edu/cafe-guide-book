package com.flab.cafeguidebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.fixture.MenuDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, MenuDTOFixtureProvider.class})
@SpringBootTest
public class MenuServiceTest {

  @Mock
  private MenuMapper menuMapper;

  @InjectMocks
  private MenuService menuService;

  @Test
  public void addMenu(MenuDTO testMenuDTO) {
    given(menuMapper.insertMenu(testMenuDTO)).willReturn(1);
    assertThat(menuService.addMenu(testMenuDTO)).isEqualTo(true);
  }

}
