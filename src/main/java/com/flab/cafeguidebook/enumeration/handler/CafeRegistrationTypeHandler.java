package com.flab.cafeguidebook.enumeration.handler;

import com.flab.cafeguidebook.enumeration.CafeRegistration;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class CafeRegistrationTypeHandler implements TypeHandler<CafeRegistration> {

  private Class<CafeRegistration> type;

  public CafeRegistrationTypeHandler(Class<CafeRegistration> type) {
    this.type = type;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, CafeRegistration parameter,
      JdbcType jdbcType) throws SQLException {
    if (parameter == null) {
      ps.setNull(i, jdbcType.TYPE_CODE);
    } else {
      ps.setInt(i, parameter.getCode());
    }
  }

  @Override
  public CafeRegistration getResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return getCafeRegistration(code);
  }

  @Override
  public CafeRegistration getResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return getCafeRegistration(code);
  }

  @Override
  public CafeRegistration getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return getCafeRegistration(code);
  }

  private CafeRegistration getCafeRegistration(int code) {
    try {
      CafeRegistration[] enumConstants = (CafeRegistration[]) type.getEnumConstants();
      for (CafeRegistration cafeRegistration : enumConstants) {
        if (cafeRegistration.getCode() == code) {
          return cafeRegistration;
        }
      }
      return null;
    } catch (Exception e) {
      throw new TypeException("Can't make enum object '" + type + "'", e);
    }
  }
}

