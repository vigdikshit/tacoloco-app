package com.tacoLoco.app.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;



@Component
public class Item {

	private String name;
	private Double price;
	
	private Map<String, Double> items;

	public Item() {
		items = new HashMap<>();
	}

	/**
	 * @param items
	 */
	public Item(Map<String, Double> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void addItems(String item, Double d) {
		items.put(item, d);
	}

	public void removeItems(String item) {
		items.remove(item);
	}

	public Map<String, Double> getItems() {
		return items;
	} 
	
	public Boolean checkItem(String item) {
		if(!items.containsKey(item)) {
			return false;
		}
		return true;
	}
}
