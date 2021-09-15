package com.flab.cafeguidebook.aop;

import com.flab.cafeguidebook.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class SignInCheckAspect {

  private final UserService userService;

  public SignInCheckAspect(UserService userService) {
    this.userService = userService;
  }

  @Before("@annotation(com.flab.cafeguidebook.annotation.SignInCheck)")
  public void signInCheck() throws HttpClientErrorException {
    Long userId = userService.getSignInUserId();
    if (userId == null) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
  }
}
