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

import com.csy.module.login.service.service.RegisterService;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.RandDomUtil;
import com.csy.util.StringUtils;
import com.csy.util.algorithm.DesUtil;

@Controller
public class RegisterAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RegisterService registerService;
	
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
			String password = new DesUtil(account.getSafekey()).decrypt(account.getPassword());
			account.setPassword(password);
			registerService.insertAccount(account);
			jsonObject.put("success", "success");
			jsonObject.put("account", account.getAccount());
		} catch (Exception e){
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
	/**
	 * des密码加密
	 * @param password
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("/register/getDes")
	public void getDes(String password,HttpServletResponse res) throws IOException{
		JSONObject jsonObject = new JSONObject();
		try {
			String safeKey = RandDomUtil.getRandomString(32);
			String key = new DesUtil(safeKey).encrypt(password);
			jsonObject.put("safeKey", safeKey);
			jsonObject.put("key", key);
		} catch (Exception e){
			logger.info("des加密失败", e);
			jsonObject.put("errorMsg", e.getMessage());
		}
		res.getWriter().print(jsonObject);
	}
}
