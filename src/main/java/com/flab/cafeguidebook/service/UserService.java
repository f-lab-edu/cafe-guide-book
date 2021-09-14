package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  public boolean signUp(UserDTO userDTO);

  public boolean isDuplicatedEmail(String email);

  UserDTO getUserInfo(String email);

  public void signIn(String email, String password);

  public boolean deleteUser(String email);

  public void signOut();

  public String getCurrentUser();

  public boolean updatePassword(String email, String newPassword);
}
