package com.csy.util;

/**@author wangqiang
 * @date 2016-8-30 18:48:56
 * @description
 * 		站点的通用获取类 
 */
public class WebSiteUtils {
	
	private static String rootDir = null;
	
	static{
		rootDir = WebSiteUtils.class.getClassLoader().getResource("../../").getPath().toString();
	}
	
	public static String getRootPath(){
		return rootDir;
	}

	/**
	 * @author wangqiang
	 * @date 2016-8-30 18:56:46
	 * @param folderPath
	 * @return
	 * @description 
	 *		获取网站文件夹下的物理路径
	 */
	public static String getRootPath(String folderPath){
		return rootDir + folderPath;
	}
}
