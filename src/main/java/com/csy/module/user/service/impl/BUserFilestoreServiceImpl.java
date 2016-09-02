package com.csy.module.user.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.csy.common.config.FileStoreE;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserFilestore;
import com.csy.module.user.entity.BUserFilestoreExample;
import com.csy.module.user.service.service.BUserFilestoreService;
import com.csy.util.FileUtils;
import com.csy.util.WebSiteUtils;
import com.csy.util.spring.BaseService;

/**@author wangqiang
 * @date 2016-8-30 14:31:01
 * @description 
 */
@Service
public class BUserFilestoreServiceImpl extends BaseService<BUserFilestore, BUserFilestoreExample>
	implements BUserFilestoreService{

	@Override
	public Map<String, Object> insertFilestore(MultiValueMap<String, MultipartFile> multiMap, FileStoreE fileStoreE,
			BUserAccount account) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		String folderPath = WebSiteUtils.getRootPath(fileStoreE.getUserDefaultDir(account.getId()));
		
		Set<Entry<String, List<MultipartFile>>> entries = multiMap.entrySet();
		Iterator<Entry<String, List<MultipartFile>>> iterator = entries.iterator();
		while(iterator.hasNext()){
			Entry<String, List<MultipartFile>> entry = iterator.next();
			List<MultipartFile> multipartFiles = entry.getValue();
			for(MultipartFile mFile:multipartFiles){
				try {
					boolean rtn = FileUtils.saveFile(mFile.getInputStream(), folderPath, mFile.getOriginalFilename());
					//文件已经正常存储
					if(rtn){
						BUserFilestore filestore = new BUserFilestore();
						filestore.setForeignAccount(account.getAccount());
						filestore.setFilesize(mFile.getSize());
						filestore.setFiletype(fileStoreE.toString());
						filestore.setFilename(mFile.getOriginalFilename());
						filestore.setCreatetime(new Date());
						try{
							_dao.insertSelective(filestore);
							rtnMap.put(mFile.getOriginalFilename(), "success");
						}catch(Exception exception){
							exception.printStackTrace();
							FileUtils.delete(folderPath, mFile.getOriginalFilename());
							rtnMap.put(mFile.getOriginalFilename(), "文件录入异常!");
						}
					}else{
						rtnMap.put(mFile.getOriginalFilename(), "文件存储异常!");
					}
				} catch (IOException e) {
					e.printStackTrace();
					rtnMap.put(mFile.getOriginalFilename(), "文件上传异常!");
				}
			}
		}
		return rtnMap;
	}
}
