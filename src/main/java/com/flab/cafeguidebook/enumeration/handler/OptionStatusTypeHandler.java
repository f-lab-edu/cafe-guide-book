package com.flab.cafeguidebook.enumeration.handler;

import com.flab.cafeguidebook.enumeration.OptionStatus;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class OptionStatusTypeHandler implements TypeHandler<OptionStatus> {

  private Class<OptionStatus> type;

  public OptionStatusTypeHandler(Class<OptionStatus> type) {
    this.type = type;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, OptionStatus parameter, JdbcType jdbcType)
      throws SQLException {
    if (parameter == null) {
      ps.setNull(i, jdbcType.TYPE_CODE);
    } else {
      ps.setInt(i, parameter.getCode());
    }
  }

  @Override
  public OptionStatus getResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return getOptionStatus(code);
  }

  @Override
  public OptionStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return getOptionStatus(code);
  }

  @Override
  public OptionStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return getOptionStatus(code);
  }

  private OptionStatus getOptionStatus(int code) {
    try {
      OptionStatus[] enumConstants = (OptionStatus[]) type.getEnumConstants();
      for (OptionStatus optionStatus : enumConstants) {
        if (optionStatus.getCode() == code) {
          return optionStatus;
        }
      }
      return null;
    } catch (Exception e) {
      throw new TypeException("Can't make enum object '" + type + "'", e);
    }
  }
}
