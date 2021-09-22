package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.fixture.CafeDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.UserDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.HeartMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, UserDTOFixtureProvider.class, CafeDTOFixtureProvider.class})
@SpringBootTest
public class HeartServiceTest {

  @Mock
  private HeartMapper heartMapper;

  @InjectMocks
  private HeartService heartService;

  @Test
  @DisplayName("이메일, 비밀번호, 이름, 휴대폰번호, 주소, 유저타입이 입력된 경우 회원가입 성공")
  public void addHeartSuccess(UserDTO user, CafeDTO cafe) {
    when(heartMapper.insertHeart(user.getId(), cafe.getCafeId())).thenReturn(1);
    assertTrue(heartService.addHeart(user.getId(), cafe.getCafeId()));

    verify(heartMapper).insertHeart(user.getId(), cafe.getCafeId());
  }


  @Test
  @DisplayName("이메일, 비밀번호, 이름, 휴대폰번호, 주소, 유저타입이 입력된 경우 회원가입 성공")
  public void removeHeartSuccess(UserDTO user, CafeDTO cafe) {
    when(heartMapper.deleteHeart(user.getId(), cafe.getCafeId())).thenReturn(1);
    assertTrue(heartService.removeHeart(user.getId(), cafe.getCafeId()));

    verify(heartMapper).deleteHeart(user.getId(), cafe.getCafeId());
  }
}
