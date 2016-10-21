package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.model.Pilot;
import com.airchina.xn.entities.UploadFileEntity;
import com.airchina.xn.model.Photos;

public interface PilotService {

	public Pilot getPilotById(Integer pilot_id); 
	
	public Pilot getPilotsByStaffNumber(String staffNumber);

	public List<Pilot> getPilotsByName(String name);
	
	public List<Pilot> getPilotsByLicenseNo(String licenseNo);
	
	public List<Pilot> getPilots();
	
	public Pilot newPilot(Pilot p);

	public Pilot updatePilot(Pilot p);
	
	public Boolean deletePilot(Pilot p);
	
	public Photos getPilotPhoto(Integer pilot_id);
	
	public Photos newPilotPhoto(Integer pilot_id, UploadFileEntity ufn);
	
	public Photos updatePilotPhoto(Integer pilot_id, UploadFileEntity ufn);
	
	public Boolean deletePilotPhoto(Photos photo);
		
}
