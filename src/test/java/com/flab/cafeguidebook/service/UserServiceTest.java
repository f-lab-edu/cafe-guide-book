
package com.flab.cafeguidebook.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.exception.UserNotFoundException;
import com.flab.cafeguidebook.fixture.UserDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.impl.UserServiceImpl;
import com.flab.cafeguidebook.util.HashingUtil;
import com.flab.cafeguidebook.util.SessionKeys;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, UserDTOFixtureProvider.class})
@SpringBootTest
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
    String originalPassword = user.getPassword();
    boolean isSuccess = userService.signUp(user);

    assertEquals(
        HashingUtil.sha256Hashing(originalPassword),
        userMapper.selectUserByEmail(user.getEmail()).getPassword()
    );
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
  @DisplayName("이메일")
  public void isDuplicatedEmailTrue(UserDTO user) {
    when(userMapper.selectUserByEmail(user.getEmail())).thenReturn(user);
    when(userMapper.selectUserByEmail(user.getEmail() + "no-duplicated")).thenReturn(null);

    assertTrue(userService.isDuplicatedEmail(user.getEmail()));
    assertFalse(userService.isDuplicatedEmail(user.getEmail() + "no-duplicated"));

    verify(userMapper).selectUserByEmail(user.getEmail());
  }

  @Test
  @DisplayName("로그아웃 성공")
  public void signOutUserTestWithSuccess(UserDTO user) {
    mockHttpSession.setAttribute(SessionKeys.USER_EMAIL, user.getEmail());
    userService.signOut();
    assertNull(mockHttpSession.getAttribute(SessionKeys.USER_EMAIL));
  }

  @Test
  @DisplayName("비밀번호 변경 성공 단위 테스트")
  public void updatePasswordTestWithSuccess(UserDTO user) {
    when(userMapper.updatePassword(user.getEmail(),
        HashingUtil.sha256Hashing(user.getPassword() + "newPassword")))
        .thenReturn(1);

    assertTrue(userService.updatePassword(user.getEmail(), user.getPassword() + "newPassword"));

    verify(userMapper)
        .updatePassword(user.getEmail(),
            HashingUtil.sha256Hashing(user.getPassword() + "newPassword"));
  }
}
