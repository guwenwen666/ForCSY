package com.csy.module.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserInfo;
import com.csy.module.user.service.service.BUserInfoService;

/**@author wangqiang
 * @date 2016-9-07 14:37:36
 * @description
 * 		用户信息管理控制器 
 */

@Controller
@RequestMapping("setting")
public class BUserInfoController {
	
	@Autowired
	BUserInfoService userInfoService;
	
	@RequestMapping("profile")
	public ModelAndView index(HttpServletRequest request){
		BUserAccount account = (BUserAccount)request.getSession(true).getAttribute("user");
		BUserInfo userInfo = userInfoService.selectByAccount(account.getAccount());
		return new ModelAndView("setting/porfile", "userInfo", userInfo);
	}
}
