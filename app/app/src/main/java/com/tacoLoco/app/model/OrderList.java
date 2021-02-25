package com.tacoLoco.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderList {

	private List<OrderQuantity> orders;

	public List<OrderQuantity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderQuantity> orders) {
		this.orders = orders;
	}
	
	
}
