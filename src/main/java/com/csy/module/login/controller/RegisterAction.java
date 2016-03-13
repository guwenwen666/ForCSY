package com.csy.module.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.StringUtils;

@Controller
public class RegisterAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BuserAccountService accountService;
	
	@RequestMapping("/register")
	public ModelAndView register(){
		return new ModelAndView("login/register");
	}
	
	@RequestMapping("/register/emailAccount")
	public void registerAccount(HttpServletRequest req, HttpServletResponse res
			,BUserAccount account) throws IOException{
		JSONObject jsonObject = new JSONObject();
		try {
			accountService.insertSelective(account);
			BUserAccount register = accountService.selectByPrimaryKey(account.getAccount());
			jsonObject.put("success", "success");
			jsonObject.put("register", register);
		} catch (Exception e) {
			logger.info(account.getAccount()+"添加失败！", e);
			jsonObject.put("errorMsg", e.getMessage());
		}
		res.getWriter().print(jsonObject);
	}
	
	@RequestMapping("/register/accountIsExist")
	public void accountIsExist(HttpServletRequest req, HttpServletResponse res
			, String account,String email,String phone) throws IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>(); 
		if(!StringUtils.isTrimEmpty(account)){
			paramMap.put("account", account);
		}
		if(!StringUtils.isTrimEmpty(email)){
			paramMap.put("email", email);
		}
		if(!StringUtils.isTrimEmpty(phone)){
			paramMap.put("phone", phone);
		}
		boolean b = accountService.isAlreayExist(paramMap);
		res.getWriter().print(b);
	}
}
