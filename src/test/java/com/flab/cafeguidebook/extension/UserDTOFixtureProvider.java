package com.flab.cafeguidebook.extension;

import com.flab.cafeguidebook.dto.UserDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UserDTOFixtureProvider implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
        return (parameterContext.getParameter().getType() == UserDTO.class);
    }

    // TODO: Mybatis Enum 매핑 기능 추가 예정
    @Override
    public Object resolveParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
        return UserDTO.builder()
            .email("yssj2049@gmail.com")
            .password("Cafe1234!")
            .name("김민성")
            .phone("010-8358-2049")
            .address("경기도 화성시 호수공원")
            .build();
    }
}
