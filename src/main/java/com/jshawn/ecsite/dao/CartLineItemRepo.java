package com.jshawn.ecsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jshawn.ecsite.model.CartLineItem;

public interface CartLineItemRepo extends CrudRepository<CartLineItem, Long>{

	@Modifying
	@Query(value = "DELETE FROM cart_line_item WHERE cart_id= :cart_id", nativeQuery = true)
	void delete(@Param("cart_id") Long cart_id);
	
	@Query(value = "SELECT * FROM cart_line_item WHERE cart_id= :cart_id", nativeQuery = true)
	List<CartLineItem> searchByCartId(@Param("cart_id")Long cart_id);
}
