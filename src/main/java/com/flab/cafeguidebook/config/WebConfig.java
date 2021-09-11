package com.flab.cafeguidebook.config;

import com.flab.cafeguidebook.util.CurrentUserEmailResolver;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final CurrentUserEmailResolver currentUserEmailResolver;

  public WebConfig(CurrentUserEmailResolver currentUserIdResolver) {
    this.currentUserEmailResolver = currentUserIdResolver;
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(currentUserEmailResolver);
  }
}
