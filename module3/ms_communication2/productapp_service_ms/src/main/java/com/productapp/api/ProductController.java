//package com.productapp.api;
//
//import com.productapp.entities.Product;
//import com.productapp.service.ProductService;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
////@RestController
//@AllArgsConstructor
//public class ProductController {
//
//    private final ProductService productService;
//
//    //-------------getAll products--------------
//    @GetMapping(path = "products")
//    public ResponseEntity<List<Product>> getAll(){
//        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
//    }
//
//    //-------------get an product by id--------------
//    @GetMapping(path = "products/{productId}")
//    public ResponseEntity<Product> getById( @PathVariable int productId ){
//        return  ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
//    }
//
//    //-------------add product--postman -json --> java object ------------
//    @PostMapping(path = "products")
//    public ResponseEntity<Product> addProduct(@Valid @RequestBody  Product product ){
//        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
//    }
//    //-------------delete product--------------
//    @DeleteMapping (path = "products/{productId}")
//    public ResponseEntity<Void> deleteProduct( @PathVariable int productId ){
//          productService.deleteProduct(productId);
//          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
