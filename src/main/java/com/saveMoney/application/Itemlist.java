package com.saveMoney.application;

public class Itemlist {
	private String item;
	private String price;

	public Itemlist(String item, String price) {

		this.item = item;
		this.price = price;
	}
	
	

	public Itemlist() {
		
	}



	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
