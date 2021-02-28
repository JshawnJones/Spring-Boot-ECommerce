package com.jshawn.ecsite.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.CartLineItemRepo;
import com.jshawn.ecsite.model.CartLineItem;

@Service
@Transactional
public class CartLineItemServiceImpl implements CartLineItemService{

	private CartLineItemRepo cartLineItemRepo;

	public CartLineItemServiceImpl(CartLineItemRepo cartLineItemRepo) {
		this.cartLineItemRepo = cartLineItemRepo;
	}

	@Override
	public void deleteById(Long id) {
		this.cartLineItemRepo.deleteById(id);
	}
	
	@Override
	public void deleteLinesById(Long id) {
		this.cartLineItemRepo.delete(id);
		
	}

	@Override
	public CartLineItem create(CartLineItem cartLineItem) {
		
		return this.cartLineItemRepo.save(cartLineItem);
	}

	@Override
	public List<CartLineItem> getByCartId(Long id) {
		
		return this.cartLineItemRepo.searchByCartId(id);
	}


	
	
}
