package com.csy.module.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.csy.module.login.service.service.RegisterService;
import com.csy.module.user.service.service.BuserAccountService;

public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private BuserAccountService buserAccountService;
	
}
