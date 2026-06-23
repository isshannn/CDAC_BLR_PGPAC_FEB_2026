package com.samvas.XML_Config_DI;

public class Library {
	private String libraryName;
	private String location;
	private Book book;
	
	public Library(String LibName, String loc, Book book_obj) {
		this.libraryName = LibName;
		this.location = loc;
		this.book = book_obj;
	}
	
	public void displayLib() {
		System.out.println("Library Name : "+ libraryName);
		System.out.println("Location : "+ location);
		System.out.println("Book Details"); 
		System.out.println("------------- "); 
		book.DisplayBook();
	}
}
