//package com.productclient.api;
//
//import com.productclient.dto.ProductDto;
//import com.productclient.services.ProductClientServiceProxy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.List;
//
//@RestController
//public class ProductClientApiV3 {
//
//    @Autowired
//    private WebClient webClient;
//
//    //  http://localhost:8080/products/1
//    @GetMapping("productclient/{id}")
//    public ProductDto getProductId(@PathVariable int id){
//        ProductDto productDto=webClient.get().uri("http://localhost:8080/products/"+1)
//                .retrieve().bodyToMono(ProductDto.class).block();
//        return  productDto;
//    }
//
//    @GetMapping("productclient")
//    public List<ProductDto> getAllProduct(){
//        return null;
//    }
//
//
//}
