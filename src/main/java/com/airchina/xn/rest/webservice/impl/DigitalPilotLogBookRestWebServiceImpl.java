package com.airchina.xn.rest.webservice.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.entities.FlightCheckResp;
import com.airchina.xn.entities.FlightTrainingResp;
import com.airchina.xn.entities.LicensesRatingResp;
import com.airchina.xn.entities.RoutineFlightResp;
import com.airchina.xn.entities.SimulatorTrainingResp;
import com.airchina.xn.entities.SummaryoflogbooksResp;
import com.airchina.xn.model.Flightcheck;
import com.airchina.xn.model.Flighttraining;
import com.airchina.xn.model.Licensesratingsrecord;
import com.airchina.xn.model.Pilot;
import com.airchina.xn.model.Routineflight;
import com.airchina.xn.model.Simulatortraining;
import com.airchina.xn.model.Summaryoflogbooks;
import com.airchina.xn.rest.webservice.DigitalPilotLogBookRestWebService;
import com.airchina.xn.service.FlightCheckService;
import com.airchina.xn.service.FlightTrainingService;
import com.airchina.xn.service.LicensesRatingService;
import com.airchina.xn.service.PilotService;
import com.airchina.xn.service.RoutineFlightService;
import com.airchina.xn.service.SimulatorTrainingService;
import com.airchina.xn.service.SummaryOfLogBooksService;

@Service("DigitalPilotLogBookRestWebService")
@Path("/")
public class DigitalPilotLogBookRestWebServiceImpl implements DigitalPilotLogBookRestWebService {

	@Autowired
	private PilotService pilotservice;
	
	@Autowired
	private LicensesRatingService licensesratingservice;
	
	@Autowired
	private SummaryOfLogBooksService summaryoflogbooksservice;
	
	@Autowired
	private RoutineFlightService routineflightservice;
	
	@Autowired
	private FlightCheckService flightcheckservice;
	
	@Autowired
	private FlightTrainingService flighttraningservice;
	
	@Autowired
	private SimulatorTrainingService simulatortrainingservice;
	
		
	public SimulatorTrainingService getSimulatortrainingservice() {
		return simulatortrainingservice;
	}

	public void setSimulatortrainingservice(SimulatorTrainingService simulatortrainingservice) {
		this.simulatortrainingservice = simulatortrainingservice;
	}

	public FlightTrainingService getFlighttraningservice() {
		return flighttraningservice;
	}

	public void setFlighttraningservice(FlightTrainingService flighttraningservice) {
		this.flighttraningservice = flighttraningservice;
	}

	public FlightCheckService getFlightcheckservice() {
		return flightcheckservice;
	}

	public void setFlightcheckservice(FlightCheckService flightcheckservice) {
		this.flightcheckservice = flightcheckservice;
	}

	public RoutineFlightService getRoutineflightservice() {
		return routineflightservice;
	}

	public void setRoutineflightservice(RoutineFlightService routineflightservice) {
		this.routineflightservice = routineflightservice;
	}

	public SummaryOfLogBooksService getSummaryoflogbooksservice() {
		return summaryoflogbooksservice;
	}

	public void setSummaryoflogbooksservice(SummaryOfLogBooksService summaryoflogbooksservice) {
		this.summaryoflogbooksservice = summaryoflogbooksservice;
	}

	public LicensesRatingService getLicensesratingservice() {
		return licensesratingservice;
	}

	public void setLicensesratingservice(LicensesRatingService licensesratingservice) {
		this.licensesratingservice = licensesratingservice;
	}

	public PilotService getPilotservice() {
		return pilotservice;
	}

	public void setPilotservice(PilotService pilotservice) {
		this.pilotservice = pilotservice;
	}

	//	飞行员基础信息
	@Override
	@GET
	@Path("/p/get/n={name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Pilot> pilotsbyname(@PathParam("name") String name) {
		return pilotservice.getPilotsByName(name);
	}

	@Override
	@GET
	@Path("/p/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Pilot> pilots() {
		return pilotservice.getPilots();
	}

	@Override
	@GET
	@Path("/p/get/i={id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Pilot pilotbyid(@PathParam("id") Integer id) {
		return pilotservice.getPilotById(id);
	}

	@Override
	@GET
	@Path("/p/get/s={staffNumber}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Pilot pilotbystaffnumber(@PathParam("staffNumber") String staffNumber) {
		return pilotservice.getPilotsByStaffNumber(staffNumber);
	}

	@Override
	@GET
	@Path("/p/get/l={licenseNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Pilot> pilotsbylicenseno(@PathParam("licenseNo") String licenseNo) {
		return pilotservice.getPilotsByLicenseNo(licenseNo);
	}

	@Override
	@POST
	@Path("/p/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Pilot newpilot(Pilot p) {
		return pilotservice.newPilot(p);
	}

	@Override
	@PUT
	@Path("/p/upd")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Pilot updatepilot(Pilot p) {
		return pilotservice.updatePilot(p);
	}

	@Override
	@DELETE
	@Path("/p/del")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Boolean deletepilot(Pilot p) {
		return pilotservice.deletePilot(p);
	}

	
//	执照等级记录
	@Override
	@GET
	@Path("/l/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Licensesratingsrecord> pilotlicenseratingsrecordbypilot(@PathParam("pilot_id") Integer pilot_id) {
		return licensesratingservice.getLicensesRatingByPilotId(pilot_id);
	}

	@Override
	@POST
	@Path("/l/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public LicensesRatingResp newpilotlicenseratingsrecord(@PathParam("pilot_id") Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList) {
		return licensesratingservice.newLicensesRating(pilot_id, licenseratingsrecordList);
	}

