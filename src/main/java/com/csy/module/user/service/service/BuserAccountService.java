package com.csy.module.user.service.service;

import java.util.Map;

import com.csy.module.user.entity.BUserAccount;
import com.csy.util.exception.account.EmailNotActivatedException;
import com.csy.util.exception.account.PhoneNotActivatedException;
import com.csy.util.exception.account.UserNotUniqueException;

public interface BuserAccountService{
	
	public boolean isAlreayExist(Map<String, Object> map);
	
	public BUserAccount loginUser(String account, String password)
			throws UserNotUniqueException, EmailNotActivatedException
			,PhoneNotActivatedException, Exception;
	
}
