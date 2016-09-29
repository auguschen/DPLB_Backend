package com.airchina.xn.dao;

import com.airchina.xn.model.Logs;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Logs record);

	int insertWithoutID(Logs record);

	Logs selectByPrimaryKey(Integer id);

	List<Logs> selectAll();

	List<Logs> selectByCondi(Logs record);

	int updateByPrimaryKey(Logs record);

	List<Logs> selectAllPaged(@Param("pageStart") Integer pageStart, @Param("countPerPage") Integer countPerPage,
			@Param("currentPage") Integer currentPage);

	List<Logs> selectByCondiPaged(@Param("objectType") String objectType, @Param("objectId") Integer objectId,
			@Param("operation") String operation, @Param("operatorId") Integer operatorId,
			@Param("pageStart") Integer pageStart, @Param("countPerPage") Integer countPerPage,
			@Param("currentPage") Integer currentPage);

}