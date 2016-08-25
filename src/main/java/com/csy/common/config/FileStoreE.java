/**@author wangqiang
 * @date 2016-8-24 17:06:53
 * @description 
 */
package com.csy.common.config;

/**
 * @author wangqiang
 * @date 2016-8-24 17:06:53
 * @description 
 * 		不同文件类型对应的存储位置
 */
public enum FileStoreE {
	
	ABC("/temp1"),BCD("/temp2");
	
	private String dir;
	
	private FileStoreE(String dir){
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}
}
