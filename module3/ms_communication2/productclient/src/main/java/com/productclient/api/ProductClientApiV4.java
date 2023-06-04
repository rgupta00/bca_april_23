package com.productclient.api;//package com.productclient.api;

import com.productclient.dto.ProductDto;
import com.productclient.services.ProductClientServiceHttpExProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductClientApiV4 {

    @Autowired
    private ProductClientServiceHttpExProxy productClientServiceHttpExProxy;

    //call a rest end point
    //  http://localhost:8080/products/1
    @GetMapping("productclient/{id}")
    public ProductDto getProductId(@PathVariable int id){
       return  productClientServiceHttpExProxy.getById(id).getBody();
    }

    @GetMapping("productclient")
    public List<ProductDto> getAllProduct(){
        return productClientServiceHttpExProxy.getAll().getBody();
    }

    @PostMapping("productclient")
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        return productClientServiceHttpExProxy.addProduct(productDto).getBody();
    }

}
