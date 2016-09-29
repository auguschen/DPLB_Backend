package com.airchina.xn.dao;

import com.airchina.xn.model.Licensesratingsrecord;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LicensesratingsrecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Licensesratingsrecord record);

    Licensesratingsrecord selectByPrimaryKey(Integer id);

    List<Licensesratingsrecord> selectAll();

    int updateByPrimaryKey(Licensesratingsrecord record);
    
    List<Licensesratingsrecord> selectAllByPilotID(@Param("Pilot_ID") Integer pilot_id);

    int insertWithoutID(Licensesratingsrecord record);

}