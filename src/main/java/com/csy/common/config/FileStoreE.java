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
	
	public static final String DEFAULTDIR = "/WEB-INF/userManager";
	
	private FileStoreE(String dir){
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}
	
	/**
	 * @author wangqiang
	 * @date 2016-8-26 16:53:01
	 * @param enumName
	 * @return
	 * @description 
	 *	根据文件类型，返回枚举实例
	 */
	public static FileStoreE getEntityByName(String enumName){
		FileStoreE[] fileStoreEs = FileStoreE.values();
		for(FileStoreE e:fileStoreEs){
			if(enumName!=null && enumName.equals(e.toString())){
				return e;
			}
		}
		return null;
	}
}
