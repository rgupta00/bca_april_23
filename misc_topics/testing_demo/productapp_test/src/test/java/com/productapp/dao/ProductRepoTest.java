package com.productapp.dao;
import java.util.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.productapp.entities.Product;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepoTest {

	@Autowired
	private ProductRepo productRepo;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Order(1)
	@Rollback(value = false)
	@Test
	void saveProductTest() {
		Product product=new Product("washing machine", 50000);
		
		productRepo.save(product);
		
		Assertions.assertThat(product.getId()).isGreaterThan(0);
	}
	
	@Test
    @Order(2)
    public void getProductTest(){
        Product product = productRepo.findById(1).get();
        Assertions.assertThat(product.getId()).isEqualTo(1);

    }
	@Test
    @Order(3)
    public void getListOfProductsTest(){

        List<Product> products = productRepo.findAll();

        Assertions.assertThat(products.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductTest(){

        Product product = productRepo.findById(1).get();

        product.setPrice(1000);

        Product productUpdated =  productRepo.save(product);

        Assertions.assertThat(productUpdated.getPrice()).isEqualTo(1000);

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteProductTest(){

    	 Product product = productRepo.findById(1).get();

    	 productRepo.delete(product);

        //employeeRepository.deleteById(1L);

        Product product1 = null;

        Optional<Product> optionalProduct = productRepo.findById(1);

        if(optionalProduct.isPresent()){
        	product1 = optionalProduct.get();
        }

        Assertions.assertThat(product1).isNull();
    }



	@AfterEach
	void tearDown() throws Exception {
	}

}
