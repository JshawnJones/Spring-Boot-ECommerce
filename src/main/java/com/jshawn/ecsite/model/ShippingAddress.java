package com.jshawn.ecsite.model;


public class ShippingAddress {

	private String first_name;
	
	private String last_name;
	
	private String shipping_address_1;
	
	private String shipping_address_2;
	
	private String shipping_postcode;
	
	private String shipping_city;
	
	private String shipping_state;
	
	private String shipping_country;
	
	private String shipping_phone;

	public ShippingAddress(String first_name, String last_name, String shipping_address_1, String shipping_address_2,
			String shipping_postcode, String shipping_city, String shipping_state, String shipping_country,
			String shipping_phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.shipping_address_1 = shipping_address_1;
		this.shipping_address_2 = shipping_address_2;
		this.shipping_postcode = shipping_postcode;
		this.shipping_city = shipping_city;
		this.shipping_state = shipping_state;
		this.shipping_country = shipping_country;
		this.shipping_phone = shipping_phone;
	}

	
	
	public ShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getShipping_address_1() {
		return shipping_address_1;
	}

	public void setShipping_address_1(String shipping_address_1) {
		this.shipping_address_1 = shipping_address_1;
	}

	public String getShipping_address_2() {
		return shipping_address_2;
	}

	public void setShipping_address_2(String shipping_address_2) {
		this.shipping_address_2 = shipping_address_2;
	}

	public String getShipping_postcode() {
		return shipping_postcode;
	}

	public void setShipping_postcode(String shipping_postcode) {
		this.shipping_postcode = shipping_postcode;
	}

	public String getShipping_city() {
		return shipping_city;
	}

	public void setShipping_city(String shipping_city) {
		this.shipping_city = shipping_city;
	}

	public String getShipping_state() {
		return shipping_state;
	}

	public void setShipping_state(String shipping_state) {
		this.shipping_state = shipping_state;
	}

	public String getShipping_country() {
		return shipping_country;
	}

	public void setShipping_country(String shipping_country) {
		this.shipping_country = shipping_country;
	}

	public String getShipping_phone() {
		return shipping_phone;
	}

	public void setShipping_phone(String shipping_phone) {
		this.shipping_phone = shipping_phone;
	}
	
	
}
