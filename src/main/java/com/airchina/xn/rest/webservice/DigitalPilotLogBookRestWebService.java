/**
 * 
 */
package com.airchina.xn.rest.webservice;

import java.util.List;

import javax.ws.rs.core.Response;

import com.airchina.xn.entities.UploadFileEntity;
import com.airchina.xn.model.Flightcheck;
import com.airchina.xn.model.Flighttraining;
import com.airchina.xn.model.Licensesratingsrecord;
import com.airchina.xn.model.Photos;
import com.airchina.xn.model.Pilot;
import com.airchina.xn.model.Routineflight;
import com.airchina.xn.model.Simulatortraining;
import com.airchina.xn.model.Summaryoflogbooks;

/**
 * @author augus
 *
 */
public interface DigitalPilotLogBookRestWebService {
	/**
	 * 
	 * 飞行员
	 */
	public Response pilots();
//	根据姓名返回飞行员列表
	public Response pilotsbyname(String name);
//	根据主键返回飞行员
	public Response pilotbyid(Integer id);
//	根据员工号返回飞行员
	public Response pilotbystaffnumber(String staffNumber);
//	根据执照号返回飞行员列表
	public Response pilotsbylicenseno(String licenseNo);
//	新增一个飞行员信息
	public Response newpilot(Pilot p);
//	更新一个飞行员信息
	public Response updatepilot(Pilot p);
//	删除一个飞行员信息
	public Response deletepilot(Pilot p);
//	查询获取照片
	public Response getPilotPhoto(Integer pilot_id);
//	更新照片
	public Response updatepilotPhoto(Integer pilot_id, UploadFileEntity ufn);
//	删除照片
	public Response deletepilotPhoto(Photos photo);
		
	/**
	 * 
	 * 执照等级记录
	 * 
	 */	
//	查询一个飞行员的执照等级记录信息
	public Response pilotlicenseratingsrecordbypilot(Integer pilot_id);
//	新增一个飞行员的执照等级记录信息
	public Response newpilotlicenseratingsrecord(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
//	更新一个飞行员的执照等级记录信息
	public Response updatepilotlicenseratingsrecord(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
//	删除一个飞行员的执照等级记录信息
	public Response deletepilotlicenseratingsrecord(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
	
	/**
	 * 
	 * 飞行经历累计
	 * 
	 */	
	
//	查询一个飞行员的经验累计
	public Response summaryoflogbooksbypilot(Integer pilot_id);
//	新增一个飞行员的经验累计
	public Response newsummaryoflogbooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);
//	更新一个飞行员的经验累计
	public Response updatesummaryoflogbooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);
//	删除一个飞行员的经验累计
	public Response deletesummaryoflogbooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);

	/**
	 * 
	 * 日常飞行
	 * 
	 */
//	取得一个飞行员的日常飞行信息列表
	public Response routineFlightbyPilotid(Integer pilot_id);	
//	新增一个飞行员的日常飞行信息
	public Response newRoutineflight(Integer pilot_id, List<Routineflight> routineflgihtList);
//	更新一个飞行员的日常飞行信息
	public Response updateRoutineflight(Integer pilot_id, List<Routineflight> routineflgihtList);
//	删除一个飞行员的日常飞行信息
	public Response deleteRoutineflight(Integer pilot_id, List<Routineflight> routineflgihtList);
	
	/**
	 * 
	 * 飞行训练
	 * 
	 */	
//	取得一个飞行员的飞行训练信息列表
	public Response flightTrainingbyPilotid(Integer pilot_id);	
//	新增一个飞行员的飞行训练信息
	public Response newFlightraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
//	修改一个飞行员的飞行训练信息
	public Response updateFlightraining(Integer pilot_idp, List<Flighttraining> flighttrainingList);
//	删除一个飞行员的飞行训练信息
	public Response deleteFlightraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
	
	/**
	 * 
	 * 飞行检查
	 * 
	 */	
//	取得一个飞行员的飞行检查信息列表
	public Response flightCheckbyPilotid(Integer pilot_id);
//	新增一个飞行员的飞行检查信息
	public Response newFlightcheck(Integer pilot_id, List<Flightcheck> flightcheckList);
//	修改一个飞行员的飞行检查信息
	public Response updateFlightcheck(Integer pilot_id, List<Flightcheck> flightcheckList);
//	删除一个飞行员的飞行检查信息
	public Response deleteFlightcheck(Integer pilot_id, List<Flightcheck> flightcheckList);
	
	/**
	 * 
	 * 模拟机训练
	 * 
	 */	
//	取得一个飞行员的模拟机训练信息列表
	public Response simulatorTrainingbyPilotid(Integer pilot_id);
//	新增一个飞行员的模拟机训练信息
	public Response newSimulatortraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
//	修改一个飞行员的模拟机训练信息
	public Response updateSimulatortraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
//	删除一个飞行员的模拟机训练信息
	public Response deleteSimulatortraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
	

	/**
	 * 
	 * 航班信息
	 * 
	 */
	
//	新增航班信息
	public Response addFlights();
//	查询航班信息
	public Response getFlights();
	
	/**
	 * 
	 * 日常飞行 v2
	 * 
	 */
//	新增或保存日常飞行信息
	public Response saveRoutineFlight();
//	查询日常飞行信息
	public Response getRoutineFlight();

}
