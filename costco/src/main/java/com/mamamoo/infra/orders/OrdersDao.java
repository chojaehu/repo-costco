package com.mamamoo.infra.orders;

import java.util.List;

public interface OrdersDao {
	
	public List<OrdersDto> selectList(OrdersDto dto);
}
