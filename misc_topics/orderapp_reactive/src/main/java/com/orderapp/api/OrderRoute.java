package com.orderapp.api;


import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class OrderRoute {

    @Autowired
    private OrderHandler orderHandler;

//    @Bean
//    RouterFunction<ServerResponse> getEmployeeByIdRoute() {
//        return route(GET("/employees/{id}"),
//                req -> ok().body(
//                        employeeRepository().findEmployeeById(req.pathVariable("id")), Employee.class));
//    }

    @Bean
    public RouterFunction<ServerResponse> orderRouters(){
//        RouterFunction<ServerResponse> route = RouterFunctions.route()
//
//                .GET("/hello-world", accept(MediaType.TEXT_PLAIN),
//
//                        request -> ServerResponse.ok().bodyValue("Hello World")).build();

        return  RouterFunctions
                .route(GET("/api/order/getall"),OrderHandler::getAll);
//
    }
}
