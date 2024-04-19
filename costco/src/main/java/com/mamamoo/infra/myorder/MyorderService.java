package com.mamamoo.infra.myorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyorderService {
	
	
	@Autowired
	MyOrderDao dao;
//	발주 리스트
	public List<MyOrderDto> selectList(MyOrderVo vo)
	{
		return dao.selectList(vo);
	}
//	발주 디테일 리스트
	public List<MyOrderDto> myorderdetailList(MyOrderVo vo)
	{
		return dao.myorderdetailList(vo);
	}
//	발주 디테일 수정폼 화면
	public MyOrderDto myorderdetailitem(MyOrderDto dto)
	{
		return dao.myorderdetailitem(dto);
	}
//	발주 등록 발주사
	public List<MyOrderDto> clientNameList(MyOrderDto dto)
	{
		return dao.clientNameList(dto);
	}
	public List<MyOrderDto> productList(MyOrderDto dto)
	{
		return dao.productList(dto);
	}

}
