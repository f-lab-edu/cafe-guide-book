package com.flab.cafeguidebook.enumeration.handler;

import com.flab.cafeguidebook.enumeration.MenuGroup;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class MenuGroupTypeHandler implements TypeHandler<MenuGroup> {

  private Class<MenuGroup> type;

  public MenuGroupTypeHandler(Class<MenuGroup> type) {
    this.type = type;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, MenuGroup parameter, JdbcType jdbcType)
      throws SQLException {
    if (parameter == null) {
      ps.setNull(i, jdbcType.TYPE_CODE);
    } else {
      ps.setInt(i, parameter.getCode());
    }
  }

  @Override
  public MenuGroup getResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return getMenuGroup(code);
  }

  @Override
  public MenuGroup getResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return getMenuGroup(code);
  }

  @Override
  public MenuGroup getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return getMenuGroup(code);
  }

  private MenuGroup getMenuGroup(int code) {
    try {
      MenuGroup[] enumConstants = (MenuGroup[]) type.getEnumConstants();
      for (MenuGroup menuGroup : enumConstants) {
        if (menuGroup.getCode() == code) {
          return menuGroup;
        }
      }
      return null;
    } catch (Exception e) {
      throw new TypeException("Can't make enum object '" + type + "'", e);
    }
  }
}
