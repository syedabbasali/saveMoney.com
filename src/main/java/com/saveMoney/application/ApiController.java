package com.saveMoney.application;

//import java.io.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
		String returnCode = " (CODE 409)" ;
		//registershop.setPassword("let there be wind");
		System.out.println("Lets see what we got "+ registershop.getPassword());
		try {
			status = apiService.handleRegisterShop(registershop);
		} catch (Exception e) {
			status = e.getMessage();
			returnCode = " (CODE 409)";
		}
		System.out.println(status + returnCode);
		return status + returnCode;
	}

	// Method for count of person at SuperMarket
	@GetMapping(value = "/shop/update_person_count/username={username}/count={count}", produces = {
			"application/json" })
	public String updatePersonCount(@PathVariable String username, @PathVariable String count) {
		String status;
		try {
			status = apiService.updatePersonCount(username, Integer.parseInt(count));
		} catch (Exception e) {
			status = e.getMessage();
		}
		return status;
	}

	// Method for shop_status at SuperMaÏrket
	@PostMapping(value = "/shop/update_shop_status/username={username}/status={status}", produces = {
			"application/json" })
	public String updateShopStatus(@PathVariable String username, @PathVariable String status) {
		String return_status;
		try {
			return_status = apiService.updateShopStatus(username, status);
		} catch (Exception e) {
			return_status = e.getMessage();
		}
		return return_status;
	}

	@GetMapping(value = "/shop/get_shop/username={username}", produces = { "application/json" })
	public Shop getShop(@PathVariable String username) {
		try {
			Shop shop = apiService.getShop(username);
			System.out.print(shop.getUsername());
			return shop;
		} catch (Exception e) {
			System.out.print("abcd");
			return null;
		}

	}

	@GetMapping(value = "/shop/get_shop_password/username={username}", produces = { "application/json" })
	public String getShopPassword(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopPassword(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_type/username={username}", produces = { "application/json" })
	public String getShopType(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopType(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_name/username={username}", produces = { "application/json" })
	public String getShopName(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopName(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// Method for getting address of user through longitude and latitude
	@GetMapping(value = "/shop/get_shop_address/username={username}", produces = { "application/json" })
	public String getShopAddress(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopAddress(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_postcode/username={username}", produces = { "application/json" })
	public String getShopPostcode(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopPostcode(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_longitude/username={username}", produces = { "application/json" })
	public String getShopLongitude(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopLongitude(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_latitude/username={username}", produces = { "application/json" })
	public String getShopLatitude(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopLatitude(username);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@GetMapping(value = "/shop/get_shop_crowd_flag/username={username}", produces = { "application/json" })
	public String getShopCrowdFlag(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopCrowdFlag(username);
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

	@GetMapping(value = "/shop/get_shop_status/username={username}", produces = { "application/json" })
	public String getShopStatus(@PathVariable String username) {
		String result;
		try {
			result = apiService.getShopStatus(username);
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

	        
		
		
		
		
		
//		 System.out.println(file.getName());
		 
//		// parse CSV file to create a list of `User` object
//		  try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
////		try (CSVReader reader = new CSVReader(new FileReader(file.getName()+".csv"))) {
//
//			// create csv bean reader
//			
//			CsvToBean<Itemlist> csvToBean = new CsvToBeanBuilder<Itemlist>(reader).withType(Itemlist.class).withIgnoreLeadingWhiteSpace(true).build();
//			
//			String[] lineInArray;
//		      while ((lineInArray = reader.readNext()) != null) {
//		    	  
//		          System.out.println(lineInArray[0] + lineInArray[1] + "etc...");
//		      }
//
////			 convert `CsvToBean` object to list of users
//			List<Itemlist> itemlist = csvToBean.parse();
//			System.out.println(itemlist.get(0).getItem());
//			for(Itemlist i : itemlist) {
//				System.out.println(i.getItem()+ " , " + i.getPrice());
//			}
//
//			// TODO: save users in DB?
//
//			// save users list on model
//
//		} catch (Exception ex) {
//
//		}
//		return "result";
//	}
}
