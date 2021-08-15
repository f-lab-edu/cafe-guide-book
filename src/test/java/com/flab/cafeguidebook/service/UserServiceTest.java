package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.extension.UserDTOFixtureProvider;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.impl.UserServiceImpl;
import com.flab.cafeguidebook.util.HashingUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, UserDTOFixtureProvider.class})
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
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
}
