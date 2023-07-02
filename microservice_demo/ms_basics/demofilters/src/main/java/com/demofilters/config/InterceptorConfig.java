package com.demofilters.config;

import com.demofilters.interceptors.GenericInterceptor;
import com.demofilters.interceptors.SpecificInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private SpecificInterceptor specificInterceptor;

    @Autowired
    private GenericInterceptor genericInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //i need to register my intercepor

        registry.addInterceptor(genericInterceptor).order(1);
        registry.addInterceptor(specificInterceptor)
                .addPathPatterns("/hello2/**")
                .order(2)
                .excludePathPatterns("/hello2/pqr");

    }
}













