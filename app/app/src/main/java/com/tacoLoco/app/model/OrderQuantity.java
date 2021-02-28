package com.tacoLoco.app.model;

import org.springframework.stereotype.Component;

@Component
public class OrderQuantity {

	private String itemName;
	private Integer quantity;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
