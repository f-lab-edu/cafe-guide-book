package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.domain.Menu;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class MenuFixtureProvider implements ParameterResolver {

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return (parameterContext.getParameter().getType() == Menu.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return Menu.builder()
        .cafeId(1)
        .menuName("아메리카노")
        .menuPrice(2500)
        .menuPriority(1)
        .build();
  }
}
