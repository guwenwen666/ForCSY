package com.csy.module.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.ObjectUtils;
import com.csy.util.SecurityCodeImg;
import com.csy.util.StringUtils;
import com.csy.util.algorithm.MD5Util;


@Controller
public class LoginAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BuserAccountService accountService;
	
	@RequestMapping("/login")
	public ModelAndView index(){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping("/login/accountLogin")
	public void accountLogin(HttpServletRequest req,HttpServletResponse res
			,String account,String password,String isCache) throws IOException{
		//如果不是从cache里面取出
		if(StringUtils.isTrimEmpty(isCache)){
			password = MD5Util.MD5(password);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("power", account);
		map.put("password", password);
		JSONObject jsonObject = new JSONObject();
		try {
			BUserAccount user = accountService.loginCheck(map);
			if(ObjectUtils.isNull(user)){
				jsonObject.put("errorMsg", "帐号或密码不正确!");
				HttpSession session = req.getSession(true);
				Object timesObj = session.getAttribute("login_errorTime");
				if(ObjectUtils.isNull(timesObj)){
					session.setAttribute("login_errorTime", 1);
				}else{
					int times = (int)timesObj + 1;
					session.setAttribute("login_errorTime", times);
					if(times >= 3){
						jsonObject.put("securityCode", true);
					}
				}
			}else{
				jsonObject.put("success", "验证通过!");
				jsonObject.put("account", user.getAccount());
				req.getSession(true).setAttribute("user", user);
				
			}
		} catch (Exception e) {
			logger.info("用户登陆异常!"+e.getMessage());
			jsonObject.put("errorMsg", "服务器处理异常!");
		}
		res.getWriter().print(jsonObject);
	}
	
	@RequestMapping("login/securityCodeImg")
	public void SecurityCodeImg(HttpServletRequest req,
			HttpServletResponse response) throws IOException {
		SecurityCodeImg securityCodeImg = new SecurityCodeImg();
		req.setAttribute("login_security", securityCodeImg.getSecurityCode());
		securityCodeImg.outPutStream(response);
	}
	
}
