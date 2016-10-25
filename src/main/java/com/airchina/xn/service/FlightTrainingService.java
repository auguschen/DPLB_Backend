package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.FlightTrainingResp;
import com.airchina.xn.model.Flighttraining;

public interface FlightTrainingService {

	FlightTrainingResp getFlightTrainingByPilotID(Integer pilot_id);
	
	FlightTrainingResp newFlightTraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
	
	FlightTrainingResp updateFlightTraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
	
	FlightTrainingResp deleteFlightTraining(Integer pilot_id, List<Flighttraining> flighttrainingList);
	
}
