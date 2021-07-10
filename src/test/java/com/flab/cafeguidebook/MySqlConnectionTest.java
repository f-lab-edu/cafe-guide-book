package com.flab.cafeguidebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class MySqlConnectionTest {

  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306?serverTimezone=UTC&characterEncoding=UTF-8";
  private static final String USER = "root";
  private static final String PW = "Cafe1234!";

  @Test
  public void testConnection() throws Exception{

    final Logger LOG = Logger.getGlobal();
    Class.forName(DRIVER);

    try(Connection con = DriverManager.getConnection(URL, USER, PW)){
      System.out.println(con);
      LOG.info(con.toString());
    }catch(Exception e) {
      fail(e);
    }
  }
}
