package com.flab.cafeguidebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Email is duplicated")
public class DuplicatedEmailException extends RuntimeException {

  public DuplicatedEmailException() {
  }

  public DuplicatedEmailException(String message) {
    super(message);
  }

  public DuplicatedEmailException(String message, Throwable cause) {
    super(message, cause);
  }

}
