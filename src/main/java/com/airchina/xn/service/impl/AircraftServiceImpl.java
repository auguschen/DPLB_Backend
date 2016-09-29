package com.airchina.xn.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.common.PageParam;
import com.airchina.xn.dao.AircraftMapper;
import com.airchina.xn.model.Aircraft;
import com.airchina.xn.service.AircraftService;


@Service("aircraftService")
public class AircraftServiceImpl implements AircraftService {

	@Autowired
	private AircraftMapper aircraftmapper;
	
	public AircraftMapper getAircraftmapper() {
		return aircraftmapper;
	}

	public void setAircraftmapper(AircraftMapper aircraftmapper) {
		this.aircraftmapper = aircraftmapper;
	}

	@Override
	public List<Aircraft> getAllAircraft() {
		return aircraftmapper.selectAll();
	}

	@Override
	public Aircraft getAircraftByRegNo(String regno) {		
		return aircraftmapper.selectByRegNo(regno);
	}

	@Override
	public List<Aircraft> getAircraftByType(String typecatalog, String typeafaircraft) {
		return aircraftmapper.selectByType(typecatalog, typeafaircraft);
	}

	@Override
	public Aircraft newAircraft(Aircraft ac) {
		Integer res = aircraftmapper.insertWithoutID(ac);
		return res>0?ac:new Aircraft();
	}

	@Override
	public Aircraft updateAircraft(Aircraft ac) {
		Integer res = aircraftmapper.updateByPrimaryKey(ac);
		return res>0?ac:new Aircraft();
	}

	@Override
	public Boolean deleteAircraft(Aircraft ac) {
		Integer res = aircraftmapper.deleteByPrimaryKey(ac.getId());
		return res>0?true:false;
	}

	@Override
	public List<Aircraft> getAllAircraft(PageParam pp) {
		return aircraftmapper.selectAllPaged(pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}

	@Override
	public List<Aircraft> getAircraftByType(String typecatalog, String typeafaircraft, PageParam pp) {
		return aircraftmapper.selectByTypePaged(typecatalog, typeafaircraft, pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}


}
