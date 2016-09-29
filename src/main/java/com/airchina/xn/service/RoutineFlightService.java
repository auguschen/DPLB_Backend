package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.RoutineFlightResp;
import com.airchina.xn.model.Routineflight;

public interface RoutineFlightService {
	
	List<Routineflight> getRoutineFlightByPilotID(Integer pilot_id);
	
	RoutineFlightResp newRoutineFlight(Integer pilot_id, List<Routineflight> routineflgihtList);
	
	RoutineFlightResp updateRoutineFlight(Integer pilot_id, List<Routineflight> routineflgihtList);
	
	RoutineFlightResp deleteRoutineFlight(Integer pilot_id, List<Routineflight> routineflgihtList);
	
}
