package com.csy.module.user.dao;

import java.util.Map;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserAccountExample;
import com.csy.util.spring.BaseDao;

public interface BUserAccountMapper extends BaseDao<BUserAccount, BUserAccountExample>{
	
	BUserAccount loginCheck(Map<String, Object> map);
}