package com.flab.cafeguidebook.controller;

import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentRequest;
import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.fixture.MenuDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.OptionDTOFixtureProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({SpringExtension.class, MenuDTOFixtureProvider.class, OptionDTOFixtureProvider.class,
    RestDocumentationExtension.class})
@SpringBootTest
public class MenuControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void init(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();
  }

  @Test
  public void addMenu(MenuDTO testMenuDTO) throws Exception {

    String content = objectMapper.writeValueAsString(testMenuDTO);

    mockMvc.perform(
        RestDocumentationRequestBuilders.post("/owner/cafe/" + testMenuDTO.getCafeId() + "/menu")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(content)
            .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("add-menu",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("menuId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("menuName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("menuPrice").type(JsonFieldType.NUMBER).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuPhoto").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuInfo").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuPriority").type(JsonFieldType.NUMBER).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("createMenuDate").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("updateMenuDate").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("menuGroup").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuStatus").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional()
            )
        ));
  }

  @Test
  public void addOption(OptionDTO testOptionDTO) throws Exception {

    final long CAFEID = 1;

    String content = objectMapper.writeValueAsString(testOptionDTO);

    mockMvc.perform(
        RestDocumentationRequestBuilders.post("/owner/cafe/" + CAFEID + "/menu/" + testOptionDTO.getMenuId() + "/options/")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(content)
            .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("add-option",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("optionId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("menuId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("optionName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("optionPrice").type(JsonFieldType.NUMBER).description("?????? ??????")
                    .optional(),
                fieldWithPath("optionStatus").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional()
            )
        ));
  }

  @Test
  public void updateMenu(MenuDTO testMenuDTO) throws Exception {

    String content = objectMapper.writeValueAsString(testMenuDTO);

    mockMvc.perform(
        RestDocumentationRequestBuilders.post("/owner/cafe/" + testMenuDTO.getCafeId() + "/menu/" + testMenuDTO.getMenuId())
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(content)
            .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("update-menu",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("menuId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("menuName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("menuPrice").type(JsonFieldType.NUMBER).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuPhoto").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuInfo").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuPriority").type(JsonFieldType.NUMBER).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("createMenuDate").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("updateMenuDate").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("menuGroup").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuStatus").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional()
            ),
            responseFields(
                fieldWithPath("menuId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("menuName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("menuPrice").type(JsonFieldType.NUMBER).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuPhoto").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuInfo").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuPriority").type(JsonFieldType.NUMBER).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("createMenuDate").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("updateMenuDate").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                    .optional(),
                fieldWithPath("menuGroup").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional(),
                fieldWithPath("menuStatus").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional()
            )
        ));
  }

  @Test
  public void updateOption(OptionDTO testOptionDTO) throws Exception {

    final long CAFEID = 1;

    String content = objectMapper.writeValueAsString(testOptionDTO);

    mockMvc.perform(
        RestDocumentationRequestBuilders.post("/owner/cafe/" + CAFEID + "/menu/" + testOptionDTO.getMenuId() + "/options/" + testOptionDTO
            .getOptionId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(testOptionDTO))
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("update-option",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("optionId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("menuId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("optionName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("optionPrice").type(JsonFieldType.NUMBER).description("?????? ??????")
                    .optional(),
                fieldWithPath("optionStatus").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional()
            ),
            responseFields(
                fieldWithPath("optionId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("menuId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("optionName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("optionPrice").type(JsonFieldType.NUMBER).description("?????? ??????")
                    .optional(),
                fieldWithPath("optionStatus").type(JsonFieldType.STRING).description("?????? ??????")
                    .optional()
            )
        ));
  }
}
