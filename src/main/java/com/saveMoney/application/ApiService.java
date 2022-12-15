package com.saveMoney.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ApiService {

	@Autowired
	DbShops Dbshops;
	


	public String handleRegisterShop(RegisterShop registershop) {
		Dbshops.setUsername(registershop.getUsername());
		Dbshops.setPassword(registershop.getPassword());
		Dbshops.setShop_type(registershop.getShop_type());
		Dbshops.setShop_name(registershop.getShop_name());
		Dbshops.setShop_address(registershop.getShop_address());
		Dbshops.setShop_postcode(registershop.getShop_postcode());
		Dbshops.setShop_longitude(registershop.getShop_longitude());
		Dbshops.setShop_latitude(registershop.getShop_latitude());
		Dbshops.setShop_crowd_flag(registershop.getShop_crowd_flag());

		String status = Dbshops.writeShops();
		return status;
	}

	public void sortDistance(List<Shop> shoplist){
		
		
		}
	public String updatePersonCount(String username, String count) {

		String status = Dbshops.updatePersonCount(username, count);

		return status;
	}

	public String updateShopStatus(String username, String password, String shop_status) {

		String status = Dbshops.updateShopStatus(username, password, shop_status);
		return status;

	}

	public Shop getShop(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		if (Dbshops == null) {
			return new Shop();
		}
		return shop;
	}

//	public String getShopPassword(String username) {
//		shop.setUsername(username);
//		Shops shop_ = shop.getShop(username);
//		String password_ = shop_.getPassword();
//		return password_;
//	}

	public String getShopAddress(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		if (shop == null) {
			return null;
		}
		String address = shop.getShop_address();
		return address;

	}

	public String getShopType(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String shop_type = shop.getShop_type();
		return shop_type;
	}

	public String getShopName(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String shop_name = shop.getShop_name();
		return shop_name;
	}

	public String getShopPostcode(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String shop_postcode = shop.getShop_postcode();
		return shop_postcode;
	}

	public String getShopLongitude(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String shop_longitude = String.valueOf(shop.getShop_longitude());
		return shop_longitude;
	}

	public String getShopLatitude(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String Shop_latitude = String.valueOf(shop.getShop_latitude());
		return Shop_latitude;
	}

	public String getShopCrowdFlag(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String shop_crowd_flag = String.valueOf(shop.getShop_crowd_flag());
		return shop_crowd_flag;
	}

	public String getShopCrowd(String username) {

		Shop shop = Dbshops.getShopCrowd(username);
		String shop_crowd = String.valueOf(shop.getShop_crowd());
		return shop_crowd;
	}

	public String getShopStatus(String username, String password) {

		Shop shop = Dbshops.getShop(username, password);
		String shop_status = shop.getShop_status();
		return shop_status;
	}

	public List<Shop> getNearByShops(String longitude, String latitude, String postcode, String item,
			String shop_type) {

		List<Shop> shop = Dbshops.getNearByShops(longitude, latitude, postcode, item, shop_type);
		return shop;

	}

}
