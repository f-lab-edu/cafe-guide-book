package com.flab.cafeguidebook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.domain.Menu;
import com.flab.cafeguidebook.domain.Option;
import com.flab.cafeguidebook.fixture.CafeFixtureProvider;
import com.flab.cafeguidebook.fixture.MenuFixtureProvider;
import com.flab.cafeguidebook.fixture.OptionFixtureProvider;
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

@ExtendWith({SpringExtension.class, CafeFixtureProvider.class, MenuFixtureProvider.class, OptionFixtureProvider.class})
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
  public void addMenu(Menu testMenu) throws Exception {

    mockMvc.perform(post("/owner/cafe/" + testMenu.getCafeId() + "/menu")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testMenu))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("cafeId").value(testMenu.getCafeId()))
        .andExpect(jsonPath("menuName").value(testMenu.getMenuName()))
        .andExpect(jsonPath("menuPrice").value(testMenu.getMenuPrice()));
  }

  @Test
  public void addOption(Option testOption) throws Exception {

    final long CAFEID = 1;

    mockMvc.perform(post("/owner/cafe/" + CAFEID + "/menu/" + testOption.getMenuId() + "/options/")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testOption))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("optionName").value(testOption.getOptionName()))
        .andExpect(jsonPath("menuId").value(testOption.getMenuId()))
        .andExpect(jsonPath("optionPrice").value(testOption.getOptionPrice()));
  }

  @Test
  public void updateMenu(Menu testMenu) throws Exception {

    final long MENUID = 1;

    testMenu.setMenuId(MENUID);

    mockMvc.perform(post("/owner/cafe/" + testMenu.getCafeId() + "/menu/" + testMenu.getMenuId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testMenu))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("menuId").value(testMenu.getMenuId()))
        .andExpect(jsonPath("cafeId").value(testMenu.getCafeId()))
        .andExpect(jsonPath("menuName").value(testMenu.getMenuName()))
        .andExpect(jsonPath("menuPrice").value(testMenu.getMenuPrice()));
  }

  @Test
  public void updateOption(Option testOption) throws Exception {

    final long CAFEID = 1;

    final long MENUID = 1;

    final long OPTIONID = 1;

    testOption.setMenuId(MENUID);
    testOption.setOptionId(OPTIONID);

    mockMvc.perform(post("/owner/cafe/" + CAFEID + "/menu/" + testOption.getMenuId() + "/options/" + testOption.getOptionId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testOption))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("optionId").value(testOption.getOptionId()))
        .andExpect(jsonPath("optionName").value(testOption.getOptionName()))
        .andExpect(jsonPath("optionPrice").value(testOption.getOptionPrice()))
        .andExpect(jsonPath("optionStatus").value(testOption.getOptionStatus()));

  }
}
