package com.saveMoney.application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//import java.io.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;



@RestController

public class ApiController {
	@Autowired
	private ApiService apiService;

	// Method for reaching Home using REST API
	@CrossOrigin
	@RequestMapping("/savemoney")
	public String getHome() {
		return "home.jsp";
	}

	// Method for Registering superMarket
	@CrossOrigin
	@PostMapping("/registershop")
	public String registerShop(@RequestBody RegisterShop registershop) {
		String status;
//		String returnCode = " (CODE 409)" ;
		// registershop.setPassword("let there be wind");
		System.out.println("Lets see what we got " + registershop.getPassword());
		try {
			status = apiService.handleRegisterShop(registershop);
		} catch (Exception e) {
			status = e.getMessage();
//			returnCode = " (CODE 409)";
		}
		System.out.println(status);
		return status;
	}

	// Method for count of person at SuperMarket
	@GetMapping(value = "/shop/update_person_count/username={username}/count={count}/event={event}", produces = {
			"application/json" })
	public String updatePersonCount(@PathVariable String username, @PathVariable String count,@PathVariable String event) {
		String status;
		try {
			status = apiService.updatePersonCount(username, count, event );
		} catch (Exception e) {
			status = e.getMessage();
		}
		return status;
	}

	// Method for shop_status at SuperMaÏrket
	@PostMapping(value = "/shop/update_shop_status/username={username}/password={password}/status={status}", produces = {
			"application/json" })
	public String updateShopStatus(@PathVariable String username, @PathVariable String password,
			@PathVariable String status) {
		String return_status;
		try {
			return_status = apiService.updateShopStatus(username, password, status);
		} catch (Exception e) {
			return_status = e.getMessage();
		}
		return return_status;
	}

	@PostMapping(value = "/shop/get_shop/username={username}/password={password}", produces = { "application/json" })
	public Shop getShop(@PathVariable String username, @PathVariable String password) {
		try {
			Shop shop = apiService.getShop(username, password);

			if (shop == null) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, "FORBIDDEN!!");
			}
			System.out.println(shop.getUsername());
			return shop;
		} catch (ResponseStatusException e) {

			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "FORBIDDEN!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

		}

	}

//	@GetMapping(value = "/shop/get_shop_password/username={username}/password={password}", produces = { "application/json" })
//	public String getShopPassword(@PathVariable String username,@PathVariable String password) {
//		String result;
//		try {
//			result = apiService.getShopPassword(username,password);
//		} catch (Exception e) {
//			result = e.getMessage();
//		}
//		return result;
//	}

	@GetMapping(value = "/shop/get_shop_type/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopType(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopType(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_name/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopName(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopName(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// Method for getting address of user through longitude and latitude
	@GetMapping(value = "/shop/get_shop_address/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopAddress(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopAddress(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_postcode/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopPostcode(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopPostcode(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_longitude/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopLongitude(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopLongitude(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_latitude/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopLatitude(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopLatitude(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_crowd_flag/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopCrowdFlag(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopCrowdFlag(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_crowd/username={username}", produces = { "application/json" })
	public String getShopCrowd(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopCrowd(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_status/username={username}/password={password}", produces = {
			"application/json" })
	public String getShopStatus(@PathVariable String username, @PathVariable String password) {
		String result;
		try {
			result = apiService.getShopStatus(username, password);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

//	@PostMapping("/upload-itemlist")
//	public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
//		
//		System.out.println(file.getOriginalFilename());
//		 String fileName = file.getOriginalFilename();
//	        List<Itemlist> beans;
//			try {
//				beans = new CsvToBeanBuilder(new FileReader(fileName))
//				        .withType(Itemlist.class)
//				        .build()
//				        .parse();
//				beans.forEach(System.out::println);
//				
//			} catch (IllegalStateException | FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	@GetMapping(value = "/shop/get_nearby_shops/longitude={longitude}/latitude={latitude}/postcode={postcode}/item={item}/shop_type={shop_type}", produces = {
			"application/json" })
	public List<Shop> getNearbyShops(@PathVariable String longitude, @PathVariable String latitude,
			@PathVariable String postcode, @PathVariable String item, @PathVariable String shop_type) {
		try {
			List<Shop> shops = apiService.getNearByShops(longitude, latitude, postcode, item, shop_type);
			return shops;
		} catch (Exception e) {
			System.out.print("abcd");
			return null;
		}

	}
	


	@PostMapping(value = "/shop/update_password/username={username}/oldpassword={oldpassword}/newpassword={newpassword}", produces = {

			"application/json" })

	public String update_password(@PathVariable String username, @PathVariable String oldpassword,

			@PathVariable String newpassword) {

		String return_status;

		try {

			return_status = apiService.updatePassword(username, oldpassword, newpassword);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shoptype/username={username}/password={password}/shoptype={shoptype}", produces = {

			"application/json" })

	public String update_shoptype(@PathVariable String username, @PathVariable String password,
			@PathVariable String shoptype) {

		String return_status;

		try {

			return_status = apiService.updateShopType(username, password, shoptype);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shopname/username={username}/password={password}/shopname={shopname}", produces = {

			"application/json" })

	public String update_shopname(@PathVariable String username, @PathVariable String password,
			@PathVariable String shopname) {

		String return_status;

		try {

			return_status = apiService.updateShopName(username, password, shopname);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shopaddress/username={username}/password={password}/shopaddress={shopaddress}", produces = {

			"application/json" })

	public String update_shopaddress(@PathVariable String username, @PathVariable String password,
			@PathVariable String shopaddress) {

		String return_status;

		try {

			return_status = apiService.updateShopAddress(username, password, shopaddress);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shoppostcode/username={username}/password={password}/shoppostcode={shoppostcode}", produces = {

			"application/json" })

	public String update_shoppostcode(@PathVariable String username, @PathVariable String password,
			@PathVariable String shoppostcode) {

		String return_status;

		try {

			return_status = apiService.updateShopPostCode(username, password, shoppostcode);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shoplongitude/username={username}/password={password}/shoplongitude={shoplongitude}", produces = {

			"application/json" })

	public String update_shoplongitude(@PathVariable String username, @PathVariable String password,
			@PathVariable String shoplongitude) {

		String return_status;

		try {

			return_status = apiService.updateShopLongitude(username, password, shoplongitude);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shoplatitude/username={username}/password={password}/shoplatitude={shoplatitude}", produces = {

			"application/json" })

	public String update_shoplatitude(@PathVariable String username, @PathVariable String password,
			@PathVariable String shoplatitude) {

		String return_status;

		try {

			return_status = apiService.updateShopLatitude(username, password, shoplatitude);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/update_shop_crowd_flag/username={username}/password={password}/shop_crowd_flag={shop_crowd_flag}", produces = {

			"application/json" })

	public String updateshop_crowd_flag(@PathVariable String username, @PathVariable String password,
			@PathVariable String shop_crowd_flag) {

		String return_status;

		try {

			return_status = apiService.updateShopCrowdFlag(username, password, shop_crowd_flag);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

	@PostMapping(value = "/shop/upload_item_list/username={username}/password={password}", produces = {
			"application/json" })

	public String uploadItelList(@PathVariable String username, @PathVariable String password,
			@RequestParam("file") MultipartFile file) {

		String return_status = null;

		try {

			Path fileStorageLocation = Paths.get("item_list").toAbsolutePath().normalize();

			Files.createDirectories(fileStorageLocation);

			String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());

			String fileName = originalFileName;

			Path targetLocation = fileStorageLocation.resolve(fileName);
			System.out.println(targetLocation.toString());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {

			return_status = e.getMessage();

		}

		return return_status;

	}

}