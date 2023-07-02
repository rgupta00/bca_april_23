package com.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//2 kind of filter u can use with api gateway , recative way of programming*
//global fiter: impl GlobalFilter in a class
//Specific filter: AbstractGatewayFilterFactory for specific routes

//filter for specific routes
@Component
public class MyGlobalFiter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("------------inside global fiter of api gateway-----------------");
         var requestWithHeader= exchange.getRequest().mutate()
                .header("weatherappfilter1","weather app global fitler value")
                .build();
        return chain.filter(exchange.mutate().request(requestWithHeader).build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}










