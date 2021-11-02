package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  @DataSource(dataSourceType = DataSourceType.MASTER)
  int insertUser(UserDTO userDTO);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  UserDTO selectUserByEmail(String email);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  UserDTO getUserInfo(String email);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  UserDTO selectUserByEmailAndPassword(String email, String password);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  int deleteUser(String email);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  int updatePassword(String email, String newPassword);
}
