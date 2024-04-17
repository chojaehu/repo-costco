package com.mamamoo.infra.myorder;

import java.util.List;

public interface MyOrderDao {
	
	public List<MyOrderDto> selectList(MyOrderVo vo);
}
