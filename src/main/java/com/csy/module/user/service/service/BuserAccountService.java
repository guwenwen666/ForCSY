package com.csy.module.user.service.service;

import java.util.Map;

import com.csy.module.user.entity.BUserAccount;

public interface BuserAccountService{
	
	public boolean isAlreayExist(Map<String, Object> map);
	
	public BUserAccount loginCheck(Map<String, Object> map);
	
}
