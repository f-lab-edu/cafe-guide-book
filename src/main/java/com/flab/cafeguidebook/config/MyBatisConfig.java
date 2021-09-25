package com.flab.cafeguidebook.config;

import com.flab.cafeguidebook.enumeration.CafeCondition;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import com.flab.cafeguidebook.enumeration.MenuGroup;
import com.flab.cafeguidebook.enumeration.MenuStatus;
import com.flab.cafeguidebook.enumeration.OptionStatus;
import com.flab.cafeguidebook.enumeration.UserType;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
  public DataSource dataSource(HikariConfig hikariConfig) {
    return new HikariDataSource(hikariConfig);
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis/config/mybatis-config.xml"));
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
