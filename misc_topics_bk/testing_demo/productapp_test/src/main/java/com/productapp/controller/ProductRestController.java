package com.productapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;

//@RestController
public class ProductRestController {

	
	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path="products", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> allProducts(){
		return productService.getAll();
	}
	
	@GetMapping(path="products/{id}",produces=MediaType.APPLICATION_JSON_VALUE )
	public Product getProductById(@PathVariable(name="id")int id){
		return productService.getProductById(id);
	}
	
	@PostMapping(path="products",produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE )
	public Product addProduct(@RequestBody Product product){
		return productService.save(product);
	}
	
	@PutMapping(path="products/{id}",produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE )
	public Product updateEmployee(@PathVariable(name="id") int id,   @RequestBody Product product){
		return  productService.update(id, product);
		
	}
	
	@DeleteMapping(path="products/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Product deleteEmplloyee(@PathVariable(name="id") int id){
		return productService.delete(id);
	}
}
