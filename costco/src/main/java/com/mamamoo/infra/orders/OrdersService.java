package com.mamamoo.infra.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	OrdersDao dao;
	
	public List<OrdersDto> selectList(OrdersVo vo) {
		return dao.selectList(vo);
	}
	
	public int getCount(OrdersVo vo) {
		return dao.getCount(vo);
	}

	public List<OrdersDto> selectListOrt(OrdersVo vo) {
		return dao.selectListOrt(vo);
	}
	
	public int getCountOrt(OrdersVo vo) {
		return dao.getCountOrt(vo);
	}
	
	public OrdersDto selectOne(OrdersDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insertOrt(OrdersDto dto) {
		return dao.insertOrt(dto);
	}
	
	public int insertOrd(OrdersDto dto) {
		return dao.insertOrd(dto);
	}
//	주문등록 고객사
	public List<OrdersDto> clientNameList(OrdersDto dto) {
		return dao.clientNameList(dto);
	}
//	주문등록 제품
	public List<OrdersDto> productList(OrdersDto dto) {
		return dao.productList(dto);
	}
	
}
