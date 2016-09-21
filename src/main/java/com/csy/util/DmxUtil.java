package com.csy.util;

import java.util.List;

import com.csy.module.xtpz.entity.BXtpzDmx;
import com.csy.module.xtpz.entity.BXtpzDmxExample;
import com.csy.module.xtpz.service.service.BXtpzDmxService;

/**@author wangqiang
 * @date 2016-9-21 16:31:42
 * @description 代码项工具类，用于快速获取代码项内容
 */
public class DmxUtil {
	
	private static final BXtpzDmxService  B_XTPZ_DMX_SERVICE= SpringFactory.getBean("BXtpzDmxService");
	
	/**
	 * @author wangqiang
	 * @date 2016-9-21 17:06:49
	 * @param dmlxbh
	 * @return
	 * @description 根据代码类型序号 筛选代码项类型
	 */
	public static List<BXtpzDmx> getDmxList(Integer dmlxbh){
		BXtpzDmxExample example = new BXtpzDmxExample();
		example.createCriteria().andDmlxbhEqualTo(dmlxbh).andSfxsEqualTo(1);
		example.setOrderByClause("xssx");
		return B_XTPZ_DMX_SERVICE.selectByExample(example);
	}
	
	
}
