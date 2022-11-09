package com.saveMoney.application;

public interface ShopItemPriceRepository<K, V> {
	void save(K key, V value);

	V find(K key);

	void delete(K key);
}