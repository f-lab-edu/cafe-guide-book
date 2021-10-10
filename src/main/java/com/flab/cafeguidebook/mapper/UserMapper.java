package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  int insertUser(UserDTO userDTO);

  UserDTO selectUserByEmail(String email);

  User selectUserById(Long userId);

  UserDTO getUserInfo(String email);

  UserDTO selectUserByEmailAndPassword(String email, String password);

  int deleteUser(String email);

  int updatePassword(String email, String newPassword);
}
