package com.airchina.xn.dao;

import com.airchina.xn.model.Parameters;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ParametersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parameters record);

    int insertWithoutID(Parameters record);

    Parameters selectByPrimaryKey(Integer id);

    List<Parameters> selectAll();

    int updateByPrimaryKey(Parameters record);
    
    List<Parameters> selectByType(@Param("ParameterType") String parameterType);
    
    List<Parameters> selectByName(@Param("ParameterName") String parameterName);

    List<Parameters> selectAllPaged(@Param("pageStart") Integer pageStart, @Param("countPerPage") Integer countPerPage,
			@Param("currentPage") Integer currentPage);

    List<Parameters> selectByTypePaged(@Param("ParameterType") String parameterType, @Param("pageStart") Integer pageStart, @Param("countPerPage") Integer countPerPage,
			@Param("currentPage") Integer currentPage);
    
    List<Parameters> selectByNamePaged(@Param("ParameterName") String parameterName, @Param("pageStart") Integer pageStart, @Param("countPerPage") Integer countPerPage,
			@Param("currentPage") Integer currentPage);
}