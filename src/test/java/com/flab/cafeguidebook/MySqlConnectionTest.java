package com.flab.cafeguidebook;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled("This test in only available in local environment.")
@SpringBootTest
public class MySqlConnectionTest {

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER;

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USER;

    @Value("${spring.datasource.password}")
    private String PW;

    @Test
    public void testConnection() throws Exception {

        final Logger LOG = Logger.getGlobal();
        Class.forName(DRIVER);
        try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
            System.out.println(con);
            LOG.info(con.toString());
        } catch (Exception e) {
            fail(e);
        }
    }
}
