package com.csy.util.wx;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csy.module.wx.bean.result.WxAccessToken;
import com.csy.module.wx.bean.result.WxError;
import com.csy.util.WxConfig;

import net.sf.json.JSONObject;

public class AutoRefreshBasicAcessToken {
	
	private static Logger logger = LoggerFactory.getLogger(AccessTokenUtil.class);
	
	/**
	 * 基础支持的Access_token获取
	 */
	public void reStoreAccessToken(){
		String appid = WxConfig.getInstance().getAppid();
		String appsecret = WxConfig.getInstance().getAppsecret();
		
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
				+ "&appid="+ appid +"&secret=" + appsecret;
		
		logger.info("微信授权的url:" + url);
		
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String rst = new String(jsonBytes, "UTF-8");
			
			//返回结果转换
			@SuppressWarnings("static-access")
			JSONObject jsonObject = new JSONObject().fromObject(rst);
			if(jsonObject.containsKey("errcode")){
				WxError wxError = (WxError)JSONObject.toBean(jsonObject, WxError.class);
				logger.error(wxError.toString());
			}else{
				WxAccessToken wxToken = (WxAccessToken)JSONObject.toBean(jsonObject, WxAccessToken.class);
				logger.info(wxToken.toString());
				WxConfig.getInstance().setAccess_token(wxToken.getAccess_token());
			}
			
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
