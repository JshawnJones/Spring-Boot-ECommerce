package com.jshawn.ecsite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userid;
	
	private String first_name;
	
	private String last_name;
	
	private String shipping_address_1;
	
	private String shipping_address_2;
	
	private String shipping_postcode;
	
	private String shipping_city;
	
	private String shipping_state;
	
	private String shipping_country;
	
	private String shipping_phone;
	
	private String billing_first_name;
	
	private String billing_last_name;
	
	private String billing_address_1;
	
	private String billing_address_2;
	
	private String billing_postcode;
	
	private String billing_city;
	
	private String billing_state;
	
	private String billing_country;
	
	private String billing_phone;

	private String card_number;
	
	private String card_name;
	
	@JsonFormat(pattern = "MM-yyyy")
	private String card_exp_date;

	public UserDetails(){}
	
	public UserDetails(Long id, Long userid, String first_name, String last_name, String shipping_address_1,
			String shipping_address_2, String shipping_postcode, String shipping_city, String shipping_state,
			String shipping_country, String shipping_phone, String billing_first_name, String billing_last_name,
			String billing_address_1, String billing_address_2, String billing_postcode, String billing_city,
			String billing_state, String billing_country, String billing_phone, String card_number, String card_name,
			String card_exp_date) {
		this.id = id;
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.shipping_address_1 = shipping_address_1;
		this.shipping_address_2 = shipping_address_2;
		this.shipping_postcode = shipping_postcode;
		this.shipping_city = shipping_city;
		this.shipping_state = shipping_state;
		this.shipping_country = shipping_country;
		this.shipping_phone = shipping_phone;
		this.billing_first_name = billing_first_name;
		this.billing_last_name = billing_last_name;
		this.billing_address_1 = billing_address_1;
		this.billing_address_2 = billing_address_2;
		this.billing_postcode = billing_postcode;
		this.billing_city = billing_city;
		this.billing_state = billing_state;
		this.billing_country = billing_country;
		this.billing_phone = billing_phone;
		this.card_number = card_number;
		this.card_name = card_name;
		this.card_exp_date = card_exp_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public String getCard_exp_date() {
		return card_exp_date;
	}

	public void setCard_exp_date(String card_exp_date) {
		this.card_exp_date = card_exp_date;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userid=" + userid + ", first_name=" + first_name + ", last_name="
				+ last_name + ", shipping_address_1=" + shipping_address_1 + ", shipping_address_2="
				+ shipping_address_2 + ", shipping_postcode=" + shipping_postcode + ", shipping_city=" + shipping_city
				+ ", shipping_state=" + shipping_state + ", shipping_country=" + shipping_country + ", shipping_phone="
				+ shipping_phone + ", billing_first_name=" + billing_first_name + ", billing_last_name="
				+ billing_last_name + ", billing_address_1=" + billing_address_1 + ", billing_address_2="
				+ billing_address_2 + ", billing_postcode=" + billing_postcode + ", billing_city=" + billing_city
				+ ", billing_state=" + billing_state + ", billing_country=" + billing_country + ", billing_phone="
				+ billing_phone + ", card_number=" + card_number + ", card_name=" + card_name + ", card_exp_date="
				+ card_exp_date + "]";
	}

}
