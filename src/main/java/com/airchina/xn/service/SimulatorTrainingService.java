package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.SimulatorTrainingResp;
import com.airchina.xn.model.Simulatortraining;

public interface SimulatorTrainingService {

	List<Simulatortraining> getSimulatorTrainingByPilotID(Integer pilot_id);
	
	SimulatorTrainingResp newSimulatorTraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
	
	SimulatorTrainingResp updateSimulatorTraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
	
	SimulatorTrainingResp deleteSimulatorTraining(Integer pilot_id, List<Simulatortraining> simulatortrainingList);
	
	
}
