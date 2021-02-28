package com.jshawn.ecsite.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.CartRepo;
import com.jshawn.ecsite.model.Cart;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	private CartRepo cartRepo;

	public CartServiceImpl(CartRepo cartRepo) {
		this.cartRepo = cartRepo;
	}

	@Override
	public @NotNull Iterable<Cart> getAllCart() {
		
		return this.cartRepo.findAll();
	}

	@Override
	public List<Cart> getByUserId(Long id) {
		
		return this.cartRepo.searchByUserId(id);
	}

	@Override
	public Cart create(Cart cart) {
		cart.setDateCreated(LocalDate.now());
		return this.cartRepo.save(cart);
	}

	@Override
	public Cart update(Cart cart) {
		
		return this.cartRepo.save(cart);
	}

	@Override
	public void deleteById(Long id) {
		this.cartRepo.deleteById(id);
		
	}
	
	
}
