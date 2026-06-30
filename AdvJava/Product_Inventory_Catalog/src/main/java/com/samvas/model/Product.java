package com.samvas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Product name cant be empty")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;
	
	@NotBlank(message = "Category cant be empty")
	private String category;
	
	@NotNull(message = "Price is required")
	@DecimalMin(value = "0.01", message="Price must be greater than 0")
	private double price;
	
	@NotNull(message = "Stock Quantity is required")
	@Min(value = 0, message = "Stock cant be negetive")
	private Integer StockQuantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return StockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		StockQuantity = stockQuantity;
	}
}
