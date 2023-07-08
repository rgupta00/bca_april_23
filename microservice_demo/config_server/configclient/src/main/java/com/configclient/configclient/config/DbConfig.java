package com.configclient.configclient.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
@NoArgsConstructor
public class DbConfig {
    private String url;//jsr 303
    private String username;
    private String password;
    private String driverClassName;
}
