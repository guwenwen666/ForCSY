package com.csy.util.spring;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T,Texample>{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected BaseDao<T,Texample> _dao;
	
	
	public int deleteByPrimaryKey(String key){
		int rtn = _dao.deleteByPrimaryKey(key);
		logger.info("数据删除成功!"+key);
		return rtn;
	}
	
	public int insert(T record){
		int rtn = _dao.insert(record);
		logger.info("数据添加成功!"+JSONObject.fromObject(record));
		return rtn;
	}
	
	public int insertSelective(T record){
		int rtn = _dao.insertSelective(record);
		logger.info("数据添加成功(insertSelective)!"+JSONObject.fromObject(record));
		return rtn;
	}

	public T selectByPrimaryKey(String key){
		return _dao.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(T record){
		int rtn = _dao.updateByPrimaryKeySelective(record);
		logger.info("数据更新成功(updateByPrimaryKeySelective)!"+JSONObject.fromObject(record));
		return rtn;
	}

	public int updateByPrimaryKey(T record){
		int rtn = _dao.updateByPrimaryKey(record);
		logger.info("数据更新成功!"+JSONObject.fromObject(record));
		return rtn;
	}

	public int countByExample(Texample example) {
		return _dao.countByExample(example);
	}

	public int deleteByExample(Texample example) {
		int rtn =_dao.deleteByExample(example);
		logger.info("数据删除成功!"+JSONObject.fromObject(example));
		return rtn;
	}

	public List<T> selectByExample(Texample example) {
		return _dao.selectByExample(example);
	}

	public int updateByExampleSelective(T record, Texample example) {
		int rtn = _dao.updateByExampleSelective(record, example);
		logger.info("数据更新成功(updateByExampleSelective)!" 
				+ JSONObject.fromObject(record) + JSONObject.fromObject(example));
		return rtn;
	}

	public int updateByExample(T record, Texample example) {
		int rtn = _dao.updateByExample(record, example);
		logger.info("数据更新成功!" + JSONObject.fromObject(record) + JSONObject.fromObject(example));
		return rtn;
	}
}
