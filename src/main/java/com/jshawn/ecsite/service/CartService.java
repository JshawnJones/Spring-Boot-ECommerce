package com.jshawn.ecsite.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jshawn.ecsite.model.Cart;

@Validated
public interface CartService {

	@NotNull Iterable<Cart> getAllCart();
	
	List<Cart> getByUserId(Long id);
	
	Cart create(@NotNull(message = "The cart cannot be null.") @Valid Cart cart);
	
	Cart update(@NotNull(message = "The cart cannot be null.") @Valid Cart cart);
	
	void deleteById(Long id);
}
