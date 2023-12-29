package com.saveMoney.application;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class DbShops {

	@Autowired
	private JdbcTemplate jt;

	private String username;
	private String password;
	private String shop_type;
	private String shop_name;
	private String shop_address;
	private String shop_postcode;
	private double shop_longitude;
	private double shop_latitude;
	private int shop_crowd_flag;
	private int shop_crowd;
	private String shop_status;

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

	public double getShop_longitude() {
		return shop_longitude;
	}

	public void setShop_longitude(double shop_longitude) {
		this.shop_longitude = shop_longitude;
	}

	public double getShop_latitude() {
		return shop_latitude;
	}

	public void setShop_latitude(double shop_latitude) {
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

	// Constructor
	public DbShops() {
		this.shop_crowd = 0;
		this.shop_status = "open";
	}

	// Constructor with field
	public DbShops(String username, String password, String shop_type, String shop_name, String shop_address,
			String shop_postcode, double shop_longitude, double shop_latitude, int shop_crowd_flag) {

		this.username = username;
		this.password = password;
		this.shop_type = shop_type;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_postcode = shop_postcode;
		this.shop_longitude = shop_longitude;
		this.shop_latitude = shop_latitude;
		this.shop_crowd_flag = shop_crowd_flag;
	}

	public String writeShops() {
		String query = "INSERT INTO  shops (username,password,shop_type,shop_name,shop_address,shop_postcode,shop_longitude,shop_latitude,shop_crowd_flag,shop_crowd,shop_status ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int dbwritestatus = jt.update(query, username, password, shop_type, shop_name, shop_address, shop_postcode,
					shop_longitude, shop_latitude, shop_crowd_flag, shop_crowd, shop_status);
			if (dbwritestatus == 0) {
				return "failed to register shop";
			} else {
				return "shop registered successfully!!!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String updatePersonCount(String username, String shop_crowd, String event) {
		String query = "UPDATE shops SET shop_crowd = " + shop_crowd + " WHERE username = '" + username + "'";
		String query2 = "INSERT INTO shops_crowd(username, shop_crowd,event) VALUES ('" + username + "','" + shop_crowd
				+ "','" + event + "')";
		try {
			int dbwritestatus = jt.update(query);
			int dbwritestatus2 = jt.update(query2);
			if (dbwritestatus == 0) {
				return "failed to update count";
			} else {
				return "count updated succesfully!!!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String updateShopStatus(String username, String password, String shop_status) {
		String query = "UPDATE shops SET shop_status = '" + shop_status + "' WHERE username = '" + username
				+ "' and password = '" + password + "'";
		try {
			int dbwritestatus = jt.update(query);
			if (dbwritestatus == 0) {
				return "failed to update shop status";
			} else {
				return "shop status updated succesfully!!!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public Shop getShop(String username, String password) {
		String query = "SELECT * FROM shops WHERE username = '" + username + "' and password = '" + password + "'";
		try {
			List<Shop> shop = jt.query(query, new BeanPropertyRowMapper<Shop>(Shop.class));
			return shop.get(0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Shop getShopCrowd(String username) {
		String query = "SELECT * FROM shops WHERE username = '" + username + "'";
		try {
			List<Shop> shop = jt.query(query, new BeanPropertyRowMapper<Shop>(Shop.class));
			return shop.get(0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Shop> getNearByShops(String longitude, String latitude, String postcode, String item,
			String shop_type) {

		if (postcode != null && !postcode.isEmpty() ) {

			String query = "SELECT * FROM shops WHERE shop_postcode ='" + postcode + "'";
			try {
				List<Shop> shops = jt.query(query, new BeanPropertyRowMapper<Shop>(Shop.class));
				return shops;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}

		}

		if (longitude != null && latitude != null && !longitude.isEmpty() && !latitude.isEmpty()) {

			try {

				Double lon_upper = Double.parseDouble(longitude) + 0.12;
				Double lat_upper = Double.parseDouble(latitude) + 0.12;
				Double lon_lower = Double.parseDouble(longitude) - 0.12;
				Double lat_lower = Double.parseDouble(latitude) - 0.12;
				String query = "";
				if (shop_type == null || shop_type.isEmpty()) {
					query = "SELECT * FROM shops WHERE (shop_longitude between " + lon_lower + " and  " + lon_upper
							+ ") AND (shop_latitude between " + lat_lower + " and  " + lat_upper + ")";
				} else {
					query = "SELECT * FROM shops WHERE shop_type ='" + shop_type + "' AND (shop_longitude between "
							+ lon_lower + " and  " + lon_upper + ") AND (shop_latitude between " + lat_lower + " and  "
							+ lat_upper + ")";
				}

				System.out.println(query);

				List<Shop> shops = jt.query(query, new BeanPropertyRowMapper<Shop>(Shop.class));

				for (Shop s : shops) {

					double distance = (double) Math.pow((Double.parseDouble(longitude) - s.getShop_longitude()), 2)
							+ (double) Math.pow((Double.parseDouble(latitude) - s.getShop_latitude()), 2);
					s.setDistance(distance);
					System.out.println(s.getShop_name() + " = " + distance);
				}
				List<Shop> sortedShopList = shops;
				Collections.sort(sortedShopList, new Comparator<Shop>() {

					@Override
					public int compare(Shop o1, Shop o2) {

						return Double.compare(o1.getDistance(), o2.getDistance());
					}

				});

				return sortedShopList;

			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				return null;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}

		} else if (postcode != null && !postcode.isEmpty()) {

		} else {

		}
		return null;
	}

	public String updatePassword(String username, String oldPassword, String newPassword) {

		String query = "UPDATE shops SET password = '" + newPassword + "' WHERE username = '" + username

				+ "' and password = '" + oldPassword + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update password";

			} else {

				return "password updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopType(String username, String password, String shop_type) {

		String query = "UPDATE shops SET shop_type = '" + shop_type + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_type";

			} else {

				return "shop_type updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopName(String username, String password, String shop_name) {

		String query = "UPDATE shops SET shop_name = '" + shop_name + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_name";

			} else {

				return "shop_name updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopAddress(String username, String password, String shop_address) {

		String query = "UPDATE shops SET shop_address = '" + shop_address + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_address";

			} else {

				return "shop_address updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopPostCode(String username, String password, String shop_postcode) {

		String query = "UPDATE shops SET shop_postcode = '" + shop_postcode + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_postcode";

			} else {

				return "shop_postcode updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopLongitude(String username, String password, String shop_longitude) {

		String query = "UPDATE shops SET shop_longitude = '" + shop_longitude + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_longitude";

			} else {

				return "shop_longitude updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopLatitude(String username, String password, String shop_latitude) {

		String query = "UPDATE shops SET shop_latitude = '" + shop_latitude + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_latitude";

			} else {

				return "shop_latitude updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

	public String updateShopCrowdFlag(String username, String password, String shop_crowd_flag) {

		String query = "UPDATE shops SET shop_crowd_flag = '" + shop_crowd_flag + "' WHERE username = '" + username

				+ "' and password = '" + password + "'";

		try {

			int dbwritestatus = jt.update(query);

			if (dbwritestatus == 0) {

				return "failed to update shop_crowd_flag";

			} else {

				return "shop_crowd_flag updated succesfully!!!";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}

}
