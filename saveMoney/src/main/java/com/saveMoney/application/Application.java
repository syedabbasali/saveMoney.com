package com.saveMoney.application;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner{


	@Autowired
	SuperMarket sm ;
	
	@Autowired
	GasStation gs;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		System.out.println("Hello Springboot");
	 
		
	}
	@Override
	public void run(String... args) {
		
//		this.sm = new SuperMarket();
		this.sm.setUsername("TestUSer3");
		this.sm.setPassword("TestPassword3");
		this.sm.setShop_name("TestShop3");
		this.sm.setShop_address("TestAddress3");
		this.sm.setShop_longitutde("TestLong3");
		this.sm.setShop_latitude("TestLat3");
		
//		this.sm.writeSuperMarket();
		
		
		
		this.gs.setUsername("TestUserName");
		this.gs.setPassword("TestPassword");
		this.gs.setStation_name("TestGasStationName");
		this.gs.setStation_address("TestGsAddress");
		this.gs.setStation_longitutde("TestLongitude");
		this.gs.setStation_latitude("TestLatitude");
		
		
//		this.gs.writeGasStation();
		
		
		
		
	}
}
