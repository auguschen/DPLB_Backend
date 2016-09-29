package com.airchina.xn.dao;

import com.airchina.xn.model.Pilot;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PilotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pilot record);

    Pilot selectByPrimaryKey(Integer id);

    List<Pilot> selectAll();

    int updateByPrimaryKey(Pilot record);

    List<Pilot> selectByName(@Param("PilotName") String name);

    List<Pilot> selectByLicenseNo(@Param("LicenseNumber") String licenseNo);

    int insertWithoutID(Pilot record);
    
    Pilot selectByStaffNumber(@Param("StaffNumber") String staffNumber);

}