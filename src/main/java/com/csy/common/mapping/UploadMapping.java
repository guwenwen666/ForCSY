package com.csy.common.mapping;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.csy.common.config.FileStoreE;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.service.service.BUserFilestoreService;

import net.sf.json.JSONObject;

/**
 * @author wangqiang
 * @date 2016-8-24 17:02:18
 * @description
 * 		上传文件的通用类
 */
@Controller
@RequestMapping("/common/upload")
public class UploadMapping {
	
	@Autowired
	private BUserFilestoreService fileStoreService;
	
	/**
	 * @author wangqiang
	 * @date 2016-8-24 17:18:42
	 * @param type 上传文件的类型
	 * @throws IOException 
	 * @description 
	 *	上传文件的mapping实现类
	 */
	@RequestMapping(value = "/{type}")
	public void upload(MultipartRequest multipartRequest, HttpServletResponse response, 
			@PathVariable(value="type") String type){
		HttpServletRequest request = (HttpServletRequest) multipartRequest;
		BUserAccount user = (BUserAccount)request.getSession(true).getAttribute("user");
		FileStoreE fileE = FileStoreE.getEntityByName(type);
		JSONObject jObject = new JSONObject();
		if(user == null){
			jObject.put("error", "未获取到用户信息!");
		}else if(fileE == null){
			jObject.put("error", "上传文件类型不符合要求!");
		}else{
			MultiValueMap<String, MultipartFile> multiMap = multipartRequest.getMultiFileMap();
			Map<String, Object> map = fileStoreService.insertFilestore(multiMap, fileE, user);
			jObject.put("result", map);
		}
		try {
			response.getWriter().println(jObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping()
	public ModelAndView uploadIndex(){
		return new ModelAndView("partical/upload");
	}
}
