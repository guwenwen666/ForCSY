package com.csy.module.wx.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BAccidentDriverMapper;
import com.csy.module.wx.dao.BAccidentInfoMapper;
import com.csy.module.wx.dao.BDriverInfoMapper;
import com.csy.module.wx.dto.KckpUploadInfo;
import com.csy.module.wx.entity.BAccidentDriver;
import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.service.service.BAccidentInfoService;
import com.csy.util.StringUtils;
import com.csy.util.spring.BaseService;
import com.csy.util.wx.en.WxFileEnum;
import com.csy.util.wx.queue.FileQueue;
import com.csy.util.wx.queue.FileQueue.FileDescription;

import net.sf.json.JSONObject;

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
	public JSONObject insertAccident(KckpUploadInfo accident) {
		
		List<BDriverInfo> drivers = accident.getJsyxxs();
		
		accident.setId(UUID.randomUUID().toString());
		
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
		
		//数据全部操作成功之后,将上传数据 加入队列
		wxfileUpload(accident);
		
		accidentDao.insertSelective(accident);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("errMsg", "");
		return jsonObject;
	}
	
	private void wxfileUpload(KckpUploadInfo accident){
		//图片文件转换
		if(accident.getLiveImage() != null && !"".equals(accident.getLiveImage().trim())){
			String[] liveImages = accident.getLiveImage().split(",");
			List<String> newLiveImages = new ArrayList<String>();
			for(String liveImage : liveImages){
				String newLiveImage = new StringBuffer().append(UUID.randomUUID().toString()).append(".jpg").toString();
				FileDescription fileDetail = FileQueue.getInstance()
						.new FileDescription(liveImage, accident.getFkWxOpenid(), newLiveImage, WxFileEnum.IMAGE, accident.getUploadTime());
				FileQueue.getInstance().add(fileDetail);
				newLiveImages.add(newLiveImage);
			}
			accident.setLiveImage(StringUtils.join(newLiveImages));
		}
		//声音文件转换
		if(accident.getLiveVoice() != null && !"".equals(accident.getLiveVoice().trim())){
			String[] liveVoices = accident.getLiveVoice().split(",");
			List<String> newLiveVoices = new ArrayList<String>();
			for(String liveVoice : liveVoices){
				String newLiveVoice = new StringBuffer().append(UUID.randomUUID().toString()).append(".mp3").toString();
				FileDescription fileDetail = FileQueue.getInstance()
						.new FileDescription(liveVoice, accident.getFkWxOpenid(), newLiveVoice ,WxFileEnum.VOICE, accident.getUploadTime());
				FileQueue.getInstance().add(fileDetail);
				newLiveVoices.add(newLiveVoice.toString());
			}
			accident.setLiveVoice(StringUtils.join(newLiveVoices));
		}
	}
}
