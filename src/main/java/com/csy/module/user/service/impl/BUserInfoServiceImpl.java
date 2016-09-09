package com.csy.module.user.service.impl;

import org.springframework.stereotype.Service;

import com.csy.module.user.entity.BUserInfo;
import com.csy.module.user.entity.BUserInfoExample;
import com.csy.module.user.service.service.BUserInfoService;
import com.csy.util.spring.BaseService;

/**@author wangqiang
 * @date 2016-9-07 14:43:24
 * @description 
 */
@Service
public class BUserInfoServiceImpl extends BaseService<BUserInfo, BUserInfoExample> 
	implements BUserInfoService{

	public BUserInfo selectByAccount(String s_account){
		return _dao.selectByPrimaryKey(s_account);
	}
}
