package com.saveMoney.application;

import org.springframework.beans.factory.annotation.Autowired;



public class RegisterSuperMarket {

	
	private String username;	
	private String password;
	private String shop_name;
	private String shop_address;
	private String shop_longitutde;
	private String shop_latitude;
	private int shop_crowd;
	private String shop_status;

	
	public RegisterSuperMarket() {
		
	}

	public RegisterSuperMarket(String username, String password, String shop_name, String shop_address,
			String shop_longitutde, String shop_latitude) {
		
		this.username = username;
		this.password = password;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_longitutde = shop_longitutde;
		this.shop_latitude = shop_latitude;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_address() {
		return shop_address;
	}

	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}

	public String getShop_longitutde() {
		return shop_longitutde;
	}

	public void setShop_longitutde(String shop_longitutde) {
		this.shop_longitutde = shop_longitutde;
	}

	public String getShop_latitude() {
		return shop_latitude;
	}

	public void setShop_latitude(String shop_latitude) {
		this.shop_latitude = shop_latitude;
	}

	public int getShop_crowd() {
		return shop_crowd;
	}

	public void setShop_crowd(int shop_crowd) {
		this.shop_crowd = shop_crowd;
	}

	public String getShop_status() {
		return shop_status;
	}

	public void setShop_status(String shop_status) {
		this.shop_status = shop_status;
	}

}
