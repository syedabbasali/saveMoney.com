package com.saveMoney.application;

import java.io.File;
import java.util.HashMap;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ShopItemPriceRepositoryImpl implements ShopItemPriceRepository<String, String> {

	File dbDir;
	RocksDB db;
	Options options;

	public void initialize() {
		RocksDB.loadLibrary();
		options = new Options();
		options.setCreateIfMissing(true);
	}

	@Override
	public void save(String key, String value) {
		try {
			db.put(key.getBytes(), value.getBytes());
		} catch (RocksDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String find(String key) {
		try {
			String result= new String (db.get(key.getBytes()));
			return result;
		} catch (RocksDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	public void itemList(HashMap<String, String> itemList, String username) {
		try {
			db = RocksDB.open(options,username);
			for (String key : itemList.keySet()) {
			   save(key, itemList.get(key));
			}
		} catch (RocksDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
