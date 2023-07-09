package com.orderapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Flux<String> stringFlux=Flux.just("raj","ekta","ravi")
//				.concatWith(Flux.error(new RuntimeException("run time ex was thrown")))
//				.concatWith(Flux.just("tarun"))
//						.log();
//
//		stringFlux.subscribe(System.out::println);

		//List
//		List<String> list= Arrays.asList("raj","ekta","ravi");
//
//		Flux<String> stringFlux=Flux.fromIterable(list)
//				//.concatWith(Flux.error(new RuntimeException("run time ex was thrown")))
//				.concatWith(Flux.just("tarun"))
//				.log();
//
//		stringFlux.subscribe(System.out::println);


		//Streams
//		List<String> list= Arrays.asList("raj","ekta","ravi");
//
//		Stream<String> streams=list.stream();
//		Flux<String> stringFlux=Flux.fromStream(streams)
//				//.concatWith(Flux.error(new RuntimeException("run time ex was thrown")))
//				.concatWith(Flux.just("tarun"))
//				.log();
//
//		stringFlux.subscribe(System.out::println,
//				(e)-> System.out.println("exception "+e),
//				()-> System.out.println("success"));



//		Flux<Integer> intSteams=Flux.range(1,10).log();
//		intSteams.subscribe(System.out::println);

	}
}
