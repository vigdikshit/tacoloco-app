package com.tacoLoco.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.tacoLoco.app.model.Order;
import com.tacoLoco.app.model.OrderQuantity;
import com.tacoLoco.app.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private OrderService orderService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}
	
	@Test
	public void testTotalAmount() throws Exception {
		OrderQuantity oq = new OrderQuantity();
		Order ol = new Order();
		List<OrderQuantity> oqList = new ArrayList<>();
		oq.setItemName("chicken");
		oq.setQuantity(2);
		oqList.add(oq);
		oq.setItemName("veggie");
		oq.setQuantity(3);
		oqList.add(oq);
		ol.setOrder(oqList);
		String result = "17.60$";
		Gson gson = new Gson();
		String json = gson.toJson(ol);
		Mockito.when(orderService.calculateOrderTotal(ol)).thenReturn(result);
		mvc.perform(MockMvcRequestBuilders.post("/order/orderTotal").content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().equals(result);
	}
}
