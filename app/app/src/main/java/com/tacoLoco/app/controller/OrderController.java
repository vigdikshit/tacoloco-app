package com.tacoLoco.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tacoLoco.app.model.OrderList;
import com.tacoLoco.app.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orderTotal")
	public Double calculateOrderTotal(@RequestBody OrderList orderList) {
		return orderService.calculateOrderTotal(orderList);
	}
}
