package com.csy.module.wx.service.service;

import com.csy.module.wx.dto.KckpUploadInfo;
import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.util.spring.BaseDao;

import net.sf.json.JSONObject;

public interface BAccidentInfoService extends BaseDao<BAccidentInfo, BAccidentInfoExample>{
	
	JSONObject insertAccident(KckpUploadInfo uploadInfo);
}
