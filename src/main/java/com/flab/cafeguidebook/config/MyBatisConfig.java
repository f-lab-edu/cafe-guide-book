package com.flab.cafeguidebook.config;

import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.annotation.MasterDataSource;
import com.flab.cafeguidebook.annotation.SlaveDataSource;
import com.flab.cafeguidebook.datasource.RoutingDataSourceManager;
import com.flab.cafeguidebook.enumeration.CafeCondition;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import com.flab.cafeguidebook.enumeration.MenuGroup;
import com.flab.cafeguidebook.enumeration.MenuStatus;
import com.flab.cafeguidebook.enumeration.OptionStatus;
import com.flab.cafeguidebook.enumeration.UserType;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Configuration
@MapperScan(basePackages = "com.flab.cafeguidebook.mapper")
@EnableTransactionManagement
public class MyBatisConfig {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private HikariConfig hikariConfig;

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
  public DataSource masterDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari.slave")
  public DataSource slaveDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  public DataSource routingDataSource(
      @MasterDataSource DataSource masterDataSource,
      @SlaveDataSource DataSource slaveDataSource) {
    ;

    AbstractRoutingDataSource routingDataSource = new AbstractRoutingDataSource() {
      @Override
      protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = RoutingDataSourceManager.getCurrentDataSourceName();
        if (dataSourceType != null) {
          return dataSourceType;
        }

        if (TransactionSynchronizationManager
            .isActualTransactionActive()) {
          boolean readOnly = TransactionSynchronizationManager
              .isCurrentTransactionReadOnly();
          if (readOnly) {
            dataSourceType = DataSourceType.SLAVE;
          } else {
            dataSourceType = DataSourceType.MASTER;
          }
        }

        RoutingDataSourceManager.removeCurrentDataSourceName();
        return dataSourceType;
      }
    };

    Map<Object, Object> targetDataSources = new HashMap<>();

    targetDataSources.put(DataSourceType.MASTER, masterDataSource);
    targetDataSources.put(DataSourceType.SLAVE, slaveDataSource);

    routingDataSource.setTargetDataSources(targetDataSources);
    routingDataSource.setDefaultTargetDataSource(masterDataSource);

    return routingDataSource;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(routingDataSource(masterDataSource(), slaveDataSource()));
    sessionFactory.setConfigLocation(
        applicationContext.getResource("classpath:/mybatis/config/mybatis-config.xml"));
    sessionFactory
        .setMapperLocations(applicationContext.getResources("classpath:/mybatis/mapper/*.xml"));
    sessionFactory.setTypeHandlers(new TypeHandler[]{
        new UserType.TypeHandler(),
        new CafeCondition.TypeHandler(),
        new CafeRegistration.TypeHandler(),
        new MenuGroup.TypeHandler(),
        new MenuStatus.TypeHandler(),
        new OptionStatus.TypeHandler()
    });
    return sessionFactory.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
      throws Exception {
    final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    return sqlSessionTemplate;
  }
}
