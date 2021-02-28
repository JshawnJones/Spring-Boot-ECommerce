package com.jshawn.ecsite.service;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.ProductRepo;
import com.jshawn.ecsite.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public Iterable<Product> getAllProducts(){
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}
}
