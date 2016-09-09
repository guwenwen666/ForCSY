package com.csy.module.user.service.service;

import java.util.Map;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserAccountExample;
import com.csy.util.exception.account.EmailNotActivatedException;
import com.csy.util.exception.account.PhoneNotActivatedException;
import com.csy.util.exception.account.UserNotUniqueException;
import com.csy.util.spring.BaseDao;

public interface BuserAccountService extends BaseDao<BUserAccount, BUserAccountExample>{
	
	public boolean isAlreayExist(Map<String, Object> map);
	
	public BUserAccount loginUser(String account, String password)
			throws UserNotUniqueException, EmailNotActivatedException
			,PhoneNotActivatedException, Exception;
	
}
