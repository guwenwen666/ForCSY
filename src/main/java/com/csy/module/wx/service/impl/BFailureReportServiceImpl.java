package com.csy.module.wx.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.csy.module.wx.entity.BFailureReport;
import com.csy.module.wx.entity.BFailureReportExample;
import com.csy.module.wx.service.service.BFailureReportService;
import com.csy.util.StringUtils;
import com.csy.util.spring.BaseService;
import com.csy.util.wx.en.WxFileEnum;
import com.csy.util.wx.queue.FileQueue;
import com.csy.util.wx.queue.FileQueue.FileDescription;

@Service
public class BFailureReportServiceImpl extends BaseService<BFailureReport, BFailureReportExample>
    implements BFailureReportService{

  @Override
  public int addFailureReport(BFailureReport report){
    // 设置ID
    report.setId(UUID.randomUUID().toString());
    // 图片存储,及图片名称重编号
    String s_imgUrls = report.getFaultImages();
    if(StringUtils.notTrimEmpty(s_imgUrls)){
      // 图片文件转换
      String[] liveImages = s_imgUrls.split(",");
      List<String> newLiveImages = new ArrayList<String>();
      Date curDate = new Date();
      for(String liveImage : liveImages){
        String newLiveImage = new StringBuffer().append(UUID.randomUUID().toString()).append(".jpg").toString();
        FileDescription fileDetail = FileQueue.getInstance().new FileDescription(liveImage, report.getFkWxOpenid(),
            newLiveImage, WxFileEnum.IMAGE, curDate);
        FileQueue.getInstance().add(fileDetail);
        newLiveImages.add(newLiveImage);
      }
      report.setFaultImages(StringUtils.join(newLiveImages));
    }
    return _dao.insertSelective(report);
  }
}
