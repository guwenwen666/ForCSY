package com.csy.util;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class ObjectUtils
{

    public static final Object NULL = null;

    public ObjectUtils()
    {
    }

    public static boolean isNull(Object o)
    {
        return o == null;
    }

    public static boolean notNull(Object o)
    {
        return !isNull(o);
    }

    @SuppressWarnings("unchecked")
    public static boolean isEmpty(Object o)
    {
        if(isNull(o))
            return true;
        if(o instanceof String)
            return "".equals(o.toString());
        if(o instanceof Collection)
            return ((Collection<Object>)o).isEmpty();
        if(o instanceof Map)
            return ((Map<Object,Object>)o).isEmpty();
        if(o.getClass().isArray())
            return Array.getLength(o) == 0;
        else
            return true;
    }

    public static boolean notEmpty(Object o)
    {
        return !isEmpty(o);
    }

    public static Object nullSafe(Object actual, Object safe)
    {
        return actual != null ? actual : safe;
    }

	@SuppressWarnings("unchecked")
	public static <T> T[] objectToOtherArray(Object[] objArray){
		T[] ts=(T[])new Object[objArray.length];
		try {
			for(int i=0;i<objArray.length;i++){
				ts[i]=(T)objArray[i];
			}
		} catch (Exception e) {
			e.printStackTrace();
			return (T[]) objArray;
		}
		return ts; 
	}
    
	@SuppressWarnings("unchecked")
	public static <T> List<T> objectArrayToList(Object[] objects){
		List<T> ts = new ArrayList<T>();
		try {
			for (Object obj:objects) {
				ts.add((T)obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return ts;
	}

	/**
	 * 比较两个对象内容是否相同只比较属性值
	 * @param t1
	 * @param t2
	 * @return	true/false
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static <T> boolean objEqualWithobj(T t1,T t2){
		boolean rtn = true;
		if(t1 == null || t2 == null){
			//都为null
			if(t1 == null && t2 == null){
				return rtn;
			}
			//仅有一个为null
			else{
				rtn = false;
				return rtn;
			}
		}
		Class<?> t1Class = t1.getClass();
		Class<?> t2Class = t2.getClass();
		if(t1Class!=t2Class){
			rtn = false;
		}
		//如果t1Class=t2Class
		else{
			Method[] mtds = t1Class.getDeclaredMethods();
			for (int i = 0; i < mtds.length; i++) {
				Method mtd = mtds[i];
				//如果是get方法
				if(mtd.getName().startsWith("get")){
					try {
						Object obj1 = mtd.invoke(t1, new Object[]{});
						Object obj2 = mtd.invoke(t2, new Object[]{});
						if(obj1!=null){
							if(!obj1.equals(obj2)){
								rtn=false;
								break;
							}
						}else{
							if(obj2!=null){
								rtn=false;
								break;
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return rtn;
	}
	
	/**
	 * 比较t1对象内容是与集合/数组相同(不包括基本类型的包装类)
	 * @param t1	对象Obj
	 * @param t2	List<Obj>/Obj[]
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> int objEqualContain(T t1,T t2){
		if(t2 == null){
			return -1;
		}
		Class<?> t2Class = t2.getClass();
		//如果是list
		if(t2Class.getName().indexOf("ArrayList") > -1 ){
			List<Object> objs = (List<Object>)t2;
			for (int i = 0; i < objs.size(); i++) {
				boolean rst =objEqualWithobj(t1,objs.get(i));
				if(rst){
					return i;
				}
			}
		}
		//如果是数组
		else if(t2Class.isArray()){
			Object[] objs = (Object[])t2;
			for (int i = 0; i < objs.length; i++) {
				boolean rst =objEqualWithobj(t1,objs[i]);
				if(rst){
					return i;
				}
			}
		}
		//无法确定类型或者没有找到相等的
		return -1;
	}
}
