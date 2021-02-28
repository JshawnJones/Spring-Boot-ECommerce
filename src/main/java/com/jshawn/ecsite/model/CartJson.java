package com.jshawn.ecsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartJson {
	@JsonProperty
	private Product product;
	@JsonProperty
	private int quantity;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
