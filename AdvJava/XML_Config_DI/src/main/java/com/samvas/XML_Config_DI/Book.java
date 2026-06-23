package com.samvas.XML_Config_DI;

public class Book {
	private int bookId;
	private String title;
	private String author;
	private float price;
	
	public Book(int BookId,String Title,String Author, float Price) {
		this.bookId = BookId;
		this.title = Title;
		this.author = Author;
		this.price = Price;
	}
	
	public void DisplayBook() {
		System.out.println("BookID :: "+ bookId);
		System.out.println("Title :: "+ title);
		System.out.println("author :: "+ author);
		System.out.println("price :: "+ price);
	}
}
