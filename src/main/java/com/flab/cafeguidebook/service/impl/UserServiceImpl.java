package com.flab.cafeguidebook.service.impl;

import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.mapper.UserMapper;
import com.flab.cafeguidebook.service.UserService;
import com.flab.cafeguidebook.util.HashingUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // TODO : 이메일 중복체크 기능 추가 예정
    @Override
    public boolean signUp(UserDTO userDTO) {
        userDTO.setPassword(HashingUtil.sha256Hashing(userDTO.getPassword()));
        return (userMapper.insertUser(userDTO) == 1);
    }
}
