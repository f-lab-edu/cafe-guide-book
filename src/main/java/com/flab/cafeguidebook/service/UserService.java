package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public boolean signUp(UserDTO userDTO);

    UserDTO getUserInfo(String email);

    public void signIn(String email, String password);

    public void signOut();
}
