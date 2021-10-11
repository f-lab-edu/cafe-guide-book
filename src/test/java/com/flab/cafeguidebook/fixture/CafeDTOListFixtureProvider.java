package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.dto.CafeDTO;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CafeDTOListFixtureProvider implements ParameterResolver {

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
      return firstParameterType.equals(CafeDTO.class);
    }

    return false;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    CafeDTO testCafeDTO1 = CafeDTO.builder()
        .userId(388291L)
        .cafeName("testId의 첫번째 카페")
        .tel("010-1234-5678")
        .build();
    CafeDTO testCafeDTO2 = CafeDTO.builder()
        .userId(388291L)
        .cafeName("testId의 두번째 카페")
        .tel("010-2345-6789")
        .build();
    return Arrays.asList(testCafeDTO1, testCafeDTO2);
  }
}
