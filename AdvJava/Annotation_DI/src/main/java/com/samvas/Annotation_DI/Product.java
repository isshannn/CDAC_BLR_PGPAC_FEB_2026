package com.samvas.Annotation_DI;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int productId = 201;
	private String productName = "Wireless Mosue";
	private double price = 899.0;
	
		
	public void displayProduct() {
		System.out.println("ProductName :: "+ productName);
		System.out.println("ProductID :: "+ productId);
		System.out.println("Price :: "+ price);
	}
}
