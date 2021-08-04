package com.flab.cafeguidebook.domain;

import com.flab.cafeguidebook.enumeration.UserType;

public class User {

  private String email;
  private String password;
  private String name;
  private String phone;
  private String address;
  private UserType userType;

  public User(Builder builder) {
    this.email = builder.email;
    this.password = builder.password;
    this.name = builder.name;
    this.phone = builder.phone;
    this.address = builder.address;
    this.userType = builder.userType;
  }

  public User(String email, String password, String name, String phone, String address,
      UserType userType) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.userType = userType;
  }

  public static Builder builder() {
    return new Builder();
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

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder userType(UserType userType) {
      this.userType = userType;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }
}
