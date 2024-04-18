package com.mamamoo.infra.myorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mamamoo.common.constants.Constants;
import com.mamamoo.common.util.UtilFunction;
@Controller
public class MyOrderController {

	@Autowired
	MyorderService service;
	
	String str = "/infra/v1/myorder";
	
//	발주 리스트 페이지
	@RequestMapping(value = "/myOrderList")
	public String myOrderSdmList(@ModelAttribute("vo") MyOrderVo vo, Model model)throws Exception
	{
		UtilFunction.setSearch(vo);
		model.addAttribute("list", service.selectList(vo));
		return Constants.PATH_MYORDER + "myOrderSdmList";
	}
	
//	발주 등록 페이지
	@RequestMapping(value = "/myOrderCreate")
	public String myOrderSdmCreate()throws Exception
	{
		return Constants.PATH_MYORDER + "myOrderSdmCreate";
	}
	
//	발주 디테일 리스트 페이지
	@RequestMapping(value = "/myOrderDetailList")
	public String myOrderDetailSdmList(@ModelAttribute("vo") MyOrderVo vo, Model model ) throws Exception
	{
		UtilFunction.setSearch(vo);
		model.addAttribute("list", service.myorderdetailList(vo));
		return Constants.PATH_MYORDER + "myOrderDetailSdmList";
	}
	
//	발주 수정 페이지
	@RequestMapping(value= "/myOrderDetailForm")
	public String myOrderDetailSdmForm(Model model, MyOrderDto dto)throws Exception
	{
		model.addAttribute("item", service.myorderdetailitem(dto));
		return Constants.PATH_MYORDER + "myOrderDetailSdmForm";
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
