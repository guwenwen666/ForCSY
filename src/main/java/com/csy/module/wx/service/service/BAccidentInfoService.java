package com.csy.module.wx.service.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.module.wx.entity.BDriverInfo;
import com.csy.util.spring.BaseDao;

public interface BAccidentInfoService extends BaseDao<BAccidentInfo, BAccidentInfoExample>{
	
	JSONObject insertAccident(BAccidentInfo accident, List<BDriverInfo> drivers);
}
