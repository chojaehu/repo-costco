package com.mamamoo.infra.orders;

import java.util.List;

public interface OrdersDao {
//	주문조회
	public List<OrdersDto> selectList(OrdersVo vo);
//	주문count
	public int getCount(OrdersVo vo);
//	상세주문조회
	public List<OrdersDto> selectListOrt(OrdersVo vo);
//	상세주문count
	public int getCountOrt(OrdersVo vo);
//	주문항목생성 시작
	public OrdersDto selectOne(OrdersDto dto);
	
	public int insertOrt(OrdersDto dto);

	public int insertOrd(OrdersDto dto);

}
