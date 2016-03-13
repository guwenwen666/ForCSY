package com.csy.module.user.service.service;

import java.util.Map;

import com.csy.module.user.dao.BUserAccountMapper;

public interface BuserAccountService extends BUserAccountMapper{
	
	public boolean isAlreayExist(Map<String, Object> map);
	
}
