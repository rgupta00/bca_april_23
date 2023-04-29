package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
<context:annotation-config/><!--hey spring i want to use annotations -->
   <context:component-scan base-package="com.demo"/><!--hey where to look for annotations -->

 */
@Configuration// it means this class used by container to bootrap the application
@ComponentScan(basePackages = {"com.demo"})
public class AppConfig {
}
