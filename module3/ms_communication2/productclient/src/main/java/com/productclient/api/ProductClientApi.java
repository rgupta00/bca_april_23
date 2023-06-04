//package com.productclient.api;
//
//import com.productclient.dto.ProductDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class ProductClientApi {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    //call a rest end point
//    //  http://localhost:8080/products/1
//    @GetMapping("productclient/{id}")
//    public ProductDto getProductId(@PathVariable int id){
//
//        String url="http://localhost:8080/products/{id}";
//        Map<String, Integer> params=new HashMap<>();
//        params.put("id", id);
//
//       ProductDto productDto= restTemplate.getForObject(url, ProductDto.class,params);
//       return productDto;
//    }
//
//    @GetMapping("productclientv2/{id}")
//    public ProductDto getProductIdV2(@PathVariable int id){
//        //ResponseEntity= data + status code
//        ResponseEntity<ProductDto> productDtoReponse=
//                restTemplate.getForEntity("http://localhost:8080/products/"+id , ProductDto.class);
//
//        System.out.println("respones status code: " + productDtoReponse.getStatusCode());
//
//        return productDtoReponse.getBody();
//    }
//
//    @GetMapping("productclient")
//    public List<?> getAllProduct(){
//        List<?> productDtos= restTemplate.getForObject("http://localhost:8080/products" , List.class);
//        return productDtos;
//    }
//
//}
