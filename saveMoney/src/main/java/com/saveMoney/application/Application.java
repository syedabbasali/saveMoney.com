package com.saveMoney.application;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) {
		ShopItemPriceRepositoryImpl sipr = new ShopItemPriceRepositoryImpl();
		
		sipr.initialize();
		
		HashMap <String, String> abcd =new HashMap<String, String>();
		abcd.put("Toothpaste", "200");
		abcd.put("Toothbrush", "20");
		sipr.itemList(abcd,"Abbas");
		System.out.println(sipr.find("Toothpaste"));
	}
}