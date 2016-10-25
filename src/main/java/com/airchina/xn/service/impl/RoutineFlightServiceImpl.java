package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.RoutineflightMapper;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.entities.RoutineFlightResp;
import com.airchina.xn.model.Routineflight;
import com.airchina.xn.service.RoutineFlightService;

@Service("routineflightService")
public class RoutineFlightServiceImpl implements RoutineFlightService {

	@Autowired
	private RoutineflightMapper routineflightmapper; 
	
	public RoutineflightMapper getRoutineflightmapper() {
		return routineflightmapper;
	}

	public void setRoutineflightmapper(RoutineflightMapper routineflightmapper) {
		this.routineflightmapper = routineflightmapper;
	}

	@Override
	public RoutineFlightResp getRoutineFlightByPilotID(Integer pilot_id) {
		RoutineFlightResp res = new RoutineFlightResp();
		List<Routineflight> routineflightlist = routineflightmapper.selectByPilotID(pilot_id);
		if (routineflightlist!=null && !routineflightlist.isEmpty()){
			res.setIsSuccessful(true);
			res.setReturnCode(0);
			res.setRoutineflights(routineflightlist);
		}
		return res;
	}

	@Override
	public RoutineFlightResp newRoutineFlight(Integer pilot_id, List<Routineflight> routineflgihtList) {
		RoutineFlightResp res = new RoutineFlightResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Routineflight rf:routineflgihtList){
			rf.setPilotId(pilot_id);
			try {
				Integer re = routineflightmapper.insertWithoutID(rf);
				messages.add("effcet record " + re.toString());		
				iserror.add(false);
			} catch (Exception e) {
				iserror.add(true);
				messages.add(e.getMessage());			
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setRoutineflights(routineflgihtList);
		return res;
	}

	@Override
	public RoutineFlightResp updateRoutineFlight(Integer pilot_id, List<Routineflight> routineflgihtList) {
		RoutineFlightResp res = new RoutineFlightResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Routineflight rf:routineflgihtList){
			if(pilot_id.equals(rf.getPilotId())){
				try {
					Integer re = routineflightmapper.updateByPrimaryKey(rf);
					messages.add("effcet record " + re.toString());		
					iserror.add(false);
				} catch (Exception e) {
					iserror.add(true);
					messages.add(e.getMessage());			
				}
			}else{
				iserror.add(true);
				messages.add("pilot_id not equal");			
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setRoutineflights(routineflgihtList);
		return res;
	}

	@Override
	public RoutineFlightResp deleteRoutineFlight(Integer pilot_id, List<Routineflight> routineflgihtList) {
		RoutineFlightResp res = new RoutineFlightResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Routineflight rf:routineflgihtList){
			if(pilot_id.equals(rf.getPilotId())){
				try {
					Integer re = routineflightmapper.updateByPrimaryKey(rf);
					messages.add("effcet record " + re.toString());		
					iserror.add(false);
				} catch (Exception e) {
					iserror.add(true);
					messages.add(e.getMessage());			
				}
			}else{
				iserror.add(true);
				messages.add("pilot_id not equal");			
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setRoutineflights(routineflgihtList);
		return res;
	}

}
