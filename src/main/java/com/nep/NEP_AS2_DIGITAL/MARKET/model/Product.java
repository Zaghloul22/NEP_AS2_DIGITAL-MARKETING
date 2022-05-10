package com.nep.NEP_AS2_DIGITAL.MARKET.model;



public class Product {
	
	
	private int ID;
	private String name;
	private double price;
	private String type;
	
	public Product(int ID, String name, double price, String type) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID =ID;
	}
	
	

}
