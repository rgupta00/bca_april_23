package com.productapp.api;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import com.productapp.util.ConversionUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ProductControllerV2 {

    private final ProductService productService;

    //-------------getAll products--------------
    @GetMapping(path = "products")
    public ResponseEntity<List<ProductDto>> getAll(){
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAll().stream().map(ConversionUtil::convertToProductDto).collect(Collectors.toList()));
    }

    //-------------get an product by id--------------
    @GetMapping(path = "products/{productId}")
    public ResponseEntity<ProductDto> getById( @PathVariable int productId ){
        return  ResponseEntity.status(HttpStatus.OK).body(ConversionUtil.convertToProductDto(productService.getProductById(productId)));
    }

    //-------------add product--postman -json --> java object ------------
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody  ProductDto productDto ){
        Product product=ConversionUtil.convertToProduct(productDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }
    //-------------delete product--------------
    @DeleteMapping (path = "products/{productId}")
    public ResponseEntity<Void> deleteProduct( @PathVariable int productId ){
          productService.deleteProduct(productId);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}



















