package com.jshawn.ecsite.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long user_id;
	
	private Long user_details_id;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private LocalDate created_date;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private LocalDate modified_date;
	
	private String payment_status;
	
	private String shipment_status;
	
	private Double total_price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getUser_details_id() {
		return user_details_id;
	}

	public void setUser_details_id(Long user_details_id) {
		this.user_details_id = user_details_id;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}

	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getShipment_status() {
		return shipment_status;
	}

	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", user_details_id=" + user_details_id + ", created_date="
				+ created_date + ", modified_date=" + modified_date + ", payment_status=" + payment_status
				+ ", shipment_status=" + shipment_status + ", total_price=" + total_price + "]";
	}
	
	
}
