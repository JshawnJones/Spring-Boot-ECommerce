package com.jshawn.ecsite.model;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Product name is required.")
    @Basic(optional = false)
	private String name;
	
	private String image;
	
	private Double price;
	
	private int inventory;

	public Product(Long id, 
			@NotNull(message = "Product name is required.") String name, 
			String image, 
			Double price,
			int inventory) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.inventory = inventory;
	}
	
	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", inventory="
				+ inventory + "]";
	}
	
}
