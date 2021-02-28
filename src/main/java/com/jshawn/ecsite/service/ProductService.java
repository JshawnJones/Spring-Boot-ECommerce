package com.jshawn.ecsite.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jshawn.ecsite.model.Product;

@Validated
public interface ProductService {

	@NotNull Iterable<Product> getAllProducts();
	
	Product getProductById(@Min(value = 1L, message = "Invalid product ID.") Long id);
	
	Product save(Product product);
}
