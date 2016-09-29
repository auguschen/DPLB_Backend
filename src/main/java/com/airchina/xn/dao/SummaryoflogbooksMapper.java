package com.airchina.xn.dao;

import com.airchina.xn.model.Summaryoflogbooks;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SummaryoflogbooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Summaryoflogbooks record);

    Summaryoflogbooks selectByPrimaryKey(Integer id);

    List<Summaryoflogbooks> selectAll();

    int updateByPrimaryKey(Summaryoflogbooks record);
    
    int insertWithoutID(Summaryoflogbooks record);
    
    List<Summaryoflogbooks> selectByPilotID(@Param("Pilot_ID") Integer pilot_id);

}