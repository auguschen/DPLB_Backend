package com.airchina.xn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.PilotMapper;
import com.airchina.xn.model.Pilot;
import com.airchina.xn.service.PilotService;

@Service("pilotService")
public class PilotServiceImpl implements PilotService {

	@Autowired
	private PilotMapper pilotmapper;
	
	
	public PilotMapper getPilotmapper() {
		return pilotmapper;
	}


	public void setPilotmapper(PilotMapper pilotmapper) {
		this.pilotmapper = pilotmapper;
	}


	@Override
	public Pilot getPilotById(Integer pilot_id) {
		return pilotmapper.selectByPrimaryKey(pilot_id);
	}


	@Override
	public List<Pilot> getPilotsByName(String name) {
		return pilotmapper.selectByName(name);
	}


	@Override
	public List<Pilot> getPilotsByLicenseNo(String licenseNo) {
		return pilotmapper.selectByLicenseNo(licenseNo);
	}


	@Override
	public Pilot newPilot(Pilot p) {
		Integer res = pilotmapper.insertWithoutID(p);
		return res>0?p:new Pilot();
	}


	@Override
	public Pilot updatePilot(Pilot p) {
		Integer res = pilotmapper.updateByPrimaryKey(p);
		return res>0?p:new Pilot();
	}


	@Override
	public Boolean deletePilot(Pilot p) {
		Integer res = pilotmapper.deleteByPrimaryKey(p.getId());
		return res>0?true:false;
	}


	@Override
	public Pilot getPilotsByStaffNumber(String staffNumber) {
		return pilotmapper.selectByStaffNumber(staffNumber);
	}


	@Override
	public List<Pilot> getPilots() {
		return pilotmapper.selectAll();
	}

}
