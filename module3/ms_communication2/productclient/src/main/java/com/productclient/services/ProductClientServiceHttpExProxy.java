package com.productclient.services;

import com.productclient.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("products")
public interface ProductClientServiceHttpExProxy {

    @GetExchange
    public ResponseEntity<List<ProductDto>> getAll();

    @GetExchange("{productId}")
    public ResponseEntity<ProductDto> getById( @PathVariable int productId );

    @PostExchange
    public ResponseEntity<ProductDto> addProduct( @RequestBody ProductDto productDto );

    @DeleteExchange("{productId}")
    public ResponseEntity<Void> deleteProduct( @PathVariable int productId );
}

