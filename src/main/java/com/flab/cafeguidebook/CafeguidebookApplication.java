package com.flab.cafeguidebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CafeguidebookApplication {

  public static void main(String[] args) {
    SpringApplication.run(CafeguidebookApplication.class, args);
  }

}
