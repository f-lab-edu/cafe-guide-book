package com.flab.cafeguidebook.enumeration;

import com.flab.cafeguidebook.enumeration.handler.MenuGroupTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum MenuGroup {
  DRINK(0), DESSERT(1);

  private final int code;

  MenuGroup(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  @MappedTypes(MenuGroup.class)
  public static class TypeHandler extends MenuGroupTypeHandler {

    public TypeHandler() {
      super(MenuGroup.class);
    }
  }

}
