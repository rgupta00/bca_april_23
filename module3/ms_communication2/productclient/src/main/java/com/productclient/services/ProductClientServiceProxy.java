//package com.productclient.services;
//
//import com.productclient.dto.ProductDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
////1. Retry
////2. ProductDto --> List<Review>
//@FeignClient(name = "ps", url = "http://localhost:8080/products")
//public interface ProductClientServiceProxy {
//
//    @GetMapping
//    public ResponseEntity<List<ProductDto>> getAll();
//
//    @GetMapping(path = "{productId}")
//    public ResponseEntity<ProductDto> getById( @PathVariable int productId );
//
//    @PostMapping
//    public ResponseEntity<ProductDto> addProduct( @RequestBody ProductDto productDto );
//
//    @DeleteMapping(path = "{productId}")
//    public ResponseEntity<Void> deleteProduct( @PathVariable int productId );
//}
//
