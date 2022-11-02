package com.saveMoney.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GasStation {

	@Autowired
	private JdbcTemplate jt;

	private String password;
	private String station_name;
	private String station_address;
	private String station_longitutde;
	private String station_latitude;
	private int station_crowd;
	private String station_status;

	public GasStation() {
		this.station_crowd = 0;
		this.station_status = "open";
	}

	private String username;

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

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_address() {
		return station_address;
	}

	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}

	public String getStation_longitutde() {
		return station_longitutde;
	}

	public void setStation_longitutde(String station_longitutde) {
		this.station_longitutde = station_longitutde;
	}

	public String getStation_latitude() {
		return station_latitude;
	}

	public void setStation_latitude(String station_latitude) {
		this.station_latitude = station_latitude;
	}

	public int getStation_crowd() {
		return station_crowd;
	}

	public void setStation_crowd(int station_crowd) {
		this.station_crowd = station_crowd;
	}

	public String getStation_status() {
		return station_status;
	}

	public void setStation_status(String station_status) {
		this.station_status = station_status;
	}

	public void writeGasStation() {

		String query = "INSERT INTO gas_stations (username,password,station_name,station_address,station_longitutde,station_latitude,station_crowd,station_status ) VALUES (?,?,?,?,?,?,?,?)";
		jt.update(query, username, password, station_name, station_address, station_longitutde, station_latitude,
				station_crowd, station_status);

	}

	public void updatePersonCountGasStation() {
		String query ="UPDATE gas_stations SET station_crowd = " + String.valueOf(this.station_crowd) + " WHERE username = '" + this.username + "'";
		jt.update(query);
		
	}

	public void updateGasStationStatus() {
		String query ="UPDATE gas_stations SET station_status = '" + this.station_status + "' WHERE username = '" + this.username+ "'";
		jt.update(query);
		
	}

}
