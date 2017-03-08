package com.csy.module.wx.service.service;

import com.csy.module.wx.entity.BWxFkyj;
import com.csy.module.wx.entity.BWxFkyjExample;
import com.csy.util.spring.BaseDao;

public interface BWxFkyjService extends BaseDao<BWxFkyj, BWxFkyjExample>{
	
	int addFkyj(BWxFkyj fkyj);
}
