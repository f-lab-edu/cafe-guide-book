package com.flab.cafeguidebook.dto;

import com.flab.cafeguidebook.enumeration.UserType;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDTO {

  @NotNull(message = "이메일을 반드시 입력해야 합니다.")
  @Email(message = "유효하지 않은 이메일 형식입니다.")
  private String email;

  @Pattern(regexp = "(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{8,20}",
      message = "영문, 숫자, 특수문자를 반드시 포함하여 8~20자리를 입력해주세요.")
  private String password;

  @NotNull(message = "이름을 반드시 입력해야 합니다.")
  private String name;

  @NotNull(message = "휴대푠 번호를 반드시 입력해야 합니다.")
  private String phone;

  @NotNull(message = "주소를 반드시 입력해야 합니다.")
  private String address;

  @NotNull(message = "유저 타입을 반드시 지정해야 합니다.")
  private UserType userType;

  public UserDTO(Builder builder){
  }

  public static class Builder {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private UserType userType;

    public Builder Builder() {
      return this;
    }

    public UserDTO.Builder email(String email) {
      this.email = email;
      return this;
    }

    public UserDTO.Builder password(String password) {
      this.password = password;
      return this;
    }

    public UserDTO.Builder name(String name) {
      this.name = name;
      return this;
    }

    public UserDTO.Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public UserDTO.Builder address(String address) {
      this.address = address;
      return this;
    }

    public UserDTO.Builder userType(UserType userType) {
      this.userType = userType;
      return this;
    }

    public UserDTO build() {
      return new UserDTO(this);
    }
  }

  public UserDTO(String id, String password, String email, String phone, String name, String address, UserType userType) {
    this.password = password;
    this.email = email;
    this.phone = phone.replaceAll("-", "");;
    this.name = name;
    this.address = address;
    this.userType = userType;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

}
