package com.flab.cafeguidebook.config;

import com.flab.cafeguidebook.util.CurrentUserIdResolver;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final CurrentUserIdResolver currentUserIdResolver;

  public WebConfig(CurrentUserIdResolver currentUserIdResolver) {
    this.currentUserIdResolver = currentUserIdResolver;
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(currentUserIdResolver);
  }
}
