package com.mamamoo.infra.myorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyorderService {
	
	
	@Autowired
	MyOrderDao dao;
	
	public List<MyOrderDto> selectList(MyOrderVo vo)
	{
		return dao.selectList(vo);
	}

}
