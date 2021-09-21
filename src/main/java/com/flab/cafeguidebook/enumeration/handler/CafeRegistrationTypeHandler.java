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

  public void setParameter(PreparedStatement preparedStatement, int i, CafeRegistration type,
      JdbcType jdbcType) throws
      SQLException {
    preparedStatement.setInt(i, type.getCode());
  }

  @Override
  public CafeRegistration getResult(ResultSet resultSet, String s) throws SQLException {
    int statusCode = resultSet.getInt(s);
    return getStatus(statusCode);
  }

  @Override
  public CafeRegistration getResult(ResultSet resultSet, int i) throws SQLException {
    int statusCode = resultSet.getInt(i);
    return getStatus(statusCode);
  }

  @Override
  public CafeRegistration getResult(CallableStatement callableStatement, int i)
      throws SQLException {
    int statusCode = callableStatement.getInt(i);
    return getStatus(statusCode);
  }

  private CafeRegistration getStatus(int statusCode) {
    try {
      CafeRegistration[] enumConstants = (CafeRegistration[]) type.getEnumConstants();
      for (CafeRegistration status : enumConstants) {
        if (status.getCode() == statusCode) {
          return status;
        }
      }
      return null;
    } catch (Exception exception) {
      throw new TypeException("Can't make enum object '" + type + "'", exception);
    }
  }
}
