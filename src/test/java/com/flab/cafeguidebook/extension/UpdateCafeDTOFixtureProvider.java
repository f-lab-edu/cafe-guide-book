package com.flab.cafeguidebook.extension;

import com.flab.cafeguidebook.dto.UpdateCafeDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UpdateCafeDTOFixtureProvider implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
        return (parameterContext.getParameter().getType() == UpdateCafeDTO.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
        return UpdateCafeDTO.builder()
            .userId("testId")
            .cafeId("testCafeId1")
            .cafeName("testId 카페 이름 변경")
            .build();
    }
}
