package com.saveMoney.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

	@Autowired
	SuperMarket sm;

	@Autowired
	GasStation gs;

	public void handleRegisterSuperMarket(RegisterSuperMarket rsm) {
		sm.setUsername(rsm.getUsername());
		sm.setPassword(rsm.getPassword());
		sm.setShop_name(rsm.getShop_name());
		sm.setShop_address(rsm.getShop_address());
		sm.setShop_longitutde(rsm.getShop_latitude());
		sm.setShop_latitude(rsm.getShop_longitutde());

		sm.writeSuperMarket();
	}

	public void handleRegisterGasStation(RegisterGasStation rgs) {
		gs.setUsername(rgs.getUsername());
		gs.setPassword(rgs.getPassword());
		gs.setStation_name(rgs.getStation_name());
		gs.setStation_address(rgs.getStation_address());
		gs.setStation_longitutde(rgs.getStation_longitutde());
		gs.setStation_latitude(rgs.getStation_latitude());

		gs.writeGasStation();
	}

	public void updatePersonCountSuperMarket(String username, int count) {
		sm.setUsername(username);
		sm.setShop_crowd(count);

		sm.updatePersonCount();
	}

	public void updateStatusSuperMarket(String username, String shop_status) {
		sm.setUsername(username);
		sm.setShop_status(shop_status);

		sm.updateShopStatus();

	}
	
	public void updatePersonCountGasStation(String username, int count) {
		gs.setUsername(username);
		gs.setStation_crowd(count);
		
		gs.updatePersonCountGasStation();
	}
	
	public void updateStatusGasStation(String gasStation_name, String gasStationStatus) {
		gs.setStation_name(gasStation_name);
		gs.setStation_status(gasStationStatus);
		
		gs.updateGasStationStatus();
		
	}

	public String getAddressSuperMarket(String username) {
		sm.setUsername(username);
		String address = sm.getAddressSuperMarket(username);
		return address;
	}
	
	
}
