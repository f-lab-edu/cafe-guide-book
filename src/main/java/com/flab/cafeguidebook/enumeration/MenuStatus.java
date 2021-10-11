package com.flab.cafeguidebook.enumeration;

import com.flab.cafeguidebook.enumeration.handler.MenuStatusTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum MenuStatus {
  SALE(0), HIDDEN(1), SOLDOUT(2);

  private final int code;

  MenuStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  @MappedTypes(MenuStatus.class)
  public static class TypeHandler extends MenuStatusTypeHandler {

    public TypeHandler() {
      super(MenuStatus.class);
    }
  }
}
