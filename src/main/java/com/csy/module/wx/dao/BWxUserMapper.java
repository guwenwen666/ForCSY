package com.csy.module.wx.dao;

import com.csy.module.wx.entity.BWxUser;
import com.csy.module.wx.entity.BWxUserExample;
import com.csy.util.spring.BaseDao;

public interface BWxUserMapper extends BaseDao<BWxUser, BWxUserExample>{
	//根据微信号去查询微信信息
	BWxUser selectByParam(BWxUser bWxUser);
	
}