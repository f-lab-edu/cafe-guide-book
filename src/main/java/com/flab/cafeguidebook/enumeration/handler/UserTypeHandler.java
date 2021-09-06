package com.flab.cafeguidebook.enumeration.handler;

import com.flab.cafeguidebook.enumeration.UserType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class UserTypeHandler implements TypeHandler<UserType> {

  private Class<UserType> type;

  public UserTypeHandler(Class<UserType> type) {
    this.type = type;
  }

  public void setParameter(PreparedStatement preparedStatement, int i, UserType type,
      JdbcType jdbcType) throws
      SQLException {
    preparedStatement.setInt(i, type.getCode());
  }

  @Override
  public UserType getResult(ResultSet resultSet, String s) throws SQLException {
    int statusCode = resultSet.getInt(s);
    return getStatus(statusCode);
  }

  @Override
  public UserType getResult(ResultSet resultSet, int i) throws SQLException {
    int statusCode = resultSet.getInt(i);
    return getStatus(statusCode);
  }

  @Override
  public UserType getResult(CallableStatement callableStatement, int i) throws SQLException {
    int statusCode = callableStatement.getInt(i);
    return getStatus(statusCode);
  }

  private UserType getStatus(int statusCode) {
    try {
      UserType[] enumConstants = (UserType[]) type.getEnumConstants();
      for (UserType status : enumConstants) {
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
