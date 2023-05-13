package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
//IF U WANT TO CONFIGURE UR OWN DATASOURCE ==> THIS U NEED TO DO
@SpringBootApplication(
		exclude = {DataSourceAutoConfiguration.class,
				DataSourceTransactionManagerAutoConfiguration.class}
)
public class Productapp01Application implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Productapp01Application.class, args);

		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(name-> System.out.println(name));
	}

	@Override
	public void run(String... args) throws Exception {

		if(dataSource!=null){
			System.out.println("-------------ds is configured-------------");
		}else {
			System.out.println("not configured");
		}
		if(jdbcTemplate!=null){
			System.out.println("-------------jdbcTemplate is configured-------------");
		}
	}
}
