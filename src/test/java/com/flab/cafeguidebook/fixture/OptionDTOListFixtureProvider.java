package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.enumeration.OptionStatus;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class OptionDTOListFixtureProvider implements ParameterResolver {

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    Parameter parameter = parameterContext.getParameter();

    Type type = parameter.getParameterizedType();
    if (type instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType) type;
      if (!parameterizedType.getRawType().equals(List.class)) {
        return false;
      }
      Type firstParameterType = parameterizedType.getActualTypeArguments()[0];
      return firstParameterType.equals(OptionDTO.class);
    }

    return false;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    OptionDTO testOptionDTO1 =  OptionDTO.builder()
        .menuId(1)
        .optionName("아이스")
        .optionPrice(500)
        .optionStatus(OptionStatus.SOLDOUT)
        .build();
    OptionDTO testOptionDTO2 = OptionDTO.builder()
        .menuId(1)
        .optionName("시럽")
        .optionPrice(500)
        .optionStatus(OptionStatus.SOLDOUT)
        .build();
    return Arrays.asList(testOptionDTO1, testOptionDTO2);
  }
}
