package com.samvas.Annotation_DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	private int cartId = 2001;
	private String customerName = "Samvas Majhi";
	
	@Autowired
	private Product product;
		
	
	public void displayCart() {
		System.out.println("Cart ID :: "+ cartId);
		System.out.println("Customer Name ::" + customerName);
		System.out.println("Product Details");
		System.out.println("-----------------");
		product.displayProduct();
	}
}
