package com.flab.cafeguidebook.exception;

import java.sql.SQLException;

public class DataSourceException extends SQLException {

  public DataSourceException(String message) {
    super(message);
  }
}
