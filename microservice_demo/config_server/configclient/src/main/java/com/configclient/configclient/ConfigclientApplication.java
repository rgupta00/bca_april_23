package com.configclient.configclient;

import com.configclient.configclient.config.DbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(DbConfig.class)
@SpringBootApplication
public class ConfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}

}
