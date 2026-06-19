package com.samvas;

public class Address {
		private String city;
	    private String state;

	    public Address(String city, String state) {
	        this.city = city;
	        this.state = state;
	    }

	    public void display() {
	        System.out.println("City  : " + city);
	        System.out.println("State : " + state);
	    }
	}

