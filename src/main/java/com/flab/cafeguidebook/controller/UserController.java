package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.annotation.SignInCheck;
import com.flab.cafeguidebook.domain.UserSignInRequest;
import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.exception.DuplicatedEmailException;
import com.flab.cafeguidebook.service.UserService;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private static final Logger LOGGER = LogManager.getLogger(UserController.class);

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  public UserController() {
  }

  @PostMapping(value = "/signUp")
  @ResponseStatus(HttpStatus.CREATED)
  public void signUp(@Valid @RequestBody UserDTO userDTO) {
    if (userService.isDuplicatedEmail(userDTO.getEmail())) {
      throw new DuplicatedEmailException();
    }
    userService.signUp(userDTO);
  }

  @GetMapping("{email}")
  @SignInCheck
  public UserDTO userInfo(@PathVariable String email) {
    return userService.getUserInfo(email);
  }

  @PostMapping(value = "/signIn")
  public void signIn(@RequestBody UserSignInRequest loginRequest) {
    userService.signIn(loginRequest.getEmail(), loginRequest.getPassword());
  }

  @GetMapping(value = "/emails/{email}")
  public String getRegisteredEmail(@PathVariable String email) {
    return userService.getUserInfo(email).getEmail();
  }

  @GetMapping(value = "/signOut")
  @SignInCheck
  public void signOut() {
    userService.signOut();
  }

  @PatchMapping("/password")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @SignInCheck
  public void updatePassword(String email, String newPassword) {
    userService.updatePassword(email, newPassword);
  }

  @DeleteMapping(value = "/{email}")
  @SignInCheck
  public void withdrawal(@PathVariable String email) {
    userService.deleteUser(email);
  }
}
