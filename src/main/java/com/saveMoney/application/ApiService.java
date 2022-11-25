package com.saveMoney.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

	@Autowired
	Shops shop;

	public String handleRegisterShop(RegisterShop registershop) {
		shop.setUsername(registershop.getUsername());
		shop.setPassword(registershop.getPassword());
		shop.setShop_type(registershop.getShop_type());
		shop.setShop_name(registershop.getShop_name());
		shop.setShop_address(registershop.getShop_address());
		shop.setShop_postcode(registershop.getShop_postcode());
		shop.setShop_longitutde(registershop.getShop_latitude());
		shop.setShop_latitude(registershop.getShop_longitutde());
		shop.setShop_crowd_flag(registershop.getShop_crowd_flag());

		String status = shop.writeShops();
		return status;
	}

	public String updatePersonCount(String username, int count) {
		shop.setUsername(username);
		shop.setShop_crowd(count);

		String status = shop.updatePersonCount();
		
		return status;
	}

	public String updateShopStatus(String username, String shop_status) {
		shop.setUsername(username);
		shop.setShop_status(shop_status);

		String status = shop.updateShopStatus();
		return status;

	}
	
	public String getShopAddress(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String address = shop_.getShop_address();
		return address;
	}

	public Shop getShop(String username) {
		shop.setUsername(username);
		Shops shops = shop.getShop(username);
		if( shops== null) {
			return new Shop();
		}
		Shop shop_=new Shop(shops);
		return shop_;
	}

	public String getShopPassword(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String password = shop_.getPassword();
		return password;
	}

	public String getShopType(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_type = shop_.getShop_type();
		return shop_type;
	}

	public String getShopName(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_name = shop_.getShop_name();
		return shop_name;	}

	public String getShopPostcode(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_postcode = shop_.getShop_postcode();
		return shop_postcode;	}

	public String getShopLongitude(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_longitude = shop_.getShop_longitutde();
		return shop_longitude;
	}

	public String getShopLatitude(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String Shop_latitude = shop_.getShop_latitude();
		return Shop_latitude;
	}

	public String getShopCrowdFlag(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_crowd_flag = String.valueOf(shop_.getShop_crowd_flag());
		return shop_crowd_flag;
	}

	public String getShopCrowd(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_crowd = String.valueOf(shop_.getShop_crowd());
		return shop_crowd;
	}

	public String getShopStatus(String username) {
		shop.setUsername(username);
		Shops shop_ = shop.getShop(username);
		String shop_status = shop_.getShop_status();
		return shop_status;
	}
	
	
}
