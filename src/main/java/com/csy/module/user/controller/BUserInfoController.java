package com.csy.module.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserInfo;
import com.csy.module.user.service.service.BUserInfoService;
import com.csy.util.DmxUtil;

/**@author wangqiang
 * @date 2016-9-07 14:37:36
 * @description
 * 		用户信息管理控制器 
 */

@Controller
@RequestMapping("setting")
public class BUserInfoController {
	
	private static final int BLOODTYPEDMLXXH = 10001;
	
	@Autowired
	BUserInfoService userInfoService;
	
	@RequestMapping("profile")
	public ModelAndView index(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		BUserAccount account = (BUserAccount)request.getSession(true).getAttribute("user");
		BUserInfo userInfo = userInfoService.selectByAccount(account.getAccount());
		map.put("userInfo", userInfo);
		map.put("bloodTypeList", DmxUtil.getDmxList(BLOODTYPEDMLXXH));
		return new ModelAndView("setting/porfile", "userInfo", userInfo);
	}
}
