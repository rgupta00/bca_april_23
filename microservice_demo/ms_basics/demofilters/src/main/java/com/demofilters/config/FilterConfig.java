package com.demofilters.config;

import com.demofilters.filters.Filter1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    //u need to register the filter with spring mvc
   // FilterRegistrationBean
    @Bean
    public FilterRegistrationBean<Filter1> regiserFilter1(){
        FilterRegistrationBean<Filter1> registrationBeans=new FilterRegistrationBean<Filter1>();
        registrationBeans.setFilter(new Filter1());
        registrationBeans.addUrlPatterns("/hello2/*");//Why it is running for all api endpoints
        return registrationBeans;
    }
}
