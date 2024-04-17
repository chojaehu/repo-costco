package com.mamamoo.infra.myorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mamamoo.common.util.UtilFunction;


@Controller
public class MyOrderController {

	@Autowired
	MyorderService service;
	
	String str = "/infra/v1/myorder";
	
	@RequestMapping(value = "/myOrderSdmList")
	public String myOrderSdmList(@ModelAttribute("vo") MyOrderVo vo, Model model ,MyOrderDto dto)throws Exception
	{
		UtilFunction.setSearch(vo);
		model.addAttribute("list", service.selectList(vo));
		return str + "/myOrderSdmList";
	}
	
	public void setUrl(MyOrderVo vo) throws Exception {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("shDelNy"      , vo.getShDelNy())
				.queryParam("shOptionDate" , vo.getShOptionDate())
				.queryParam("shDateStart"  , vo.getShDateStart())
				.queryParam("shDateEnd"    , vo.getShDateEnd())
				.queryParam("shReceive"    , vo.getShReceive())
				.queryParam("shOption"     , vo.getShOption())
				.queryParam("shValue"      , vo.getShValue())
				.build();
		vo.setUri("&"+uri.toUriString().substring(1, uri.toUriString().length()));
	}
	
}
