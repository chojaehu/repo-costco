package com.mamamoo.infra.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersController {
	@Autowired
	OrdersService service;
	
	
	@RequestMapping(value = "/ordersList")
	public String ordersList(OrdersDto dto, Model model) {
		
		model.addAttribute("list", service.selectList(dto));
		
		return "/v1/infra/order/ordersSdmList";
	}
}
