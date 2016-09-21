package com.csy.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

/**@author wangqiang
 * @date 2016-9-21 16:12:54
 * @description spring工厂类 用于获取对应类型的bean
 */
@Controller
public class SpringFactory implements ApplicationContextAware {

    private static ApplicationContext context;  

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context=applicationContext;
	}  

   /** 
    * 根据beanName名字取得bean 
    * @param beanName 
    * @return 
    */  
   @SuppressWarnings("unchecked")
   public static <T> T getBean(String beanName) {  
       if (null != context) {  
           return (T) context.getBean(beanName);  
       }  
       return null;  
   }  
  
}  
