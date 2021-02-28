package com.jshawn.ecsite.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jshawn.ecsite.model.CartLineItem;

@Validated
public interface CartLineItemService {
	void deleteById(Long id);
	
	void deleteLinesById(Long id);
	
	CartLineItem create(@NotNull(message = "The products for order cannot be null.") @Valid CartLineItem cartLineItem);
	
	List<CartLineItem> getByCartId(Long id);
	
}
