package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.model.Pilot;

public interface PilotService {

	public Pilot getPilotById(Integer pilot_id); 
	
	public Pilot getPilotsByStaffNumber(String staffNumber);

	public List<Pilot> getPilotsByName(String name);
	
	public List<Pilot> getPilotsByLicenseNo(String licenseNo);
	
	public List<Pilot> getPilots();
	
	public Pilot newPilot(Pilot p);

	public Pilot updatePilot(Pilot p);
	
	public Boolean deletePilot(Pilot p);
		
}
