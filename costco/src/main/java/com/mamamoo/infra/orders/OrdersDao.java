package com.mamamoo.infra.orders;

import java.util.List;

public interface OrdersDao {
	
	public List<OrdersDto> selectList(OrdersVo vo);
	
	public int getCount(OrdersVo vo);
	
	public OrdersDto selectOne(OrdersDto dto);
	
	public int insertOrt(OrdersDto dto);
	
	public int insertOrd(OrdersDto dto);
}
