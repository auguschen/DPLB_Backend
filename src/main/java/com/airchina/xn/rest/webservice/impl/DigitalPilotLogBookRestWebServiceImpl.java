package com.airchina.xn.rest.webservice.impl;

import java.util.ArrayList;
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
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.entities.PilotsResponse;
import com.airchina.xn.entities.PhotosResponse;
import com.airchina.xn.entities.PilotResponse;
import com.airchina.xn.entities.Pilots;
import com.airchina.xn.entities.UploadFileEntity;
import com.airchina.xn.model.Flightcheck;
import com.airchina.xn.model.Flighttraining;
import com.airchina.xn.model.Licensesratingsrecord;
import com.airchina.xn.model.Photos;
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
	public Response pilotsbyname(@PathParam("name") String name) {
		List<Pilot> pilots = pilotservice.getPilotsByName(name);
		PilotsResponse pilotRes = new PilotsResponse();
		if (pilots!=null && !pilots.isEmpty()){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilots(new Pilots(pilots));
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@GET
	@Path("/p/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response pilots() {
		List<Pilot> pilots = pilotservice.getPilots();
		PilotsResponse pilotRes = new PilotsResponse();
		if (pilots!=null && !pilots.isEmpty()){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilots(new Pilots(pilots));
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@GET
	@Path("/p/get/i={id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response pilotbyid(@PathParam("id") Integer id) {
		Pilot pilot = pilotservice.getPilotById(id);
		PilotResponse pilotRes = new PilotResponse();
		if (pilot!=null){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilot(pilot);
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@GET
	@Path("/p/get/s={staffNumber}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response pilotbystaffnumber(@PathParam("staffNumber") String staffNumber) {
		Pilot pilot = pilotservice.getPilotsByStaffNumber(staffNumber);
		PilotResponse pilotRes = new PilotResponse();
		if (pilot!=null){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilot(pilot);
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@GET
	@Path("/p/get/l={licenseNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response pilotsbylicenseno(@PathParam("licenseNo") String licenseNo) {
		List<Pilot> pilots = pilotservice.getPilotsByLicenseNo(licenseNo);
		PilotsResponse pilotRes = new PilotsResponse();
		if (pilots!=null && !pilots.isEmpty()){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilots(new Pilots(pilots));
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@POST
	@Path("/p/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newpilot(Pilot p) {
		Pilot pilot = pilotservice.newPilot(p);
		PilotResponse pilotRes = new PilotResponse();
		if (pilot!=null){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilot(pilot);
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@PUT
	@Path("/p/upd")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updatepilot(Pilot p) {
		Pilot pilot = pilotservice.updatePilot(p);
		PilotResponse pilotRes = new PilotResponse();
		if (pilot!=null){
			pilotRes.setIsSuccessful(true);
			pilotRes.setReturnCode(0);
			pilotRes.setPilot(pilot);
		}
		return Response.ok(pilotRes).build();
	}

	@Override
	@DELETE
	@Path("/p/del")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletepilot(Pilot p) {
		Boolean status = pilotservice.deletePilot(p);
		PilotResponse pilotRes = new PilotResponse();
		if (status==true){
			pilotRes.setIsSuccessful(status);
			pilotRes.setReturnCode(0);
		}
		return Response.ok(pilotRes).build();
	}

//	飞行员照片
	
	@Override
	public Response updatepilotPhoto(Integer pilot_id, UploadFileEntity ufn) {
		PhotosResponse photoRes = new PhotosResponse();
		Photos photo = pilotservice.updatePilotPhoto(pilot_id, ufn);
		if (photo!=null){
			photoRes.setIsSuccessful(true);
			photoRes.setReturnCode(0);
			photoRes.setPhoto(photo);
		}
		return Response.ok(photoRes).build();
	}

	@Override
	public Response deletepilotPhoto(Photos photo) {
		Boolean status = pilotservice.deletePilotPhoto(photo);
		PhotosResponse photoRes = new PhotosResponse();
		if (status==true){
			photoRes.setIsSuccessful(status);
			photoRes.setReturnCode(0);
		}
		return Response.ok(photoRes).build();
	}

	@Override
	public Response getPilotPhoto(Integer pilot_id) {
		PhotosResponse photoRes = new PhotosResponse();
		Photos photo = pilotservice.getPilotPhoto(pilot_id);
		if (photo!=null){
			photoRes.setIsSuccessful(true);
			photoRes.setReturnCode(0);
			photoRes.setPhoto(photo);
		}
		return Response.ok(photoRes).build();
	}

	
//	执照等级记录
	@Override
	@GET
	@Path("/l/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response pilotlicenseratingsrecordbypilot(@PathParam("pilot_id") Integer pilot_id) {	
		return  Response.ok(licensesratingservice.getLicensesRatingByPilotId(pilot_id)).build();
	}

	@Override
	@POST
	@Path("/l/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newpilotlicenseratingsrecord(@PathParam("pilot_id") Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList) {
		return  Response.ok(licensesratingservice.newLicensesRating(pilot_id, licenseratingsrecordList)).build();
	}

	@Override
	@PUT
	@Path("/l/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updatepilotlicenseratingsrecord(@PathParam("pilot_id") Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList) {
		return  Response.ok(licensesratingservice.updateLicensesRating(pilot_id, licenseratingsrecordList)).build();
	}

	@Override
	@DELETE
	@Path("/l/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletepilotlicenseratingsrecord(@PathParam("pilot_id") Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList) {
		return Response.ok(licensesratingservice.deleteLicensesRating(pilot_id, licenseratingsrecordList)).build();
	}

//	飞行累积信息
	@Override
	@GET
	@Path("/solb/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response summaryoflogbooksbypilot(@PathParam("pilot_id") Integer pilot_id) {
		return Response.ok(summaryoflogbooksservice.getSummaryofLogBooksByPilotID(pilot_id)).build();
	}

	@Override
	@POST
	@Path("/solb/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newsummaryoflogbooks(@PathParam("pilot_id") Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList) {
		return Response.ok(summaryoflogbooksservice.newSummaryofLogBooks(pilot_id, summaryoflogbooksList)).build();
	}

	@Override
	@PUT
	@Path("/solb/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updatesummaryoflogbooks(@PathParam("pilot_id") Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList) {
		return Response.ok(summaryoflogbooksservice.updateSummaryofLogBooks(pilot_id, summaryoflogbooksList)).build();
	}

	@Override
	@DELETE
	@Path("/solb/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletesummaryoflogbooks(@PathParam("pilot_id") Integer pilot_id,
			List<Summaryoflogbooks> summaryoflogbooksList) {
		return Response.ok(summaryoflogbooksservice.deleteSummaryofLogBooks(pilot_id, summaryoflogbooksList)).build();
	}

//	日常飞行
	@Override
	@GET
	@Path("/r/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response routineFlightbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return Response.ok(routineflightservice.getRoutineFlightByPilotID(pilot_id)).build();
	}

	@Override
	@POST
	@Path("/r/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newRoutineflight(@PathParam("pilot_id") Integer pilot_id, List<Routineflight> routineflgihtList) {
		return Response.ok(routineflightservice.newRoutineFlight(pilot_id, routineflgihtList)).build();
	}

	@Override
	@PUT
	@Path("/r/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateRoutineflight(@PathParam("pilot_id") Integer pilot_id, List<Routineflight> routineflgihtList) {
		return Response.ok(routineflightservice.updateRoutineFlight(pilot_id, routineflgihtList)).build();
	}

	@Override
	@DELETE
	@Path("/r/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteRoutineflight(@PathParam("pilot_id") Integer pilot_id, List<Routineflight> routineflgihtList) {
		return Response.ok(routineflightservice.deleteRoutineFlight(pilot_id, routineflgihtList)).build();
	}

//	飞行训练
	@Override
	@GET
	@Path("/t/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response flightTrainingbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return Response.ok(flighttraningservice.getFlightTrainingByPilotID(pilot_id)).build();
	}

	@Override
	@POST
	@Path("/t/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newFlightraining(@PathParam("pilot_id") Integer pilot_id, List<Flighttraining> flighttrainingList) {
		return Response.ok(flighttraningservice.newFlightTraining(pilot_id, flighttrainingList)).build();
	}

	@Override
	@PUT
	@Path("/t/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateFlightraining(@PathParam("pilot_id") Integer pilot_id, List<Flighttraining> flighttrainingList) {
		return Response.ok(flighttraningservice.updateFlightTraining(pilot_id, flighttrainingList)).build();
	}

	@Override
	@DELETE
	@Path("/t/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteFlightraining(@PathParam("pilot_id") Integer pilot_id, List<Flighttraining> flighttrainingList) {
		return Response.ok(flighttraningservice.deleteFlightTraining(pilot_id, flighttrainingList)).build();
	}

//	飞行检查
	@Override
	@GET
	@Path("/c/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response flightCheckbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return Response.ok(flightcheckservice.getFlightCheckByPilotID(pilot_id)).build();
	}

	@Override
	@POST
	@Path("/c/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newFlightcheck(@PathParam("pilot_id") Integer pilot_id, List<Flightcheck> flightcheckList) {
		return Response.ok(flightcheckservice.newFlightCheck(pilot_id, flightcheckList)).build();
	}

	@Override
	@PUT
	@Path("/c/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateFlightcheck(@PathParam("pilot_id") Integer pilot_id, List<Flightcheck> flightcheckList) {
		return Response.ok(flightcheckservice.updateFlightCheck(pilot_id, flightcheckList)).build();
	}

	@Override
	@DELETE
	@Path("/c/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteFlightcheck(@PathParam("pilot_id") Integer pilot_id, List<Flightcheck> flightcheckList) {
		return Response.ok(flightcheckservice.deleteFlightCheck(pilot_id, flightcheckList)).build();
	}

//	模拟机训练
	@Override
	@GET
	@Path("/s/get/{pilot_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response simulatorTrainingbyPilotid(@PathParam("pilot_id") Integer pilot_id) {
		return Response.ok(simulatortrainingservice.getSimulatorTrainingByPilotID(pilot_id)).build();
	}

	@Override
	@POST
	@Path("/s/new/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newSimulatortraining(@PathParam("pilot_id") Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		return Response.ok(simulatortrainingservice.newSimulatorTraining(pilot_id, simulatortrainingList)).build();
	}

	@Override
	@PUT
	@Path("/s/upd/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateSimulatortraining(@PathParam("pilot_id") Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		return Response.ok(simulatortrainingservice.updateSimulatorTraining(pilot_id, simulatortrainingList)).build();
	}

	@Override
	@DELETE
	@Path("/s/del/{pilot_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteSimulatortraining(@PathParam("pilot_id") Integer pilot_id, List<Simulatortraining> simulatortrainingList) {
		return Response.ok(simulatortrainingservice.deleteSimulatorTraining(pilot_id, simulatortrainingList)).build();
	}

}
