package com.csy.common.mapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.csy.common.config.FileStoreE;
import com.csy.module.user.entity.BUserAccount;
import com.csy.util.FolderUtils;

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
		String fileStorePath = null;
		if(user == null){
			jObject.put("error", "未获取到用户信息!");
		}else if(fileE == null){
			jObject.put("error", "上传文件类型不符合要求!");
		}else{
			Map<String, String> map = new HashMap<String, String>();
			String filePath = FileStoreE.DEFAULTDIR + File.separator + user.getAccount() + fileE.getDir();
			fileStorePath = request.getServletContext().getRealPath(filePath);
			//路径不存在，则创建目录 
			if(!FolderUtils.exists(fileStorePath)){
				FolderUtils.mkdirs(fileStorePath);
			}
			MultiValueMap<String, MultipartFile> multiMap = multipartRequest.getMultiFileMap();
			Set<Entry<String, List<MultipartFile>>> entries = multiMap.entrySet();
			Iterator<Entry<String, List<MultipartFile>>> iterator = entries.iterator();
			while(iterator.hasNext()){
				Entry<String, List<MultipartFile>> entry = iterator.next();
				List<MultipartFile> multipartFiles = entry.getValue();
				for(MultipartFile mFile:multipartFiles){
					try {
						InputStream in = mFile.getInputStream();
						FileOutputStream out = new FileOutputStream(fileStorePath+File.separator+mFile.getName());
						//创建一个缓冲区
						byte buffer[] = new byte[1024];
						//判断输入流中的数据是否已经读完的标识
						int len = 0;
						//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
						while((len=in.read(buffer))>0){
							//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
							out.write(buffer, 0, len);
						}
						//关闭输入流
						in.close();
						//关闭输出流
						out.close();
						map.put(mFile.getName(), "success");
					} catch (IOException e) {
						e.printStackTrace();
						map.put(mFile.getName(), e.getMessage());
					}
				}
			}
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
