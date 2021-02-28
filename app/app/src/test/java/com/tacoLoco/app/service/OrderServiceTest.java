package com.tacoLoco.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tacoLoco.app.model.Item;
import com.tacoLoco.app.model.Order;
import com.tacoLoco.app.model.OrderQuantity;
import com.tacoLoco.app.service.ItemService;
import com.tacoLoco.app.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceTest {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private Item item;
	
	@Test
	public void testCalculateOrderTotal() throws Exception {
		item.addItems("chicken", 3.0);
		itemservice.addItem(item);
		item.addItems("veggie", 3.5);
		itemservice.addItem(item);
		OrderQuantity oq = new OrderQuantity();
		Order ol = new Order();
		List<OrderQuantity> oqList = new ArrayList<>();
		oq.setItemName("chicken");
		oq.setQuantity(2);
		oqList.add(oq);
		OrderQuantity oq1 = new OrderQuantity();
		oq1.setItemName("veggie");
		oq1.setQuantity(2);
		oqList.add(oq1);
		ol.setOrder(oqList);
		String s = orderService.calculateOrderTotal(ol);
		assertEquals(s, "10.40$");
	}

}
