package com.csy.module.user.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.user.dao.BUserAccountMapper;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserAccountExample;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.ObjectUtils;
import com.csy.util.spring.BaseService;

@Service
public class BuserAccountServiceImpl extends BaseService<BUserAccount, BUserAccountExample> implements BuserAccountService{

	@Autowired
	BUserAccountMapper dao;
	
	@Override
	public boolean isAlreayExist(Map<String, Object> map) {
		BUserAccountExample example = new BUserAccountExample();
		Set<String> set = map.keySet();
		for(String key:set){
			if(key != null){
				switch (key.toLowerCase()) {
				case "account":
					example.or().andAccountEqualTo(map.get("account").toString());
					break;
				case "email":
					example.or().andEmailEqualTo(map.get("email").toString());
					break;
				case "phone":
					example.or().andPhoneEqualTo(map.get("phone").toString());
					break;
				default:
					break;
				}
			}
		}
		List<BUserAccount> users = dao.selectByExample(example);
		return !ObjectUtils.isEmpty(users);
	}

	@Override
	public BUserAccount loginCheck(Map<String, Object> map) {
		return dao.loginCheck(map);
	}

}
