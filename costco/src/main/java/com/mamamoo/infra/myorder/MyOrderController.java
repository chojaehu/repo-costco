package com.mamamoo.infra.myorder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value = "/myorderList")
	public String myOrderSdmList(@ModelAttribute("vo") MyOrderVo vo, Model model)throws Exception
	{
		
		int rowCount = service.morCount(vo);
		
		if(rowCount > 0)
		{
			UtilFunction.setSearch(vo);
			model.addAttribute("list", service.selectList(vo));
		}
		return Constants.PATH_MYORDER + "myorderList";
	}
	
//	발주 등록 페이지
	@RequestMapping(value = "/myorderCreate")
	public String myOrderSdmCreate()throws Exception
	{
		return Constants.PATH_MYORDER + "myorderCreate";
	}
	
//	발주 수정 페이지
	@RequestMapping(value = "/myorderForm")
	public String myorderForm(MyOrderDto dto,Model model)throws Exception
	{
		model.addAttribute("item", service.selectOne(dto));
		return Constants.PATH_MYORDER + "myorderForm";
	}
	
//	발주 등록
	@RequestMapping(value ="/myorderinsert")
	public String myorderinsert(MyOrderDto dto)throws Exception
	{
		service.myorderinsert(dto);
		return "redirect:myorderList";
	}
	
	
	
	
//	발주 디테일 리스트 페이지
	@RequestMapping(value = "/myorderDetailList")
	public String myOrderDetailSdmList(@ModelAttribute("vo") MyOrderVo vo, Model model ) throws Exception
	{
		
		int rowCount = service.motCount(vo);
		if(rowCount > 0)
		{
			UtilFunction.setSearch(vo);
			model.addAttribute("list", service.myorderdetailList(vo));
		}
		
		return Constants.PATH_MYORDER + "myorderDetailList";
	}
	
//	발주 디테일 수정 페이지
	@RequestMapping(value= "/myorderDetailForm")
	public String myOrderDetailSdmForm(Model model, MyOrderDto dto)throws Exception
	{
		model.addAttribute("list", service.clientNameList(dto));
		model.addAttribute("pdtlist", service.productList(dto));
		model.addAttribute("item", service.myorderdetailitem(dto));
		return Constants.PATH_MYORDER + "myorderDetailForm";
	}
//	발주 디테일 등록 페이지
	@RequestMapping(value = "/myorderDetailCreate")
	public String myOrderDetailCreate(Model model,MyOrderDto dto) throws Exception
	{
		model.addAttribute("list", service.clientNameList(dto));
		model.addAttribute("pdtlist", service.productList(dto));
		return Constants.PATH_MYORDER + "myorderDetailCreate";
	}
//	발주 디테일 수정
	@RequestMapping(value = "/myorderdetailupdt")
	public String myorderdetailupdt(MyOrderDto dto) throws Exception
	{
		service.myorderdetailupdt(dto);
		return "redirect:/myorderDetailList";
	}
	

	
	
	
	
	
//	발주 디테일 insert 
	@ResponseBody
	@RequestMapping(value = "/myorderDetailInst")
	public Map<String, Object> myorderDetailInst(MyOrderDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		service.myorderdetailinsert(dto);
		returnMap.put("rt", "success");

		return returnMap;
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
