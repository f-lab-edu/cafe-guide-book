package com.flab.cafeguidebook.enumeration.handler;

import com.flab.cafeguidebook.enumeration.MenuStatus;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class MenuStatusTypeHandler implements TypeHandler<MenuStatus> {

  private Class<MenuStatus> type;

  public MenuStatusTypeHandler(Class<MenuStatus> type) {
    this.type = type;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, MenuStatus parameter, JdbcType jdbcType)
      throws SQLException {
    if (parameter == null) {
      ps.setNull(i, jdbcType.TYPE_CODE);
    } else {
      ps.setInt(i, parameter.getCode());
    }
  }

  @Override
  public MenuStatus getResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return getMenuStatus(code);
  }

  @Override
  public MenuStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return getMenuStatus(code);
  }

  @Override
  public MenuStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return getMenuStatus(code);
  }

  private MenuStatus getMenuStatus(int code) {
    try {
      MenuStatus[] enumConstants = (MenuStatus[]) type.getEnumConstants();
      for (MenuStatus menuStatus : enumConstants) {
        if (menuStatus.getCode() == code) {
          return menuStatus;
        }
      }
      return null;
    } catch (Exception e) {
      throw new TypeException("Can't make enum object '" + type + "'", e);
    }
  }
}
