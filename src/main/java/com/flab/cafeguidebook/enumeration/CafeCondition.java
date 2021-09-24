package com.flab.cafeguidebook.enumeration;

import com.flab.cafeguidebook.enumeration.handler.CafeConditionTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum CafeCondition {
  OPEN(0), CLOSE(1);

  private final int code;

  CafeCondition(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  @MappedTypes(CafeCondition.class)
  public static class TypeHandler extends CafeConditionTypeHandler {

    public TypeHandler() {
      super(CafeCondition.class);
    }
  }
}
