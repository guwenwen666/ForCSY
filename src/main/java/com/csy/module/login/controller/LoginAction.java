package com.csy.module.login.controller;

import java.io.IOException;

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
import com.csy.util.ObjectUtils;
import com.csy.util.SecurityCodeImg;
import com.csy.util.exception.account.EmailNotActivatedException;
import com.csy.util.exception.account.PhoneNotActivatedException;
import com.csy.util.exception.account.UserNotUniqueException;


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
		
		JSONObject jsonObject = new JSONObject();
		try {

			BUserAccount user = accountService.loginUser(account, password);
			if(ObjectUtils.isNull(user)){
				jsonObject.put("errorMsg", "帐号或密码不正确!");
			}else{
				jsonObject.put("success", "验证通过!");
				jsonObject.put("account_id", user.getId());
				req.getSession(true).setAttribute("user", user);
			}
		} catch (UserNotUniqueException e) {
			jsonObject.put("errorMsg", "后台服务异常!");
			logger.info(account,e);
		} catch (EmailNotActivatedException e) {
			jsonObject.put("errorMsg", "邮箱未激活，无法登录!");
		} catch (PhoneNotActivatedException e) {
			jsonObject.put("errorMsg", "手机未激活，无法登录!");
		} catch (Exception e) {
			jsonObject.put("errorMsg", "帐号或密码不正确!");
			e.printStackTrace();
		}
		res.getWriter().print(jsonObject);
	}
	
	@RequestMapping("login/securityCodeImg")
	public void SecurityCodeImg(HttpServletRequest req,
			HttpServletResponse response) throws IOException {
		SecurityCodeImg securityCodeImg = new SecurityCodeImg();
		req.getSession(true).setAttribute("login_security", securityCodeImg.getSecurityCode());
		securityCodeImg.outPutStream(response);
	}
	
	@RequestMapping("login/securityCodeCheck")
	public void SecurityCodeImg(HttpServletRequest req,
			HttpServletResponse response,String securityCode) throws IOException {
		String realCode = (String)req.getSession(true).getAttribute("login_security");
		boolean b=false;
		if(realCode!=null && realCode.toUpperCase().equals(securityCode.toUpperCase()))
			b=true;
		response.getWriter().print(b);
	}
}
