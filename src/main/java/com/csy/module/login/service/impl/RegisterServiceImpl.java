package com.csy.module.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.login.service.service.RegisterService;
import com.csy.module.user.dao.BUserAccountMapper;
import com.csy.module.user.entity.BUserAccount;
import com.csy.util.algorithm.MD5Util;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private BUserAccountMapper accountMapper;

	@Override
	public int insertAccount(BUserAccount account) {
		String password = account.getPassword();
		account.setPassword(MD5Util.MD5(password));
		return accountMapper.insertSelective(account);
	}
	
}
