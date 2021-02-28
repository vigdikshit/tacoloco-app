package com.tacoLoco.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tacoLoco.app.model.Item;
import com.tacoLoco.app.model.Messages;

/**
 * @author dikshit
 *
 */
@Service
public class ItemService {
	
	@Autowired
	private Item itemMenu;

	/**
	 * Add item to the menu
	 * @param item This parameter is passed to add item object which contains name and price
	 * @return String
	 */
	public String addItem(Item item) {
		String message = "";
		if(!itemMenu.checkItem(item.getName())) {
			message =  Messages.ITEM_ADDED;
		}else {
			message =  Messages.ITEM_UPDATED;
		}
		
		itemMenu.addItems(item.getName(), item.getPrice());
		return message;
	}

	/**
	 * Remove item from the menu
	 * @param itemName
	 * @return String
	 */
	public String removeItem(String itemName) {
		if(!itemMenu.checkItem(itemName)) {
			return Messages.ITEM_NOT_FOUND;
		}
		
		itemMenu.removeItems(itemName);
		return Messages.ITEM_REMOVED;
	}

	/**
	 * To get items present in menu with their price
	 * @return Map<String, Double> with item name as key and price as value
	 */
	public Map<String, Double> getItems() {
		return itemMenu.getItems();
	}
	

}
