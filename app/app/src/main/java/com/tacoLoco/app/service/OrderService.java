package com.tacoLoco.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacoLoco.app.exceptions.InvalidOrderQuantityException;
import com.tacoLoco.app.model.Item;
import com.tacoLoco.app.model.Messages;
import com.tacoLoco.app.model.Order;
import com.tacoLoco.app.model.OrderQuantity;

/**
 * @author dikshit
 *
 */
@Service
public class OrderService {
	
	@Autowired
	private Item item;

	/**
	 * This is used to calculate total order amount
	 * @param orderList
	 * @return String : This is the total order amount converted to string
	 */
	public String calculateOrderTotal(Order order) {
		
		Double totalAmount = 0D;
		Integer totalQuantity = 0;
		for(OrderQuantity oq : order.getOrder()) {
			String itemName = oq.getItemName();
			Integer quantity = oq.getQuantity();
			if(quantity < 0) {
				throw new InvalidOrderQuantityException(Messages.ERROR_INVALID_ORDER_QUANTITY);
			}
			Double price = item.getItems().get(itemName);
			totalAmount += quantity * price;
			totalQuantity += quantity;
		}
		
		if(totalQuantity >= 4) {
			totalAmount = totalAmount * 0.8;
		}
		String s = String.format("%.2f", totalAmount);

		return s + "$";
	}

	
}
