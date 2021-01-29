package com.velheor.carrental.mvcconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan("com.velheor.carrental")
public class SpringConfig implements WebMvcConfigurer {

  private final ApplicationContext applicationContext;

  @Autowired
  public SpringConfig(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }
}
