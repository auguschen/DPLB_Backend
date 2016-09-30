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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.common.PageParam;
import com.airchina.xn.model.Aircraft;
import com.airchina.xn.model.Logs;
import com.airchina.xn.model.Parameters;
import com.airchina.xn.rest.webservice.DPLBServicesRestWebService;
import com.airchina.xn.service.AircraftService;
import com.airchina.xn.service.LogService;
import com.airchina.xn.service.ParameterService;

@Service("dplbServicesRestWebService")
@Path("/")
public class DPLBServicesRestWebServiceImpl implements DPLBServicesRestWebService {

	private static Logger logger = Logger.getLogger(DPLBServicesRestWebServiceImpl.class);

	@Autowired
	private AircraftService aircraftservice;

	@Autowired
	private ParameterService parameterservice;

	@Autowired
	private LogService logservice;

	public LogService getLogservice() {
		return logservice;
	}

	public void setLogservice(LogService logservice) {
		this.logservice = logservice;
	}

	public ParameterService getParameterservice() {
		return parameterservice;
	}

	public void setParameterservice(ParameterService parameterservice) {
		this.parameterservice = parameterservice;
	}

	public AircraftService getAircraftservice() {
		return aircraftservice;
	}

	public void setAircraftservice(AircraftService aircraftservice) {
		this.aircraftservice = aircraftservice;
	}

//	航空器
	@Override
	@GET
	@Path("/ac/get/{regno}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Aircraft getAircraftByRegNo(@PathParam("regno") String regno) {
		Aircraft ac = aircraftservice.getAircraftByRegNo(regno);
		return ac != null ? ac : new Aircraft();
	}

	@Override
	@GET
	@Path("/ac/get/{Type_Catalog}&{Type_Of_Aircraft}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Aircraft> getAircraftByType(@PathParam("Type_Catalog") String typecatalog,
			@PathParam("Type_Of_Aircraft") String typeofaircraft, @PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		List<Aircraft> acList = aircraftservice.getAircraftByType(typecatalog, typeofaircraft, new PageParam(pageStart, countPerPage, currentPage));
		return acList != null ? acList : new ArrayList<Aircraft>();
	}

	@Override
	@GET
	@Path("/ac/get/{Type_Catalog}&{Type_Of_Aircraft}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Aircraft> getAircraftByType(@PathParam("Type_Catalog") String typecatalog,
			@PathParam("Type_Of_Aircraft") String typeofaircraft) {
		List<Aircraft> acList = aircraftservice.getAircraftByType(typecatalog, typeofaircraft);
		return acList != null ? acList : new ArrayList<Aircraft>();
	}

	@Override
	@GET
	@Path("/ac/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Aircraft> getAllAircraft() {
		logger.info("aircraft get");
		return aircraftservice.getAllAircraft();
	}

	@Override
	@GET
	@Path("/ac/get/{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Aircraft> getAllAircraft(@PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return aircraftservice.getAllAircraft(new PageParam(pageStart, countPerPage, currentPage));
	}

	@Override
	@POST
	@Path("/ac/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Aircraft newAircraft(Aircraft ac) {
		return aircraftservice.newAircraft(ac);
	}

	@Override
	@PUT
	@Path("/ac/upd")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Aircraft updateAircraft(Aircraft ac) {
		return aircraftservice.updateAircraft(ac);
	}

	@Override
	@DELETE
	@Path("/ac/del")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Boolean deleteAircraft(Aircraft ac) {
		return aircraftservice.deleteAircraft(ac);
	}

//	日志
	@Override
	@POST
	@Path("/logs/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Boolean newLog(Logs l) {
		return logservice.newLog(l);
	}

	@Override
	@GET
	@Path("/logs/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Logs> getAllLogs() {
		return logservice.getAllLogs();
	}

	@Override
	@GET
	@Path("/logs/get/{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Logs> getAllLogs(@PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return logservice.getAllLogs(new PageParam(pageStart, countPerPage, currentPage));
	}

	@Override
	@GET
	@Path("/logs/get/{objectType}&{objectId}&{operation}&{operatorId}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Logs> getLogs(@PathParam("objectType") String objectType, @PathParam("objectId") Integer objectId,
			@PathParam("operation") String operation, @PathParam("operatorId") Integer operatorId,
			@PathParam("pageStart") Integer pageStart, @PathParam("countPerPage") Integer countPerPage,
			@PathParam("currentPage") Integer currentPage) {
		return logservice.getLogs(objectType, objectId, operation, operatorId, new PageParam(pageStart, countPerPage, currentPage));
	}

	@Override
	@GET
	@Path("/logs/get/{objectType}&{objectId}&{operation}&{operatorId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Logs> getLogs(@PathParam("objectType") String objectType, @PathParam("objectId") Integer objectId,
			@PathParam("operation") String operation, @PathParam("operatorId") Integer operatorId) {
		return logservice.getLogs(objectType, objectId, operation, operatorId);
	}

//	系统参数
	@Override
	@POST
	@Path("/param/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Parameters newParameter(Parameters p) {
		return parameterservice.newParameter(p);
	}

	@Override
	@PUT
	@Path("/param/upd")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Parameters updateParameter(Parameters p) {
		return parameterservice.updateParameter(p);
	}

	@Override
	@DELETE
	@Path("/param/del")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Boolean deleteParameter(Parameters p) {
		return parameterservice.deleteParameter(p);
	}

	@Override
	@GET
	@Path("/param/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameters> getParameters() {
		return parameterservice.getAllParameters();
	}

	@Override
	@GET
	@Path("/param/get/{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameters> getParameters(@PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return parameterservice.getAllParameters(new PageParam(pageStart, countPerPage, currentPage));
	}

	@Override
	@GET
	@Path("/param/get/t/{parametertype}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameters> getParametersByType(@PathParam("parametertype") String parameterType) {
		return parameterservice.getParametersByType(parameterType);
	}

	@Override
	@GET
	@Path("/param/get/t/{parametertype}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameters> getParametersByType(@PathParam("parametertype") String parameterType, @PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return parameterservice.getParametersByType(parameterType, new PageParam(pageStart, countPerPage, currentPage));
	}

	@Override
	@GET
	@Path("/param/get/n/{parametername}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameters> getParametersByName(@PathParam("parametername") String parameterName) {
		return parameterservice.getParametersByName(parameterName);
	}

	@Override
	@GET
	@Path("/param/get/n/{parametername}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameters> getParametersByName(@PathParam("parametername") String parameterName, @PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return parameterservice.getParametersByName(parameterName, new PageParam(pageStart, countPerPage, currentPage));
	}

}
