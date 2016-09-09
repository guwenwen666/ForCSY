
package com.csy.module.user.service.service;

import com.csy.module.user.entity.BUserInfo;
import com.csy.module.user.entity.BUserInfoExample;
import com.csy.util.spring.BaseDao;

/**
 * @author wangqiang
 * @date 2016-9-07 14:42:55
 * @description
 */
public interface BUserInfoService extends BaseDao<BUserInfo, BUserInfoExample>{
	
	/**
	 * @author wangqiang
	 * @date 2016-9-07 15:14:46
	 * @param s_account
	 * @return
	 * @description 
	 *		根据帐号名称 查询用户信息
	 */
	public BUserInfo selectByAccount(String s_account);
}
