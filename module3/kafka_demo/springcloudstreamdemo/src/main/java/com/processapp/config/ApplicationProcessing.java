package com.processapp.config;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.context.Theme;

@Configuration
public class ApplicationProcessing {
	
	//java 8 streams: Funcation, Supplier, Consumer
	
	@Bean
	public Supplier<String> producerBinding(){
		
		return ()-> {
				try {
					Thread.sleep(1500);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			return "some data";
		};
	}
	
	@Bean
	public Function<String, String> processorBinding(){
		return s->s +": "+ LocalDateTime.now().toString();
	}
	
	@Bean
	public Consumer<String> consumerBinding(){
		return s-> System.out.println("data consumed :" + s.toUpperCase());
	}
	
	
}














