package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  void insertUser(UserDTO userDTO);
}

