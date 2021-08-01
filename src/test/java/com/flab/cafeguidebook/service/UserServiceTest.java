package com.flab.cafeguidebook.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.exception.UserNotFoundException;
import com.flab.cafeguidebook.fixture.UserDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.impl.UserServiceImpl;
import com.flab.cafeguidebook.util.SessionKeys;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;

@ExtendWith({MockitoExtension.class, UserDTOFixtureProvider.class})
class UserServiceTest {

  @Mock
  private UserMapper userMapper;

  @Mock
  private MockHttpSession mockHttpSession;

  @InjectMocks
  private UserServiceImpl userService;


  @Test
  @DisplayName("이메일, 비밀번호, 이름, 휴대폰번호, 주소, 유저타입이 입력된 경우 회원가입 성공")
  public void signUpTestSuccess(UserDTO user) {

    when(userMapper.insertUser(user)).thenReturn(1);

    boolean isSuccess = userService.signUp(user);

    assertTrue(isSuccess);
  }

  @Test
  @DisplayName("이메일, 비밀번호, 이름, 휴대폰번호, 주소, 유저타입이 입력된 경우 회원가입 성공")
  public void signInTestSuccess(UserDTO user) {

    userService.signIn(user.getEmail(), user.getPassword());

    assertThat(mockHttpSession.getAttribute(SessionKeys.USER_EMAIL)).isNotNull();
    assertThat(mockHttpSession.getAttribute(SessionKeys.USER_EMAIL)).isEqualTo(user.getEmail());

  }

  @Test
  @DisplayName("이메일을 잘못 입력시 로그인 실패 및 UserNotFoundException throw")
  public void signInTestFailWithWrongEmail(UserDTO user) {
    assertThrows(UserNotFoundException.class, () -> {
      userService.signIn(user.getEmail() + "Wrong Email", user.getPassword());
    });
  }

  @Test
  @DisplayName("패스워드를 잘못 입력시 로그인 실패 및 UserNotFoundException throw")
  public void signInTestFailWithWrongPassword(UserDTO user) {
    assertThrows(UserNotFoundException.class, () -> {
      userService.signIn(user.getEmail(), user.getPassword() + "Wrong Password");
    });
  }

  @Test
  @DisplayName("로그아웃 성공")
  public void logoutUserTestWithSuccess(UserDTO user) {
    mockHttpSession.setAttribute(SessionKeys.USER_EMAIL, user.getEmail());

    userService.logout();

    assertNull(mockHttpSession.getAttribute(SessionKeys.USER_EMAIL));
  }

}
