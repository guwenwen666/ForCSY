package com.csy.module.wx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wx")
public class KckpController {
	
	@RequestMapping("/index")
	public ModelAndView authorize(HttpServletRequest request, 
			HttpServletResponse response){
		return new ModelAndView("/weixin/authorize");
	}
	
	@RequestMapping("/kckp")
	public ModelAndView kckp(HttpServletRequest request, 
			HttpServletResponse response, String code, String state){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("state", state);
		return new ModelAndView("/weixin/kckp", map);
	}
}
