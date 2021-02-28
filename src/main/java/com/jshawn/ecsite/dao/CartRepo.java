package com.jshawn.ecsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jshawn.ecsite.model.Cart;

public interface CartRepo extends CrudRepository<Cart, Long>{

	@Query("from Cart where user_id=?1")
	List<Cart> searchByUserId(Long id);
}
