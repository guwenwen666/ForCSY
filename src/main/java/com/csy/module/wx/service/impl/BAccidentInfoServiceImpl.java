package com.csy.module.wx.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BAccidentDriverMapper;
import com.csy.module.wx.dao.BAccidentInfoMapper;
import com.csy.module.wx.dao.BDriverInfoMapper;
import com.csy.module.wx.entity.BAccidentDriver;
import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.service.service.BAccidentInfoService;
import com.csy.util.spring.BaseService;

/**
 * @author wangqiang
 * @date 2017-02-19
 */
@Service
public class BAccidentInfoServiceImpl extends BaseService<BAccidentInfo, BAccidentInfoExample> 
	implements BAccidentInfoService{

	@Autowired
	private BAccidentInfoMapper accidentDao;
	@Autowired
	private BDriverInfoMapper driverDao;
	@Autowired
	private BAccidentDriverMapper accidentDriverDao;
	
	@Override
	public JSONObject insertAccident(BAccidentInfo accident,
			List<BDriverInfo> drivers) {
		
		accident.setId(UUID.randomUUID().toString());
		accidentDao.insertSelective(accident);
		
		List<BAccidentDriver> accidentDrivers = new ArrayList<BAccidentDriver>(drivers.size());
		for(BDriverInfo driver: drivers){
			driver.setId(UUID.randomUUID().toString());
			
			//关联信息写入
			BAccidentDriver accidentDriver = new BAccidentDriver();
			accidentDriver.setId(accident.getId());
			accidentDriver.setFkDriverId(driver.getId());
			accidentDrivers.add(accidentDriver);
		}
		driverDao.insertPatch(drivers);
		accidentDriverDao.insertPatch(accidentDrivers);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("errMsg", "");
		return jsonObject;
	}

}
