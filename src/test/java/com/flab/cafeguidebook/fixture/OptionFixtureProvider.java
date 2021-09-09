package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.domain.Option;
import com.flab.cafeguidebook.enumeration.OptionStatus;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class OptionFixtureProvider implements ParameterResolver {

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return (parameterContext.getParameter().getType() == Option.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return Option.builder()
        .menuId(1)
        .optionName("아이스")
        .optionPrice(500)
        .optionStatus(OptionStatus.HIDDEN)
        .build();
  }
}
