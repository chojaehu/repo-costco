package com.mamamoo.infra.myorder;

import java.util.List;

public interface MyOrderDao {
//	발주 리스트
	public List<MyOrderDto> selectList(MyOrderVo vo);
	public MyOrderDto selectOne(MyOrderDto dto);
	
//	발주 디테일 리스트
	public List<MyOrderDto> myorderdetailList(MyOrderVo vo);
	
//	발주디테일 수종폼 화면
	public MyOrderDto myorderdetailitem(MyOrderDto dto);
	
//	발주등록 발주사
	public List<MyOrderDto> clientNameList(MyOrderDto dto);
//	발주등록 제품
	public List<MyOrderDto> productList(MyOrderDto dto);
	
	
//	발주 디테일 등록 
	public int myorderdetailinsert(MyOrderDto dto);
}
