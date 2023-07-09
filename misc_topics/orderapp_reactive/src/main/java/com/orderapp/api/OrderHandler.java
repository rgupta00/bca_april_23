package com.orderapp.api;

import com.orderapp.entities.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

//Step 1: u create Order handler

@Component
public class OrderHandler {

    public static Mono<ServerResponse>  getAll(ServerRequest request){
        List<Order> list = Arrays.asList(
                new Order(1, 45000.00),
                new Order(41, 45090.00),
                new Order(551, 55000.00)
        );

        Flux<Order> orderFlux=Flux.fromIterable(list)
                .log()
                .delayElements(Duration.ofMillis(2000));

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(orderFlux, Order.class);
    }
}
