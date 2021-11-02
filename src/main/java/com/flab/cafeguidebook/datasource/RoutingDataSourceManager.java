package com.flab.cafeguidebook.datasource;


import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;

public class RoutingDataSourceManager {

  private static final ThreadLocal<DataSourceType> currentDataSourceName = new ThreadLocal<>();

  public static DataSourceType getCurrentDataSourceName() {
    return currentDataSourceName.get();
  }

  public static void setCurrentDataSourceName(DataSourceType dataSourceType) {
    currentDataSourceName.set(dataSourceType);
  }

  public static void removeCurrentDataSourceName() {
    currentDataSourceName.remove();
  }
}