	@Override
	@PUT
	@Path("/l/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public LicensesRatingResp updatepilotlicenseratingsrecord(@PathParam("pilot_id") Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList) {
		return licensesratingservice.updateLicensesRating(pilot_id, licenseratingsrecordList);
	}

	@Override
	@DELETE
	@Path("/l/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public LicensesRatingResp deletepilotlicenseratingsrecord(@PathParam("pilot_id") Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList) {
		return licensesratingservice.deleteLicensesRating(pilot_id, licenseratingsrecordList);
	}

//	飞行累积信息
	@Override
	@GET
	@Path("/solb/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Summaryoflogbooks> summaryoflogbooksbypilot(@PathParam("pilot_id") Integer pilot_id) {
		return summaryoflogbooksservice.getSummaryofLogBooksByPilotID(pilot_id);
	}

	@Override
	@POST
	@Path("/solb/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SummaryoflogbooksResp newsummaryoflogbooks(@PathParam("pilot_id") Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList) {
		return summaryoflogbooksservice.newSummaryofLogBooks(pilot_id, summaryoflogbooksList);
	}

	@Override
	@PUT
	@Path("/solb/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SummaryoflogbooksResp updatesummaryoflogbooks(@PathParam("pilot_id") Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList) {
		return summaryoflogbooksservice.updateSummaryofLogBooks(pilot_id, summaryoflogbooksList);
	}

	@Override
	@DELETE
	@Path("/solb/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SummaryoflogbooksResp deletesummaryoflogbooks(@PathParam("pilot_id") Integer pilot_id,
			List<Summaryoflogbooks> summaryoflogbooksList) {
		return summaryoflogbooksservice.deleteSummaryofLogBooks(pilot_id, summaryoflogbooksList);
	}

//	日常飞行
	@Override
	@GET
	@Path("/r/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Routineflight> routineFlightbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return routineflightservice.getRoutineFlightByPilotID(pilot_id);
	}

	@Override
	@POST
	@Path("/r/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public RoutineFlightResp newRoutineflight(@PathParam("pilot_id") Integer pilot_id, List<Routineflight> routineflgihtList) {
		return routineflightservice.newRoutineFlight(pilot_id, routineflgihtList);
	}

	@Override
	@PUT
	@Path("/r/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public RoutineFlightResp updateRoutineflight(@PathParam("pilot_id") Integer pilot_id, List<Routineflight> routineflgihtList) {
		return routineflightservice.updateRoutineFlight(pilot_id, routineflgihtList);
	}

	@Override
	@DELETE
	@Path("/r/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public RoutineFlightResp deleteRoutineflight(@PathParam("pilot_id") Integer pilot_id, List<Routineflight> routineflgihtList) {
		return routineflightservice.deleteRoutineFlight(pilot_id, routineflgihtList);
	}

//	飞行训练
	@Override
	@GET
	@Path("/t/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flighttraining> flightTrainingbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return flighttraningservice.getFlightTrainingByPilotID(pilot_id);
	}

	@Override
	@POST
	@Path("/t/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public FlightTrainingResp newFlightraining(@PathParam("pilot_id") Integer pilot_id, List<Flighttraining> flighttrainingList) {
		return flighttraningservice.newFlightTraining(pilot_id, flighttrainingList);
	}

	@Override
	@PUT
	@Path("/t/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public FlightTrainingResp updateFlightraining(@PathParam("pilot_id") Integer pilot_id, List<Flighttraining> flighttrainingList) {
		return flighttraningservice.updateFlightTraining(pilot_id, flighttrainingList);
	}

	@Override
	@DELETE
	@Path("/t/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public FlightTrainingResp deleteFlightraining(@PathParam("pilot_id") Integer pilot_id, List<Flighttraining> flighttrainingList) {
		return flighttraningservice.deleteFlightTraining(pilot_id, flighttrainingList);
	}

//	飞行检查
	@Override
	@GET
	@Path("/c/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flightcheck> flightCheckbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return flightcheckservice.getFlightCheckByPilotID(pilot_id);
	}

	@Override
	@POST
	@Path("/c/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public FlightCheckResp newFlightcheck(@PathParam("pilot_id") Integer pilot_id, List<Flightcheck> flightcheckList) {
		return flightcheckservice.newFlightCheck(pilot_id, flightcheckList);
	}

	@Override
	@PUT
	@Path("/c/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public FlightCheckResp updateFlightcheck(@PathParam("pilot_id") Integer pilot_id, List<Flightcheck> flightcheckList) {
		return flightcheckservice.updateFlightCheck(pilot_id, flightcheckList);
	}

	@Override
	@DELETE
	@Path("/c/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public FlightCheckResp deleteFlightcheck(@PathParam("pilot_id") Integer pilot_id, List<Flightcheck> flightcheckList) {
		return flightcheckservice.deleteFlightCheck(pilot_id, flightcheckList);
	}

//	模拟机训练
	@Override
	@GET
	@Path("/s/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Simulatortraining> simulatorTrainingbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return simulatortrainingservice.getSimulatorTrainingByPilotID(pilot_id);
	}

	@Override
	@POST
	@Path("/s/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SimulatorTrainingResp newSimulatortraining(@PathParam("pilot_id") Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		return simulatortrainingservice.newSimulatorTraining(pilot_id, simulatortrainingList);
	}

	@Override
	@PUT
	@Path("/s/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SimulatorTrainingResp updateSimulatortraining(@PathParam("pilot_id") Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		return simulatortrainingservice.updateSimulatorTraining(pilot_id, simulatortrainingList);
	}

	@Override
	@DELETE
	@Path("/s/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SimulatorTrainingResp deleteSimulatortraining(@PathParam("pilot_id") Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		return simulatortrainingservice.deleteSimulatorTraining(pilot_id, simulatortrainingList);
	}

}
