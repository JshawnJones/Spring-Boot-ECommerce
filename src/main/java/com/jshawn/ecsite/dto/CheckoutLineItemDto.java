package com.jshawn.ecsite.dto;

import com.jshawn.ecsite.model.Product;

public class CheckoutLineItemDto {

	private Product product;
	private Integer quantity;
	private Double totalLinePrice;
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
	public Double getTotalLinePrice() {
		return totalLinePrice;
	}
	public void setTotalLinePrice(Double totalLinePrice) {
		this.totalLinePrice = totalLinePrice;
	}
	@Override
	public String toString() {
		return "CheckoutLineItemDto [product=" + product + ", quantity=" + quantity + ", totalLinePrice="
				+ totalLinePrice + "]";
	}
	
	
}
