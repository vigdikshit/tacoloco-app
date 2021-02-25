package com.tacoLoco.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tacoLoco.app.model.Item;
import com.tacoLoco.app.model.Messages;

@Service
public class ItemService {
	
	@Autowired
	private Item itemMenu;

	public String addItem(Item item) {
		if(!itemMenu.checkItem(item.getItem())) {
			itemMenu.addItems(item.getItem(), item.getPrice());
			return Messages.ITEM_ADDED;
		}
		return Messages.ITEM_EXISTS;
	}

	public String removeItem(String itemName) {
		if(!itemMenu.checkItem(itemName)) {
			return Messages.ITEM_NOT_FOUND;
		}
		itemMenu.removeItems(itemName);
		return Messages.ITEM_REMOVED;
	}

	public Map<String, Double> getItems() {
		return itemMenu.getItems();
	}
	

}
