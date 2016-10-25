package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.FlighttrainingMapper;
import com.airchina.xn.entities.FlightTrainingResp;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.model.Flighttraining;
import com.airchina.xn.service.FlightTrainingService;

@Service("flighttrainingService")
public class FlightTrainingServiceImpl implements FlightTrainingService {

	@Autowired
	private FlighttrainingMapper flighttrainingmapper;
	
	public FlighttrainingMapper getFlighttrainingmapper() {
		return flighttrainingmapper;
	}

	public void setFlighttrainingmapper(FlighttrainingMapper flighttrainingmapper) {
		this.flighttrainingmapper = flighttrainingmapper;
	}

	@Override
	public FlightTrainingResp getFlightTrainingByPilotID(Integer pilot_id) {
		FlightTrainingResp res = new FlightTrainingResp();
		List<Flighttraining> flighttraininglist =flighttrainingmapper.selectByPilotID(pilot_id);
		if (flighttraininglist!=null && !flighttraininglist.isEmpty()){
			res.setIsSuccessful(true);
			res.setReturnCode(0);
			res.setFlighttrainings(flighttraininglist);
		}
		return res;
	}

	@Override
	public FlightTrainingResp newFlightTraining(Integer pilot_id, List<Flighttraining> flighttrainingList) {
		FlightTrainingResp res = new FlightTrainingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Flighttraining ft:flighttrainingList){
			ft.setPilotId(pilot_id);
			try {
				Integer re = flighttrainingmapper.insertWithoutID(ft);
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
		res.setFlighttrainings(flighttrainingList);
		return res;
	}

	@Override
	public FlightTrainingResp updateFlightTraining(Integer pilot_id, List<Flighttraining> flighttrainingList) {
		FlightTrainingResp res = new FlightTrainingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Flighttraining ft:flighttrainingList){
			if(pilot_id.equals(ft.getPilotId())){
				try {
					Integer re = flighttrainingmapper.updateByPrimaryKey(ft);
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
		res.setFlighttrainings(flighttrainingList);
		return res;
	}

	@Override
	public FlightTrainingResp deleteFlightTraining(Integer pilot_id, List<Flighttraining> flighttrainingList) {
		FlightTrainingResp res = new FlightTrainingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Flighttraining ft:flighttrainingList){
			if(pilot_id.equals(ft.getPilotId())){
				try {
					Integer re = flighttrainingmapper.updateByPrimaryKey(ft);
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
		res.setFlighttrainings(flighttrainingList);
		return res;
	}

}
