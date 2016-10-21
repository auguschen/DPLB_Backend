package com.airchina.xn.dao;

import com.airchina.xn.model.Photos;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PhotosMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(Photos record);

    int insertWithoutID(Photos record);

    Photos selectByPrimaryKey(Integer id);

    List<Photos> selectAll();

    int updateByPrimaryKey(Photos record);
    
    Photos selectByPilotID(@Param("Pilot_ID") Integer pilot_id);

}