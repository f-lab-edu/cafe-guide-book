package com.flab.cafeguidebook.enumeration;

import com.flab.cafeguidebook.enumeration.handler.UserTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum UserType {
  USER(0), OWNER(1), ADMIN(2);

  private final int code;

  UserType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  @MappedTypes(UserType.class)
  public static class TypeHandler extends UserTypeHandler {

    public TypeHandler() {
      super(UserType.class);
    }
  }
}
