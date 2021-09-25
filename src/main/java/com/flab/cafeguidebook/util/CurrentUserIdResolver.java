package com.flab.cafeguidebook.util;

import com.flab.cafeguidebook.annotation.CurrentUserId;
import com.flab.cafeguidebook.service.UserService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserIdResolver implements HandlerMethodArgumentResolver {

  private final UserService userService;

  public CurrentUserIdResolver(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    return methodParameter.hasParameterAnnotation(CurrentUserId.class);
  }

  @Override
  public Object resolveArgument(MethodParameter methodParameter,
      ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest,
      WebDataBinderFactory webDataBinderFactory) throws Exception {
    Long currentUserId = userService.getSignInUserId();
    return currentUserId;
  }
}
