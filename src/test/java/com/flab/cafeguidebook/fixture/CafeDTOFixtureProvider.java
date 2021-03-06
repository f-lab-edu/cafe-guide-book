package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.dto.CafeDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CafeDTOFixtureProvider implements ParameterResolver {

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return (parameterContext.getParameter().getType() == CafeDTO.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return CafeDTO.builder()
        .userId(388291L)
        .cafeId(2341L)
        .cafeName("testId의 첫번째 카페")
        .tel("010-1234-5678")
        .build();
  }
}
