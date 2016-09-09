package com.csy.module.login.service.service;

import com.csy.module.user.entity.BUserAccount;


public interface RegisterService{
	
	/**
	 * @author wangqiang
	 * @date 2016-9-07 15:33:59
	 * @param account
	 * @return
	 * @throws Exception
	 * @description 
	 *	用户注册
	 *	1.添加用户的userAccount
	 *	2.添加用户的userInfo
	 */
	public int insertAccount(BUserAccount account) throws Exception;
}
