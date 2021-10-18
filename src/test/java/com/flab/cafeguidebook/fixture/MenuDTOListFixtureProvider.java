package com.flab.cafeguidebook.fixture;

import com.flab.cafeguidebook.dto.MenuDTO;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class MenuDTOListFixtureProvider implements ParameterResolver {

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
      return firstParameterType.equals(MenuDTO.class);
    }

    return false;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    MenuDTO testMenuDTO1 = MenuDTO.builder()
        .cafeId(5L)
        .menuName("아메리카노")
        .menuPrice(2500)
        .menuPriority(1)
        .build();
    MenuDTO testMenuDTO2 = MenuDTO.builder()
        .cafeId(5L)
        .menuName("카페라떼")
        .menuPrice(3000)
        .menuPriority(2)
        .build();
    return Arrays.asList(testMenuDTO1, testMenuDTO2);
  }
}
