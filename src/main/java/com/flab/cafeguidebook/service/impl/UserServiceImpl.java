package com.flab.cafeguidebook.service.impl;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.exception.UserNotFoundException;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.UserService;
import com.flab.cafeguidebook.util.HashingUtil;
import com.flab.cafeguidebook.util.SessionKeys;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;
  private final HttpSession httpSession;

  public UserServiceImpl(UserMapper userMapper, HttpSession httpSession) {
    this.userMapper = userMapper;
    this.httpSession = httpSession;
  }

  @Override
  public boolean signUp(UserDTO userDTO) {
    userDTO.setPassword(HashingUtil.sha256Hashing(userDTO.getPassword()));
    return (userMapper.insertUser(userDTO) == 1);
  }

  @Override
  public boolean isDuplicatedEmail(String email) {
    return userMapper.selectUserByEmail(email) != null;
  }

  @Override
  public UserDTO getUserInfo(String email) {
    UserDTO foundedUser = userMapper.getUserInfo(email);
    if (foundedUser == null) {
      throw new UserNotFoundException("존재하지 않는 회원입니다.");
    }
    return foundedUser;
  }

  @Override
  public void signIn(String email, String password) {
    UserDTO loginedUser = userMapper
        .selectUserByEmailAndPassword(email, HashingUtil.sha256Hashing(password));

    if (loginedUser == null) {
      throw new UserNotFoundException("이메일 혹은 비밀번호가 잘못되었습니다.");
    }

    httpSession.setAttribute(SessionKeys.USER_ID, loginedUser.getEmail());
  }

  @Override
  public boolean deleteUser(String email) {
    return userMapper.deleteUser(email) == 1;
  }

  @Override
  public void signOut() {
    if (httpSession.getAttribute(SessionKeys.USER_ID) != null) {
      httpSession.removeAttribute(SessionKeys.USER_ID);
    }
  }

  @Override
  public Long getSignInUserId() {
    return (Long) httpSession.getAttribute(SessionKeys.USER_ID);
  }

  @Override
  public boolean updatePassword(String email, String newPassword) {
    return userMapper.updatePassword(email, HashingUtil.sha256Hashing(newPassword)) == 1;
  }
}
