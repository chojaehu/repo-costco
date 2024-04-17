package com.mamamoo.infra.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	OrdersDao dao;
	
	public List<OrdersDto> selectList(OrdersDto dto) {
		return dao.selectList(dto);
	}
}
