package com.jshawn.ecsite.model;

public class BillingAddress {

	private String billing_first_name;
	
	private String billing_last_name;
	
	private String billing_address_1;
	
	private String billing_address_2;
	
	private String billing_postcode;
	
	private String billing_city;
	
	private String billing_state;
	
	private String billing_country;
	
	private String billing_phone;

	public BillingAddress(String billing_first_name, String billing_last_name, String billing_address_1,
			String billing_address_2, String billing_postcode, String billing_city, String billing_state,
			String billing_country, String billing_phone) {
		this.billing_first_name = billing_first_name;
		this.billing_last_name = billing_last_name;
		this.billing_address_1 = billing_address_1;
		this.billing_address_2 = billing_address_2;
		this.billing_postcode = billing_postcode;
		this.billing_city = billing_city;
		this.billing_state = billing_state;
		this.billing_country = billing_country;
		this.billing_phone = billing_phone;
	}

	
	
	public BillingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getBilling_first_name() {
		return billing_first_name;
	}

	public void setBilling_first_name(String billing_first_name) {
		this.billing_first_name = billing_first_name;
	}

	public String getBilling_last_name() {
		return billing_last_name;
	}

	public void setBilling_last_name(String billing_last_name) {
		this.billing_last_name = billing_last_name;
	}

	public String getBilling_address_1() {
		return billing_address_1;
	}

	public void setBilling_address_1(String billing_address_1) {
		this.billing_address_1 = billing_address_1;
	}

	public String getBilling_address_2() {
		return billing_address_2;
	}

	public void setBilling_address_2(String billing_address_2) {
		this.billing_address_2 = billing_address_2;
	}

	public String getBilling_postcode() {
		return billing_postcode;
	}

	public void setBilling_postcode(String billing_postcode) {
		this.billing_postcode = billing_postcode;
	}

	public String getBilling_city() {
		return billing_city;
	}

	public void setBilling_city(String billing_city) {
		this.billing_city = billing_city;
	}

	public String getBilling_state() {
		return billing_state;
	}

	public void setBilling_state(String billing_state) {
		this.billing_state = billing_state;
	}

	public String getBilling_country() {
		return billing_country;
	}

	public void setBilling_country(String billing_country) {
		this.billing_country = billing_country;
	}

	public String getBilling_phone() {
		return billing_phone;
	}

	public void setBilling_phone(String billing_phone) {
		this.billing_phone = billing_phone;
	};
	
	
	
	
}
