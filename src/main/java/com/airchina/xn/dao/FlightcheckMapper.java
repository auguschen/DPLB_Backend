package com.airchina.xn.dao;

import com.airchina.xn.model.Flightcheck;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FlightcheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Flightcheck record);

    Flightcheck selectByPrimaryKey(Integer id);

    List<Flightcheck> selectAll();

    int updateByPrimaryKey(Flightcheck record);
    
    List<Flightcheck> selectByPilotID(@Param("Pilot_ID") Integer pilot_id);

    int insertWithoutID(Flightcheck record);
    
}