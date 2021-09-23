package com.flab.cafeguidebook.enumeration;

import com.flab.cafeguidebook.enumeration.handler.CafeRegistrationTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum CafeRegistration {
  PENDING(0), DENY(1), APPROVAL(2);

  private final int code;

  CafeRegistration(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  @MappedTypes(CafeRegistration.class)
  public static class TypeHandler extends CafeRegistrationTypeHandler {

    public TypeHandler() {
      super(CafeRegistration.class);
    }
  }
}
