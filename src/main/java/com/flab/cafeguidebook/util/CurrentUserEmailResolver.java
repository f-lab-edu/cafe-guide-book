package com.flab.cafeguidebook.util;

import com.flab.cafeguidebook.annotation.CurrentUserEmail;
import com.flab.cafeguidebook.service.UserService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserEmailResolver implements HandlerMethodArgumentResolver {

  private final UserService userService;

  public CurrentUserEmailResolver(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    return methodParameter.hasParameterAnnotation(CurrentUserEmail.class);
  }

  @Override
  public Object resolveArgument(MethodParameter methodParameter,
      ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest,
      WebDataBinderFactory webDataBinderFactory) throws Exception {
    String currentUserId = userService.getCurrentUser();
    return currentUserId;
  }
}
