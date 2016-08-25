package com.csy.common.mapping;

import java.nio.file.FileStore;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.csy.common.config.FileStoreE;

/**
 * @author wangqiang
 * @date 2016-8-24 17:02:18
 * @description
 * 		上传文件的通用类
 */
@Controller
@RequestMapping("/common/upload")
public class UploadMapping {
	
	/**
	 * @author wangqiang
	 * @date 2016-8-24 17:18:42
	 * @param type 上传文件的类型
	 * @description 
	 *	上传文件的mapping实现类
	 */
	@RequestMapping(value = "/{type}",params = "type")
	public void upload(MultipartRequest multipartRequest
			,HttpServletResponse response, String type){
		
		
	}
	
	@RequestMapping()
	public ModelAndView uploadIndex(){
		return new ModelAndView("partical/upload");
	}
}
