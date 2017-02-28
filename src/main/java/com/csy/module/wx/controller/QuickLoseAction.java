package com.csy.module.wx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.wx.dto.DriverAccident;
import com.csy.module.wx.service.service.BAccidentInfoService;
import com.csy.util.JSONUtil;
import com.csy.util.TimeFormatUtil;

@Controller
public class QuickLoseAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private BAccidentInfoService bAccidentInfoService;
	/**
	 * 说明:快处快赔查询页面
	 * 创建时间：2017-02-20 09:00
	 * @author wangyonghui
	 * @return
	 */
	@RequestMapping("/lose")
	public ModelAndView register(String param){
		  Map<String, Object> paramsMap  = new HashMap<String, Object>();
		  Calendar calendar = Calendar.getInstance();
		  String formatTime = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		  calendar.add(Calendar.DATE, - 7);  
		  String formatTime1 = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		  paramsMap.put("startTime", formatTime1);
		  paramsMap.put("endTime", formatTime);
		  return new ModelAndView("lose/kckpcx",paramsMap);
	}
	/**
	 * 说明：根据事故发生时间、微信号、号牌号码去查询驾驶员、事故、微信用户信息
	 * 创建时间：2017-02-21 15:00
	 * @author wangyonghui
	 */
	@RequestMapping("/kckpcx")
	public void findByParam(HttpServletRequest request, HttpServletResponse response,DriverAccident accident){
		List<DriverAccident> list = new ArrayList<DriverAccident>();
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("error", "");
	    try {
	    	list = bAccidentInfoService.selectByExample(accident);
	    } catch (Exception e) {
	      jsonObject.put("error", e);
	      JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	      e.printStackTrace();
	    }
	    jsonObject.put("data", list);
	    JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	}
	
}
