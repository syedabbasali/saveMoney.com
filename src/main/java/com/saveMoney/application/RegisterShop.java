package com.saveMoney.application;



public class RegisterShop {

	
	private String username;
	private String password;
	private String shop_type;
	private String shop_name;
	private String shop_address;
	private String shop_postcode;
	private String shop_longitutde;
	private String shop_latitude;
	private int shop_crowd_flag;
	private int shop_crowd;
	private String shop_status;
	
	public RegisterShop() {
		
	}

	public RegisterShop(String username, String password, String shop_type, String shop_name, String shop_address,
			String shop_postcode, String shop_longitutde, String shop_latitude, String shop_crowd_flag) {
		super();
		this.username = username;
		this.password = password;
		this.shop_type = shop_type;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_postcode = shop_postcode;
		this.shop_longitutde = shop_longitutde;
		this.shop_latitude = shop_latitude;
		this.shop_crowd_flag = Integer.parseInt(shop_crowd_flag);
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

	public String getShop_type() {
		return shop_type;
	}

	public void setShop_type(String shop_type) {
		this.shop_type = shop_type;
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

	public String getShop_postcode() {
		return shop_postcode;
	}

	public void setShop_postcode(String shop_postcode) {
		this.shop_postcode = shop_postcode;
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

	public int getShop_crowd_flag() {
		return shop_crowd_flag;
	}

	public void setShop_crowd_flag(int shop_crowd_flag) {
		this.shop_crowd_flag = shop_crowd_flag;
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
