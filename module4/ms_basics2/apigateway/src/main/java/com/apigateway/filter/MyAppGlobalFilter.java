package com.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class MyAppGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("*********************inside global filter*********************");
        var requestWithHeader= exchange.getRequest().mutate()
                .header("weatherapp", "weather app global header value")
                .build();

        return chain.filter(exchange.mutate().request(requestWithHeader).build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
