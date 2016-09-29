package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.common.PageParam;
import com.airchina.xn.model.Aircraft;

public interface AircraftService {

	public List<Aircraft> getAllAircraft();

	public List<Aircraft> getAllAircraft(PageParam pp);

	public Aircraft getAircraftByRegNo(String regno);

	public List<Aircraft> getAircraftByType(String typecatalog, String typeafaircraft);

	public List<Aircraft> getAircraftByType(String typecatalog, String typeafaircraft, PageParam pp);

	public Aircraft newAircraft(Aircraft ac);

	public Aircraft updateAircraft(Aircraft ac);
	
	public Boolean deleteAircraft(Aircraft ac);
}
