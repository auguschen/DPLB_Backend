package com.airchina.xn.dao;

import com.airchina.xn.model.Simulatortraining;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SimulatortrainingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Simulatortraining record);

    Simulatortraining selectByPrimaryKey(Integer id);

    List<Simulatortraining> selectAll();

    int updateByPrimaryKey(Simulatortraining record);

    int insertWithoutID(Simulatortraining record);

    List<Simulatortraining> selectByPilotID(@Param("Pilot_ID") Integer pilot_id);
}