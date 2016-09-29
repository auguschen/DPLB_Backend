package com.airchina.xn.dao;

import com.airchina.xn.model.Aircraft;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AircraftMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Aircraft record);

	Aircraft selectByPrimaryKey(Integer id);

	List<Aircraft> selectAll();

	List<Aircraft> selectAllPaged(@Param("pageStart") Integer pageStart, @Param("countPerPage") Integer countPerPage,
			@Param("currentPage") Integer currentPage);

	int updateByPrimaryKey(Aircraft record);

	Aircraft selectByRegNo(String regno);

	List<Aircraft> selectByType(@Param("Type_Catalog") String typecatalog,
			@Param("Type_Of_Aircraft") String typeafaircraft);

	List<Aircraft> selectByTypePaged(@Param("Type_Catalog") String typecatalog,
			@Param("Type_Of_Aircraft") String typeafaircraft, @Param("pageStart") Integer pageStart,
			@Param("countPerPage") Integer countPerPage, @Param("currentPage") Integer currentPage);

	int insertWithoutID(Aircraft record);
}