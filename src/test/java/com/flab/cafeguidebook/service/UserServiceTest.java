package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.extension.UserDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class, UserDTOFixtureProvider.class})
class UserServiceTest {

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private UserServiceImpl userService;


  @Test
  @DisplayName("이메일, 비밀번호, 이름, 휴대폰번호, 주소, 유저타입이 입력된 경우 회원가입 성공")
  public void signUpTestSuccess(UserDTO user) {

    when(userMapper.insertUser(user)).thenReturn(1);

    boolean isSuccess = userService.signUp(user);

    assertTrue(isSuccess);
  }
}
