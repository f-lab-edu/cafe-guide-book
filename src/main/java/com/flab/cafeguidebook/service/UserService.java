package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  public boolean signUp(UserDTO userDTO);

  UserDTO getUserInfo(String email);
}
