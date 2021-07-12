package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  public void signUp(UserDTO userDTO);
}
