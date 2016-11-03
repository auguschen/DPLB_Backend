package com.airchina.xn.dao;

import com.airchina.xn.model.Routineflightinfo;
import java.util.List;

public interface RoutineflightinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Routineflightinfo record);

    Routineflightinfo selectByPrimaryKey(Integer id);

    List<Routineflightinfo> selectAll();

    int updateByPrimaryKey(Routineflightinfo record);
}