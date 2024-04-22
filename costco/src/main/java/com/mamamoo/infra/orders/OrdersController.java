package com.mamamoo.infra.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mamamoo.common.constants.Constants;
import com.mamamoo.common.util.UtilFunction;
import com.mamamoo.infra.code.CodeDto;

@Controller
public class OrdersController {
	@Autowired
	OrdersService service;
	
// 주문리스트
	@RequestMapping(value = "/orderList")
	public String ordersList(@ModelAttribute("vo") OrdersVo vo, OrdersDto dto, Model model)throws Exception {
		
		UtilFunction.setSearch(vo);
		
		int rowCount = service.getCount(vo);
		
		if(rowCount > 0) {			
			vo.setPagingVo(rowCount);
			
			model.addAttribute("list", service.selectList(vo));
			
		};
		
		return Constants.PATH_ORDERS + "orderList";
	}
// 상세주문리스트
	@RequestMapping(value = "/orderDetailList")
	public String orderDetailList(@ModelAttribute("vo") OrdersVo vo, OrdersDto dto, Model model)throws Exception {
		
		UtilFunction.setSearch(vo);
		
		int rowCount = service.getCountOrt(vo);
		
		if(rowCount > 0) {			
			vo.setPagingVo(rowCount);
			
			model.addAttribute("list", service.selectListOrt(vo));
			
		};
		
		return Constants.PATH_ORDERS + "orderDetailList";
	}
	
//	등록화면
	@RequestMapping(value = "/orderCreate")
	public String orderCreate(OrdersDto dto, Model model) throws Exception {
	
		
		
		return Constants.PATH_ORDERS + "orderCreate";
	}
	
//	주문등록
	@RequestMapping(value = "/orderInsert")
	public String orderInsert(OrdersDto dto) throws Exception {
		
		service.insertOrt(dto);
		service.insertOrd(dto);
		
		return "redirect:/orderList";
	}
	
	
	
}
