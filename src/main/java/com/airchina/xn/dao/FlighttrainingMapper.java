package com.airchina.xn.dao;

import com.airchina.xn.model.Flighttraining;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FlighttrainingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Flighttraining record);

    Flighttraining selectByPrimaryKey(Integer id);

    List<Flighttraining> selectAll();

    int updateByPrimaryKey(Flighttraining record);

    int insertWithoutID(Flighttraining record);

    List<Flighttraining> selectByPilotID(@Param("Pilot_ID") Integer pilot_id);
}