package com.flab.cafeguidebook.controller;

import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentRequest;
import static com.flab.cafeguidebook.util.ApiDocumentUtils.getDocumentResponse;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.CafeDTOListFixtureProvider;
import com.flab.cafeguidebook.mapper.CafeMapper;
import com.flab.cafeguidebook.util.SessionKeys;
import java.util.List;
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

@ExtendWith({SpringExtension.class, CafeDTOFixtureProvider.class, CafeDTOListFixtureProvider.class, RestDocumentationExtension.class})
@SpringBootTest
public class CafeControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private CafeMapper cafeMapper;

  @BeforeEach
  public void init(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();
  }

  @BeforeEach
  public void deleteAllCafe() {
    cafeMapper.deleteAllCafe();
  }

  @Test
  public void addCafe(CafeDTO testCafeDTO) throws Exception {

    String content = objectMapper.writeValueAsString(testCafeDTO);

    mockMvc.perform(RestDocumentationRequestBuilders.post("/owner/cafe/")
        .sessionAttr(SessionKeys.USER_ID, testCafeDTO.getUserId())
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("add-cafe",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
                fieldWithPath("cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("bizNumber").type(JsonFieldType.STRING).description("????????? ????????????").optional(),
                fieldWithPath("tel").type(JsonFieldType.STRING).description("?????? ????????????").optional(),
                fieldWithPath("addressCode").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("addressDetail").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("operatingTime").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("cafeInfo").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("socialMedia").type(JsonFieldType.STRING).description("SNS ??????").optional(),
                fieldWithPath("wifi").type(JsonFieldType.BOOLEAN).description("???????????? ??????").optional(),
                fieldWithPath("reservation").type(JsonFieldType.BOOLEAN).description("?????? ?????? ??????").optional(),
                fieldWithPath("parkingSpace").type(JsonFieldType.BOOLEAN).description("????????? ??????").optional(),
                fieldWithPath("noKidsZone").type(JsonFieldType.BOOLEAN).description("????????????").optional(),
                fieldWithPath("withPet").type(JsonFieldType.BOOLEAN).description("???????????? ?????? ??????").optional()
            )
        ));
  }

  @Test
  public void getMyAllCafe(List<CafeDTO> testCafeDTOList) throws Exception {
    for (int i = 0; i < testCafeDTOList.size(); i++) {
      addCafe(testCafeDTOList.get(i));
    }

    mockMvc.perform(RestDocumentationRequestBuilders.get("/owner/cafe/")
        .sessionAttr(SessionKeys.USER_ID, testCafeDTOList.get(0).getUserId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andDo(print())
        .andDo(document("get-all-cafe",
            getDocumentResponse(),
            responseFields(
                fieldWithPath("[].userId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("[].cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("[].cafeName").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("[].bizNumber").type(JsonFieldType.STRING).description("????????? ????????????").optional(),
                fieldWithPath("[].tel").type(JsonFieldType.STRING).description("?????? ????????????").optional(),
                fieldWithPath("[].addressCode").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("[].addressDetail").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("[].operatingTime").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("[].cafeInfo").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("[].socialMedia").type(JsonFieldType.STRING).description("SNS ??????").optional(),
                fieldWithPath("[].wifi").type(JsonFieldType.BOOLEAN).description("???????????? ??????").optional(),
                fieldWithPath("[].reservation").type(JsonFieldType.BOOLEAN).description("?????? ?????? ??????").optional(),
                fieldWithPath("[].parkingSpace").type(JsonFieldType.BOOLEAN).description("????????? ??????").optional(),
                fieldWithPath("[].noKidsZone").type(JsonFieldType.BOOLEAN).description("????????????").optional(),
                fieldWithPath("[].withPet").type(JsonFieldType.BOOLEAN).description("???????????? ?????? ??????").optional()
            )));
  }

  @Test
  public void updateCafe(CafeDTO testCafeDTO) throws Exception {

    addCafe(testCafeDTO);

    String content = objectMapper.writeValueAsString(testCafeDTO);

    mockMvc.perform(RestDocumentationRequestBuilders.patch("/owner/cafe/" + testCafeDTO.getCafeId())
        .sessionAttr(SessionKeys.USER_ID, testCafeDTO.getUserId())
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(content)
        .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("update-cafe",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
                fieldWithPath("cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeName").type(JsonFieldType.STRING).description("?????? ??????"),
                fieldWithPath("bizNumber").type(JsonFieldType.STRING).description("????????? ????????????").optional(),
                fieldWithPath("tel").type(JsonFieldType.STRING).description("?????? ????????????").optional(),
                fieldWithPath("addressCode").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("addressDetail").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("operatingTime").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("cafeInfo").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("socialMedia").type(JsonFieldType.STRING).description("SNS ??????").optional(),
                fieldWithPath("wifi").type(JsonFieldType.BOOLEAN).description("???????????? ??????").optional(),
                fieldWithPath("reservation").type(JsonFieldType.BOOLEAN).description("?????? ?????? ??????").optional(),
                fieldWithPath("parkingSpace").type(JsonFieldType.BOOLEAN).description("????????? ??????").optional(),
                fieldWithPath("noKidsZone").type(JsonFieldType.BOOLEAN).description("????????????").optional(),
                fieldWithPath("withPet").type(JsonFieldType.BOOLEAN).description("???????????? ?????? ??????").optional()
            ),
            responseFields(
                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeId").type(JsonFieldType.NUMBER).description("?????? ?????????").optional(),
                fieldWithPath("cafeName").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("bizNumber").type(JsonFieldType.STRING).description("????????? ????????????").optional(),
                fieldWithPath("tel").type(JsonFieldType.STRING).description("?????? ????????????").optional(),
                fieldWithPath("addressCode").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("addressDetail").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("operatingTime").type(JsonFieldType.STRING).description("?????? ?????? ??????").optional(),
                fieldWithPath("cafeInfo").type(JsonFieldType.STRING).description("?????? ??????").optional(),
                fieldWithPath("socialMedia").type(JsonFieldType.STRING).description("SNS ??????").optional(),
                fieldWithPath("wifi").type(JsonFieldType.BOOLEAN).description("???????????? ??????").optional(),
                fieldWithPath("reservation").type(JsonFieldType.BOOLEAN).description("?????? ?????? ??????").optional(),
                fieldWithPath("parkingSpace").type(JsonFieldType.BOOLEAN).description("????????? ??????").optional(),
                fieldWithPath("noKidsZone").type(JsonFieldType.BOOLEAN).description("????????????").optional(),
                fieldWithPath("withPet").type(JsonFieldType.BOOLEAN).description("???????????? ?????? ??????").optional()
            )
        ));
  }

}
