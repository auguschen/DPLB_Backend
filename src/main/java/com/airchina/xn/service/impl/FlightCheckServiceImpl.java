package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.FlightcheckMapper;
import com.airchina.xn.entities.FlightCheckResp;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.model.Flightcheck;
import com.airchina.xn.service.FlightCheckService;

@Service("flightcheckService")
public class FlightCheckServiceImpl implements FlightCheckService {
	
	@Autowired
	private FlightcheckMapper flightcheckmapper;
	

	public FlightcheckMapper getFlightcheckmapper() {
		return flightcheckmapper;
	}

	public void setFlightcheckmapper(FlightcheckMapper flightcheckmapper) {
		this.flightcheckmapper = flightcheckmapper;
	}

	@Override
	public List<Flightcheck> getFlightCheckByPilotID(Integer pilot_id) {
		return flightcheckmapper.selectByPilotID(pilot_id);
	}

	@Override
	public FlightCheckResp newFlightCheck(Integer pilot_id, List<Flightcheck> flightcheckList) {
		FlightCheckResp res = new FlightCheckResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Flightcheck fc:flightcheckList){
			fc.setPilotId(pilot_id);
			try {
				Integer re = flightcheckmapper.insertWithoutID(fc);
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
		res.setFlightchecks(flightcheckList);
		return res;
	}

	@Override
	public FlightCheckResp updateFlightCheck(Integer pilot_id, List<Flightcheck> flightcheckList) {
		FlightCheckResp res = new FlightCheckResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Flightcheck fc:flightcheckList){
			if(pilot_id.equals(fc.getPilotId())){
				try {
					Integer re = flightcheckmapper.updateByPrimaryKey(fc);
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
		res.setFlightchecks(flightcheckList);
		return res;
	}

	@Override
	public FlightCheckResp deleteFlightCheck(Integer pilot_id, List<Flightcheck> flightcheckList) {
		FlightCheckResp res = new FlightCheckResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Flightcheck fc:flightcheckList){
			if(pilot_id.equals(fc.getPilotId())){
				try {
					Integer re = flightcheckmapper.updateByPrimaryKey(fc);
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
		res.setFlightchecks(flightcheckList);
		return res;
	}

}
