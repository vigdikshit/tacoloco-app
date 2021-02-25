package com.tacoLoco.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tacoLoco.app.model.Item;
import com.tacoLoco.app.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody Item item){
		return itemService.addItem(item);
	}
	
	@GetMapping("/getItems")
	public Map<String, Double> getItems(){
		return itemService.getItems();
	}
	
	@DeleteMapping("/removeItem")
	public String removeItem(@RequestParam(value = "item") String item){
		return itemService.removeItem(item);
	}
}
