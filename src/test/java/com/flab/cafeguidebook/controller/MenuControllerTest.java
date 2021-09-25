package com.flab.cafeguidebook.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.fixture.MenuDTOListFixtureProvider;
import com.flab.cafeguidebook.fixture.MenuDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.OptionDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.OptionDTOListFixtureProvider;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({SpringExtension.class, MenuDTOFixtureProvider.class, OptionDTOFixtureProvider.class,
    MenuDTOListFixtureProvider.class, OptionDTOListFixtureProvider.class})
@SpringBootTest
public class MenuControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void init() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void addMenu(MenuDTO testMenuDTO) throws Exception {

    String menuGroupEnum = testMenuDTO.getMenuGroup() == null ? null : testMenuDTO.getMenuGroup().toString();
    String menuStatusEnum = testMenuDTO.getMenuStatus() == null ? null : testMenuDTO.getMenuStatus().toString();

    mockMvc.perform(post("/owner/cafe/" + testMenuDTO.getCafeId() + "/menu")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testMenuDTO))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("cafeId").value(testMenuDTO.getCafeId()))
        .andExpect(jsonPath("menuName").value(testMenuDTO.getMenuName()))
        .andExpect(jsonPath("menuPrice").value(testMenuDTO.getMenuPrice()))
        .andExpect(jsonPath("menuGroup").value(menuGroupEnum))
        .andExpect(jsonPath("menuStatus").value(menuStatusEnum));
  }

  @Test
  public void addOption(OptionDTO testOptionDTO) throws Exception {

    final long CAFEID = 1;

    String optionStatusEnum = testOptionDTO.getOptionStatus() == null ? null : testOptionDTO.getOptionStatus().toString();

    mockMvc.perform(post("/owner/cafe/" + CAFEID + "/menu/" + testOptionDTO.getMenuId() + "/options/")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(testOptionDTO))
            .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("optionName").value(testOptionDTO.getOptionName()))
        .andExpect(jsonPath("menuId").value(testOptionDTO.getMenuId()))
        .andExpect(jsonPath("optionPrice").value(testOptionDTO.getOptionPrice()))
        .andExpect(jsonPath("optionStatus").value(optionStatusEnum));
  }

  @Test
  public void updateMenu(MenuDTO testMenuDTO) throws Exception {

    final long MENUID = 1;

    testMenuDTO.setMenuId(MENUID);

    String menuGroupEnum = testMenuDTO.getMenuGroup() == null ? null : testMenuDTO.getMenuGroup().toString();
    String menuStatusEnum = testMenuDTO.getMenuStatus() == null ? null : testMenuDTO.getMenuStatus().toString();

    mockMvc.perform(post("/owner/cafe/" + testMenuDTO.getCafeId() + "/menu/" + testMenuDTO.getMenuId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testMenuDTO))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("menuId").value(testMenuDTO.getMenuId()))
        .andExpect(jsonPath("cafeId").value(testMenuDTO.getCafeId()))
        .andExpect(jsonPath("menuName").value(testMenuDTO.getMenuName()))
        .andExpect(jsonPath("menuPrice").value(testMenuDTO.getMenuPrice()))
        .andExpect(jsonPath("menuGroup").value(menuGroupEnum))
        .andExpect(jsonPath("menuStatus").value(menuStatusEnum));
  }

  @Test
  public void updateOption(OptionDTO testOptionDTO) throws Exception {

    final long CAFEID = 1;

    final long MENUID = 1;

    final long OPTIONID = 1;

    testOptionDTO.setMenuId(MENUID);
    testOptionDTO.setOptionId(OPTIONID);

    String optionStatusEnum = testOptionDTO.getOptionStatus() == null ? null : testOptionDTO.getOptionStatus().toString();

    mockMvc.perform(post("/owner/cafe/" + CAFEID + "/menu/" + testOptionDTO.getMenuId() + "/options/" + testOptionDTO
            .getOptionId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testOptionDTO))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("optionId").value(testOptionDTO.getOptionId()))
        .andExpect(jsonPath("optionName").value(testOptionDTO.getOptionName()))
        .andExpect(jsonPath("optionPrice").value(testOptionDTO.getOptionPrice()))
        .andExpect(jsonPath("optionStatus").value(optionStatusEnum));
  }

  @Test
  public void getAllMenu(List<MenuDTO> testMenuDTOList) throws Exception {

    for (int i = 0; i < testMenuDTOList.size(); i++) {
      addMenu(testMenuDTOList.get(i));
    }

    mockMvc.perform(get("/owner/cafe/" + testMenuDTOList.get(0).getCafeId() + "/menu")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(testMenuDTOList.size())));
  }

  @Test
  public void getAllOption(MenuDTO testMenuDTO, List<OptionDTO> testOptionDTOList) throws Exception {

    addMenu(testMenuDTO);

    for (int i = 0; i < testOptionDTOList.size(); i++) {
      addOption(testOptionDTOList.get(i));
    }

    mockMvc.perform(get("/owner/cafe/" + testMenuDTO.getCafeId() + "/menu/" + testOptionDTOList.get(0).getMenuId() + "/options/")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(testOptionDTOList.size())));

  }
}
