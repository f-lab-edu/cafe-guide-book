package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.extension.UserExtension;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class UserServiceTest {

  UserDTO user = UserExtension.testUserDto;

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private UserServiceImpl userService;


  @Test
  @DisplayName("이메일, 비밀번호, 이름, 휴대폰번호, 주소, 유저타입이 입력된 경우 회원가입 성공")
  public void signUpTestSuccess() {

    ArgumentCaptor<UserDTO> valueCapture = ArgumentCaptor.forClass(UserDTO.class);

    doNothing().when(userMapper).insertUser(valueCapture.capture());

    userService.signUp(user);

    verify(userMapper).insertUser(any(UserDTO.class));

    assertTrue(user.getPassword().equals(valueCapture.getValue().getPassword()));

  }
}
