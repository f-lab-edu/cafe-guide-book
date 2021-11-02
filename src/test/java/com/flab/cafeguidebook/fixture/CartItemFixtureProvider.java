package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.domain.CartItem;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CartItemFixtureProvider implements ParameterResolver {

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return (parameterContext.getParameter().getType() == CartItem.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return CartItem.builder()
        .id(38L)
        .name("아이스 아메리카노")
        .price(4000L)
        .cafeId(255233324L)
        .menuId(4535L)
        .count(8732L)
        .userId(3332L)
        .build();
  }
}
