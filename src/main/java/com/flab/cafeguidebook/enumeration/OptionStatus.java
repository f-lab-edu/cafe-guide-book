package com.flab.cafeguidebook.enumeration;

import com.flab.cafeguidebook.enumeration.handler.OptionStatusTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum OptionStatus {
  SALE(0), HIDDEN(1), SOLDOUT(2);

  private final int code;

  OptionStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  @MappedTypes(OptionStatus.class)
  public static class TypeHandler extends OptionStatusTypeHandler {

    public TypeHandler() {
      super(OptionStatus.class);
    }
  }
}
