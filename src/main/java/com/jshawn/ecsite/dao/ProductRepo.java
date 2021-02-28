package com.jshawn.ecsite.dao;

import org.springframework.data.repository.CrudRepository;

import com.jshawn.ecsite.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

}
