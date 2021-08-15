package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @PostMapping(value = "/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody UserDTO userDTO) {
        userService.signUp(userDTO);
    }

    @GetMapping("{email}")
    public UserDTO userInfo(@PathVariable String email) {
        return userService.getUserInfo(email);
    }
}
