package com.tacoLoco.app.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class Item {

	private String item;
	private Double price;
	
	@JsonIgnore
	private Map<String, Double> items;

	public Item() {
		items = new HashMap<>();
	}

	public Item(Map<String, Double> items) {
		this.items = items;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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
