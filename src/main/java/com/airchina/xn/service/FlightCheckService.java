package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.FlightCheckResp;
import com.airchina.xn.model.Flightcheck;

public interface FlightCheckService {

	List<Flightcheck> getFlightCheckByPilotID(Integer pilot_id);
	
	FlightCheckResp newFlightCheck(Integer pilot_id, List<Flightcheck> flightcheckList);
	
	FlightCheckResp updateFlightCheck(Integer pilot_id, List<Flightcheck> flightcheckList);
	
	FlightCheckResp deleteFlightCheck(Integer pilot_id, List<Flightcheck> flightcheckList);
	
}
