package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.domain.Cafe;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CafeFixtureProvider implements ParameterResolver {

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return (parameterContext.getParameter().getType() == Cafe.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return Cafe.builder()
        .userId("testId")
        .cafeId("testCafeId1")
        .cafeName("testId의 첫번째 카페")
        .tel("010-1234-5678")
        .build();
  }
}
