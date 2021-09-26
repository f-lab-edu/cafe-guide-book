package com.flab.cafeguidebook.enumeration.handler;

import com.flab.cafeguidebook.enumeration.CafeCondition;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class CafeConditionTypeHandler implements TypeHandler<CafeCondition> {

  private Class<CafeCondition> type;

  public CafeConditionTypeHandler(Class<CafeCondition> type) {
    this.type = type;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, CafeCondition parameter, JdbcType jdbcType)
      throws SQLException {
    if (parameter == null) {
      ps.setNull(i, jdbcType.TYPE_CODE);
    } else {
      ps.setInt(i, parameter.getCode());
    }
  }

  @Override
  public CafeCondition getResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return getCafeCondition(code);
  }

  @Override
  public CafeCondition getResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return getCafeCondition(code);
  }

  @Override
  public CafeCondition getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return getCafeCondition(code);
  }

  private CafeCondition getCafeCondition(int code) {
    try {
      CafeCondition[] enumConstants = (CafeCondition[]) type.getEnumConstants();
      for (CafeCondition cafeCondition : enumConstants) {
        if (cafeCondition.getCode() == code) {
          return cafeCondition;
        }
      }
      return null;
    } catch (Exception e) {
      throw new TypeException("Can't make enum object '" + type + "'", e);
    }
  }
}
