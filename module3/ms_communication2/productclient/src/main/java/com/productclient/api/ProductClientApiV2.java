//package com.productclient.api;
//
//import com.productclient.dto.ProductDto;
//import com.productclient.services.ProductClientServiceProxy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////@RestController
//public class ProductClientApiV2 {
//
//    @Autowired
//    private ProductClientServiceProxy productClientServiceProxy;
//
//    //call a rest end point
//    //  http://localhost:8080/products/1
//    @GetMapping("productclient/{id}")
//    public ProductDto getProductId(@PathVariable int id){
//       return  productClientServiceProxy.getById(id).getBody();
//    }
//
//    @GetMapping("productclient")
//    public List<ProductDto> getAllProduct(){
//        return productClientServiceProxy.getAll().getBody();
//    }
//
//    @PostMapping("productclient")
//    public ProductDto addProduct(@RequestBody ProductDto productDto){
//        return productClientServiceProxy.addProduct(productDto).getBody();
//    }
//
//}
