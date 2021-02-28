package com.jshawn.ecsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentJson {
	@JsonProperty
	private ShippingAddress shippingAddress;
	@JsonProperty
	private BillingAddress billingAddress;
	@JsonProperty
	private PaymentInfo paymentInfo;
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	
	
}
