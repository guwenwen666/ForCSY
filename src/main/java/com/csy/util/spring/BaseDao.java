package com.csy.util.spring;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T,Texample> {

    int countByExample(Texample example);

    int deleteByExample(Texample example);

    int deleteByPrimaryKey(String account);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(Texample example);

    T selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Texample example);

    int updateByExample(@Param("record") T record, @Param("example") Texample example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
