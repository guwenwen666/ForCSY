
package com.csy.module.user.service.service;

import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.csy.common.config.FileStoreE;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserFilestore;
import com.csy.module.user.entity.BUserFilestoreExample;
import com.csy.util.spring.BaseDao;

/**@author wangqiang
 * @date 2016-8-30 14:29:22
 * @description 
 */
public interface BUserFilestoreService extends BaseDao<BUserFilestore, BUserFilestoreExample>{
	
	/**
	 * @author wangqiang
	 * @date 2016-8-30 18:14:55
	 * @param multiMap		文件Map
	 * @param fileStoreE	文件类型(决定文件路径)
	 * @param accountName	上传用户帐号
	 * @return	map
	 * @description 
	 *		
	 */
	public Map<String, Object> insertFilestore(MultiValueMap<String, MultipartFile> multiMap, FileStoreE fileStoreE,
			BUserAccount account);
	
}
