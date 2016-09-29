package com.airchina.xn.dao;

import com.airchina.xn.model.Routineflight;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoutineflightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Routineflight record);

    Routineflight selectByPrimaryKey(Integer id);

    List<Routineflight> selectAll();

    int updateByPrimaryKey(Routineflight record);

    int insertWithoutID(Routineflight record);
    
    List<Routineflight> selectByPilotID(@Param("Pilot_ID") Integer pilot_id);
}