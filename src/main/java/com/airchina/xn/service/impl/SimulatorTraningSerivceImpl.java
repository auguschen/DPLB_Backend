package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.SimulatortrainingMapper;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.entities.SimulatorTrainingResp;
import com.airchina.xn.model.Simulatortraining;
import com.airchina.xn.service.SimulatorTrainingService;

@Service("simulatortraningService")
public class SimulatorTraningSerivceImpl implements SimulatorTrainingService {
	
	@Autowired
	private SimulatortrainingMapper simulatortrainingmapper;
	
	public SimulatortrainingMapper getSimulatortrainingmapper() {
		return simulatortrainingmapper;
	}

	public void setSimulatortrainingmapper(SimulatortrainingMapper simulatortrainingmapper) {
		this.simulatortrainingmapper = simulatortrainingmapper;
	}

	@Override
	public List<Simulatortraining> getSimulatorTrainingByPilotID(Integer pilot_id) {
		return simulatortrainingmapper.selectByPilotID(pilot_id);
	}

	@Override
	public SimulatorTrainingResp newSimulatorTraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		SimulatorTrainingResp res = new SimulatorTrainingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Simulatortraining st:simulatortrainingList){
			st.setPilotId(pilot_id);
			try {
				Integer re = simulatortrainingmapper.insertWithoutID(st);
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
		res.setSimulatortrainings(simulatortrainingList);
		return res;
	}

	@Override
	public SimulatorTrainingResp updateSimulatorTraining(Integer pilot_id,
			List<Simulatortraining> simulatortrainingList) {
		SimulatorTrainingResp res = new SimulatorTrainingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Simulatortraining st:simulatortrainingList){
			if(pilot_id.equals(st.getPilotId())){
				try {
					Integer re = simulatortrainingmapper.updateByPrimaryKey(st);
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
		res.setSimulatortrainings(simulatortrainingList);
		return res;
	}

	@Override
	public SimulatorTrainingResp deleteSimulatorTraining(Integer pilot_id,
			List<Simulatortraining> simulatortrainingList) {
		SimulatorTrainingResp res = new SimulatorTrainingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Simulatortraining st:simulatortrainingList){
			if(pilot_id.equals(st.getPilotId())){
				try {
					Integer re = simulatortrainingmapper.updateByPrimaryKey(st);
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
		res.setSimulatortrainings(simulatortrainingList);
		return res;
	}

}
