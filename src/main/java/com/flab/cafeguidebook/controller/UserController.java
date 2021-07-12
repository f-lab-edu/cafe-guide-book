package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  public UserController() {
  }

  @PostMapping("/signUp")
  @ResponseStatus(HttpStatus.CREATED)
  public void signUp(@RequestBody UserDTO userDTO) {
    userService.signUp(userDTO);
  }
}
