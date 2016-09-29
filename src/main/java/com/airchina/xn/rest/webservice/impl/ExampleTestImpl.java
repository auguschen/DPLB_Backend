package com.airchina.xn.rest.webservice.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.model.Aircraft;
import com.airchina.xn.rest.webservice.ExampleTest;
import com.airchina.xn.service.AircraftService;


@Service("exampletestService")
@Path("/")
public class ExampleTestImpl implements ExampleTest {

	@Autowired
	private AircraftService aircraftservice;
	
	public AircraftService getAircraftservice() {
		return aircraftservice;
	}

	public void setAircraftservice(AircraftService aircraftservice) {
		this.aircraftservice = aircraftservice;
	}

	@Override
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Aircraft> listAllAircraft() {
		return aircraftservice.getAllAircraft();
	}

}
