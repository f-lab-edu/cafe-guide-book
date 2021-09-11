package com.flab.cafeguidebook.aop;

import com.flab.cafeguidebook.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Aspect
@Component
public class LoginCheckAspect {

  private final UserService userService;

  public LoginCheckAspect(UserService userService) {
    this.userService = userService;
  }

  @Before("@annotation(com.flab.cafeguidebook.annotation.LoginCheck)")
  public void loginCheck() throws HttpClientErrorException {
    String userEmail = userService.getCurrentUser();
    if (userEmail == null) {
      throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
    }
  }
}
