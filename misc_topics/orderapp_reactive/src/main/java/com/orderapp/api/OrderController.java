//package com.orderapp.api;
//
//import ch.qos.logback.core.net.SyslogOutputStream;
//import com.orderapp.entities.Order;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping(path = "api")
//public class OrderController {
//
//
////    @GetMapping(value = "intflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
////    public Flux<Integer> getAllV2() {
////       Flux<Integer> integerFlux=Flux.range(1,100)
////               .delayElements(Duration.ofMillis(1000))
////               .log();
////
////        return integerFlux;
////    }
//
//
//
//    @GetMapping(value = "getreactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Order> getAllV2() {
//        List<Order> list = Arrays.asList(
//                new Order(1, 45000.00),
//                new Order(41, 45090.00),
//                new Order(551, 55000.00)
//        );
//
//        Flux<Order> orderFlux=Flux.fromIterable(list)
//                .log()
//                .delayElements(Duration.ofMillis(2000));
//
//        return orderFlux;
//    }
//
//
//    @GetMapping(value = "get")
//    public List<Order> getAll() {
//        List<Order> list = Arrays.asList(
//                new Order(1, 45000.00),
//                new Order(41, 45090.00),
//                new Order(551, 55000.00)
//        );
//
//        list = list.stream().peek(order -> {
//            try {
//                System.out.println(order);
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
//        }).collect(Collectors.toList());
//        return list;
//    }
//}
