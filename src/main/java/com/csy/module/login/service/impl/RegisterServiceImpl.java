package com.csy.module.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.login.service.service.RegisterService;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserInfo;
import com.csy.module.user.service.service.BUserInfoService;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.RandDomUtil;
import com.csy.util.algorithm.DesUtil;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private BuserAccountService accountService;
	@Autowired
	private BUserInfoService userInfoService;

	@Override
	public int insertAccount(BUserAccount account) throws Exception {
		String password = account.getPassword();
		String safeKey = RandDomUtil.getRandomString(32);
		account.setSafekey(safeKey);
		account.setPassword(new DesUtil(safeKey).encrypt(password));
		
		BUserInfo bUserInfo = new BUserInfo();
		bUserInfo.setForeignAccount(account.getAccount());
		accountService.insertSelective(account);
		int i = userInfoService.insertSelective(bUserInfo);
		return i;
	}
	
}
