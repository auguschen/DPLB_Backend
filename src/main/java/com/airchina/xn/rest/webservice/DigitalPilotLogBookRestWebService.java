/**
 * 
 */
package com.airchina.xn.rest.webservice;

import java.util.List;

import com.airchina.xn.entities.FlightCheckResp;
import com.airchina.xn.entities.FlightTrainingResp;
import com.airchina.xn.entities.LicensesRatingResp;
import com.airchina.xn.entities.RoutineFlightResp;
import com.airchina.xn.entities.SimulatorTrainingResp;
import com.airchina.xn.entities.SummaryoflogbooksResp;
import com.airchina.xn.model.Flightcheck;
import com.airchina.xn.model.Flighttraining;
import com.airchina.xn.model.Licensesratingsrecord;
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
	public List<Pilot> pilots();
//	根据姓名返回飞行员列表
	public List<Pilot> pilotsbyname(String name);
//	根据主键返回飞行员
	public Pilot pilotbyid(Integer id);
//	根据员工号返回飞行员
	public Pilot pilotbystaffnumber(String staffNumber);
//	根据执照号返回飞行员列表
	public List<Pilot> pilotsbylicenseno(String licenseNo);
//	新增一个飞行员信息
	public Pilot newpilot(Pilot p);
//	更新一个飞行员信息
	public Pilot updatepilot(Pilot p);
//	删除一个飞行员信息
	public Boolean deletepilot(Pilot p);
		
	/**
	 * 
	 * 执照等级记录
	 * 
	 */	
//	查询一个飞行员的执照等级记录信息
	public List<Licensesratingsrecord> pilotlicenseratingsrecordbypilot(Integer pilot_id);
//	新增一个飞行员的执照等级记录信息
	public LicensesRatingResp newpilotlicenseratingsrecord(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
//	更新一个飞行员的执照等级记录信息
	public LicensesRatingResp updatepilotlicenseratingsrecord(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
//	删除一个飞行员的执照等级记录信息
	public LicensesRatingResp deletepilotlicenseratingsrecord(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
	
	/**
	 * 
	 * 飞行经历累计
	 * 
	 */	
	
//	查询一个飞行员的经验累计
	public List<Summaryoflogbooks> summaryoflogbooksbypilot(Integer pilot_id);
//	新增一个飞行员的经验累计
	public SummaryoflogbooksResp newsummaryoflogbooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);
//	更新一个飞行员的经验累计
	public SummaryoflogbooksResp updatesummaryoflogbooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);
//	删除一个飞行员的经验累计
	public SummaryoflogbooksResp deletesummaryoflogbooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);

	/**
	 * 
	 * 日常飞行
	 * 
	 */
//	取得一个飞行员的日常飞行信息列表
	public List<Routineflight> routineFlightbyPilotid(Integer pilot_id);	
//	新增一个飞行员的日常飞行信息
	public RoutineFlightResp newRoutineflight(Integer pilot_id, List<Routineflight> routineflgihtList);
//	更新一个飞行员的日常飞行信息
	public RoutineFlightResp updateRoutineflight(Integer pilot_id, List<Routineflight> routineflgihtList);
//	删除一个飞行员的日常飞行信息
	public RoutineFlightResp deleteRoutineflight(Integer pilot_id, List<Routineflight> routineflgihtList);
	
	/**
	 * 
	 * 飞行训练
	 * 
	 */	
//	取得一个飞行员的飞行训练信息列表
	public List<Flighttraining> flightTrainingbyPilotid(Integer pilot_id);	
//	新增一个飞行员的飞行训练信息
	public FlightTrainingResp newFlightraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
//	修改一个飞行员的飞行训练信息
	public FlightTrainingResp updateFlightraining(Integer pilot_idp, List<Flighttraining> flighttrainingList);
//	删除一个飞行员的飞行训练信息
	public FlightTrainingResp deleteFlightraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
	
	/**
	 * 
	 * 飞行检查
	 * 
	 */	
//	取得一个飞行员的飞行检查信息列表
	public List<Flightcheck> flightCheckbyPilotid(Integer pilot_id);
//	新增一个飞行员的飞行检查信息
	public FlightCheckResp newFlightcheck(Integer pilot_id, List<Flightcheck> flightcheckList);
//	修改一个飞行员的飞行检查信息
	public FlightCheckResp updateFlightcheck(Integer pilot_id, List<Flightcheck> flightcheckList);
//	删除一个飞行员的飞行检查信息
	public FlightCheckResp deleteFlightcheck(Integer pilot_id, List<Flightcheck> flightcheckList);
	
	/**
	 * 
	 * 模拟机训练
	 * 
	 */	
//	取得一个飞行员的模拟机训练信息列表
	public List<Simulatortraining> simulatorTrainingbyPilotid(Integer pilot_id);
//	新增一个飞行员的模拟机训练信息
	public SimulatorTrainingResp newSimulatortraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
//	修改一个飞行员的模拟机训练信息
	public SimulatorTrainingResp updateSimulatortraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
//	删除一个飞行员的模拟机训练信息
	public SimulatorTrainingResp deleteSimulatortraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
	

}
