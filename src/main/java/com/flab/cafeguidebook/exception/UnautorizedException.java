package com.flab.cafeguidebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "User Not Found")
public class UnautorizedException extends RuntimeException {

  public UnautorizedException() {
  }

  public UnautorizedException(String message) {
    super(message);
  }

  public UnautorizedException(String message, Throwable cause) {
    super(message, cause);
  }

}
