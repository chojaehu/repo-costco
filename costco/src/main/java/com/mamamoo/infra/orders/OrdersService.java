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
	
	public OrdersDto selectOne(OrdersDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insertOrt(OrdersDto dto) {
		return dao.insertOrt(dto);
	}
	
	public int insertOrd(OrdersDto dto) {
		return dao.insertOrd(dto);
	}
}
