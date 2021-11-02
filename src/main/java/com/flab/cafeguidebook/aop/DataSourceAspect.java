package com.flab.cafeguidebook.aop;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.datasource.RoutingDataSourceManager;
import com.flab.cafeguidebook.exception.DataSourceException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

  @Before("@annotation(com.flab.cafeguidebook.annotation.DataSource) && @annotation(target)")
  public void setDataSource(DataSource target) throws DataSourceException {
    if (target.dataSourceType() == DataSourceType.MASTER
        || target.dataSourceType() == DataSourceType.SLAVE) {
      RoutingDataSourceManager.setCurrentDataSourceName(target.dataSourceType());
    } else {
      throw new DataSourceException("DataSource type is wrong");
    }
  }
}
