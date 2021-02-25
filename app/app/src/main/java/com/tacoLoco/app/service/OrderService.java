package com.tacoLoco.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacoLoco.app.model.Item;
import com.tacoLoco.app.model.OrderList;
import com.tacoLoco.app.model.OrderQuantity;

@Service
public class OrderService {
	
	@Autowired
	private Item item;

	public Double calculateOrderTotal(OrderList orderList) {
		
		Double totalAmount = 0D;
		Integer totalQuantity = 0;
		System.out.println(orderList);
		for(OrderQuantity oq : orderList.getOrders()) {
			String itemName = oq.getItem();
			Integer quantity = oq.getQuantity();
			Double price = item.getItems().get(itemName);
			totalAmount += quantity * price;
			totalQuantity += quantity;
		}
		
		if(totalQuantity >= 4) {
			totalAmount = totalAmount * 0.8;
		}
		return totalAmount;
	}

	
}
