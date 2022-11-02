package com.saveMoney.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@Autowired
	private ApiService apiService;

	// Method for reaching Home using REST API
	@GetMapping("/savemoney")
	public String getHome() {
		return "Welcome to SaveMoney server";
	}

	// Method for Registering superMarket
	@PostMapping("/registersupermarket")
	public RegisterSuperMarket registersupermarket(@RequestBody RegisterSuperMarket rsm) {
		apiService.handleRegisterSuperMarket(rsm);
		return rsm;

	}

	// Method for registering GasStation
	@PostMapping("/registergasstation")
	public RegisterGasStation registergasstation(@RequestBody RegisterGasStation rgs) {
		apiService.handleRegisterGasStation(rgs);
		return rgs;
	}

	// Method for count of person at SuperMarket
	@GetMapping(value = "/supermarket/username={username}/count={count}", produces = { "application/json" })
	public void updatePersonCountSuperMarket(@PathVariable String username, @PathVariable String count) {
		apiService.updatePersonCountSuperMarket(username, Integer.parseInt(count));
		
		//Return type should be Error/Success code...!!!!
	}

	// Method for shop_status at SuperMaÏrket
	@GetMapping(value = "/supermarket/username={username}/shop_status={shop_status}", produces = { "application/json" })
	public String updateStatusSuperMarket(@PathVariable String username, @PathVariable String shop_status) {
		apiService.updateStatusSuperMarket(username, shop_status);
		return "data updated successfully!!!!";

	}

	// Method for count of person at Gas station
	@GetMapping(value = "/gasStation/username={username}/count={count}", produces = { "application/json" })
	public void updatePersonCountGasStation(@PathVariable String username, @PathVariable String count) {
		apiService.updatePersonCountGasStation(username, Integer.parseInt(count));
		
		//Return type should be Error/Success code...!!!!
	}

	// Method for shop_status at Gas station
	@GetMapping(value = "/gasStation/username={username}/gasStation_status={gasStation_status}", produces = {
			"application/json" })
	public String updateStatusGasStation(@PathVariable String username, @PathVariable String gasStation_status) {
		apiService.updateStatusGasStation(username, gasStation_status);
		return "data updated successfully!!!!";
	}
	// Method for getting address of user through longitude and latitude
	@GetMapping(value = "/supermarket/getaddress/username={username}", produces = { "application/json" })
	public String getAddressSuperMarket(@PathVariable String username) {
		String address = apiService.getAddressSuperMarket(username);
		return address;
	}
}
