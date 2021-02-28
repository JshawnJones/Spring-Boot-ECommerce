package com.jshawn.ecsite.dto;

import com.jshawn.ecsite.model.Product;

public class CartLineItemDto {

	private Product product;
	private Integer quantity;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "CartLineItemDto [product=" + product + ", quantity=" + quantity + "]";
	}
	
	
}
