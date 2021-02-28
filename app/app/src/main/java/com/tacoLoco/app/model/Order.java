package com.tacoLoco.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private List<OrderQuantity> order;

	public List<OrderQuantity> getOrder() {
		return order;
	}

	public void setOrder(List<OrderQuantity> order) {
		this.order = order;
	}
	
	
}
