package com.productapp.service;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.productapp.dao.ProductRepo;
import com.productapp.entities.Product;
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {

	@MockBean
	private ProductRepo productRepo;
	
	@InjectMocks
	private ProductServiceImpl productService;
	

	@Test
	void testGetAllProduct() {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1, "laptop", 50000));

        // providing knowledge
        when(productRepo.findAll()).thenReturn(productList);

        List<Product> fetchedProducts = productService.getAll();
        assertThat(fetchedProducts.size()).isGreaterThan(0);
	}

	
	

}
