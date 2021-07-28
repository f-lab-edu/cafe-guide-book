package com.flab.cafeguidebook.extension;

import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.dto.UserDTO;
import com.flab.cafeguidebook.enumeration.UserType;
import org.junit.jupiter.api.extension.RegisterExtension;

public class UserExtension {

  @RegisterExtension
  public static User testUser = User.builder()
      .email("yssj2049@gmail.com")
      .password("Cafe1234!")
      .name("김민성")
      .phone("010-8358-2049")
      .address("경기도 화성시 호수공원")
      .userType(UserType.USER)
      .build();

  @RegisterExtension
  public static UserDTO testUserDto = UserDTO.builder()
      .email("yssj2049@gmail.com")
      .password("Cafe1234!")
      .name("김민성")
      .phone("010-8358-2049")
      .address("경기도 화성시 호수공원")
      .userType(UserType.USER)
      .build();

}
