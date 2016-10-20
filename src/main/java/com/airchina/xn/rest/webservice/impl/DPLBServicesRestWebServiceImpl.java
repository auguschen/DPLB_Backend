package com.airchina.xn.rest.webservice.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.utils.FileUtils;
import com.airchina.xn.common.PageParam;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.entities.UploadFIleResp;
import com.airchina.xn.entities.UploadFileEntity;
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
	private static String Upload_Path = FileUtils.getProperties("upload_path");

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
	public Response getAircraftByRegNo(@PathParam("regno") String regno) {
		Aircraft ac = aircraftservice.getAircraftByRegNo(regno);
		return Response.ok( ac != null ? ac : new Aircraft()).build();
	}

	@Override
	@GET
	@Path("/ac/get/{Type_Catalog}&{Type_Of_Aircraft}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAircraftByType(@PathParam("Type_Catalog") String typecatalog,
			@PathParam("Type_Of_Aircraft") String typeofaircraft, @PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		List<Aircraft> acList = aircraftservice.getAircraftByType(typecatalog, typeofaircraft, new PageParam(pageStart, countPerPage, currentPage));
		return Response.ok(acList != null ? acList : new ArrayList<Aircraft>()).build();
	}

	@Override
	@GET
	@Path("/ac/get/{Type_Catalog}&{Type_Of_Aircraft}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAircraftByType(@PathParam("Type_Catalog") String typecatalog,
			@PathParam("Type_Of_Aircraft") String typeofaircraft) {
		List<Aircraft> acList = aircraftservice.getAircraftByType(typecatalog, typeofaircraft);
		return Response.ok(acList != null ? acList : new ArrayList<Aircraft>()).build();
	}

	@Override
	@GET
	@Path("/ac/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllAircraft() {
		logger.info("aircraft get");
		return Response.ok(aircraftservice.getAllAircraft()).build();
	}

	@Override
	@GET
	@Path("/ac/get/{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllAircraft(@PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return Response.ok(aircraftservice.getAllAircraft(new PageParam(pageStart, countPerPage, currentPage))).build();
	}

	@Override
	@POST
	@Path("/ac/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newAircraft(Aircraft ac) {
		return Response.ok(aircraftservice.newAircraft(ac)).build();
	}

	@Override
	@PUT
	@Path("/ac/upd")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateAircraft(Aircraft ac) {
		return Response.ok(aircraftservice.updateAircraft(ac)).build();
	}

	@Override
	@DELETE
	@Path("/ac/del")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAircraft(Aircraft ac) {
		return Response.ok(aircraftservice.deleteAircraft(ac)).build();
	}

//	日志
	@Override
	@POST
	@Path("/logs/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newLog(Logs l) {
		return Response.ok(logservice.newLog(l)).build();
	}

	@Override
	@GET
	@Path("/logs/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllLogs() {
		return Response.ok(logservice.getAllLogs()).build();
	}

	@Override
	@GET
	@Path("/logs/get/{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllLogs(@PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return Response.ok(logservice.getAllLogs(new PageParam(pageStart, countPerPage, currentPage))).build();
	}

	@Override
	@GET
	@Path("/logs/get/{objectType}&{objectId}&{operation}&{operatorId}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLogs(@PathParam("objectType") String objectType, @PathParam("objectId") Integer objectId,
			@PathParam("operation") String operation, @PathParam("operatorId") Integer operatorId,
			@PathParam("pageStart") Integer pageStart, @PathParam("countPerPage") Integer countPerPage,
			@PathParam("currentPage") Integer currentPage) {
		return Response.ok(logservice.getLogs(objectType, objectId, operation, operatorId, new PageParam(pageStart, countPerPage, currentPage))).build();
	}

	@Override
	@GET
	@Path("/logs/get/{objectType}&{objectId}&{operation}&{operatorId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLogs(@PathParam("objectType") String objectType, @PathParam("objectId") Integer objectId,
			@PathParam("operation") String operation, @PathParam("operatorId") Integer operatorId) {
		return Response.ok(logservice.getLogs(objectType, objectId, operation, operatorId)).build();
	}

//	系统参数
	@Override
	@POST
	@Path("/param/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newParameter(Parameters p) {
		return Response.ok(parameterservice.newParameter(p)).build();
	}

	@Override
	@PUT
	@Path("/param/upd")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateParameter(Parameters p) {
		return Response.ok(parameterservice.updateParameter(p)).build();
	}

	@Override
	@DELETE
	@Path("/param/del")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteParameter(Parameters p) {
		return Response.ok(parameterservice.deleteParameter(p)).build();
	}

	@Override
	@GET
	@Path("/param/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getParameters() {
		return Response.ok(parameterservice.getAllParameters()).build();
	}

	@Override
	@GET
	@Path("/param/get/{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getParameters(@PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return Response.ok(parameterservice.getAllParameters(new PageParam(pageStart, countPerPage, currentPage))).build();
	}

	@Override
	@GET
	@Path("/param/get/t/{parametertype}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getParametersByType(@PathParam("parametertype") String parameterType) {
		return Response.ok(parameterservice.getParametersByType(parameterType)).build();
	}

	@Override
	@GET
	@Path("/param/get/t/{parametertype}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getParametersByType(@PathParam("parametertype") String parameterType, @PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return Response.ok(parameterservice.getParametersByType(parameterType, new PageParam(pageStart, countPerPage, currentPage))).build();
	}

	@Override
	@GET
	@Path("/param/get/n/{parametername}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getParametersByName(@PathParam("parametername") String parameterName) {
		return Response.ok(parameterservice.getParametersByName(parameterName)).build();
	}

	@Override
	@GET
	@Path("/param/get/n/{parametername}&{pageStart}&{countPerPage}&{currentPage}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getParametersByName(@PathParam("parametername") String parameterName, @PathParam("pageStart") Integer pageStart,
			@PathParam("countPerPage") Integer countPerPage, @PathParam("currentPage") Integer currentPage) {
		return Response.ok(parameterservice.getParametersByName(parameterName, new PageParam(pageStart, countPerPage, currentPage))).build();
	}

	
	@Override
	@POST
	@Path("/uploadfile")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	@Produces({MediaType.APPLICATION_JSON})
	public Response uploadOneFile(Attachment attachment) {
		UploadFIleResp ufnresp = new UploadFIleResp();	
		DataHandler handler = attachment.getDataHandler();
		try {
			InputStream stream = handler.getInputStream();
			MultivaluedMap<String,String> map = attachment.getHeaders();
			String filename = FileUtils.getFileName(map);
			String filename_uuid = UUID.randomUUID().toString();
			OutputStream out = new FileOutputStream(new File(Upload_Path + filename_uuid));
			UploadFileEntity ufn = new UploadFileEntity(filename, Upload_Path, filename_uuid, stream.available(), FileUtils.getFileExtName(filename));
			Integer read = 0;
			byte[] bytes = new byte[1024];
			while ((read = stream.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}
			stream.close();
			out.flush();
			out.close();
			ufnresp.setUfn(ufn);
			ufnresp.setIsSuccessful(true);
			ufnresp.setReturnCode(0);
		} catch (Exception e) {
			e.printStackTrace();
			Messages returnMessage = new Messages();
			returnMessage.getIsError().add(true);
			returnMessage.getMessages().add(e.getLocalizedMessage());
			ufnresp.setReturnMessage(returnMessage);
		}
		return Response.ok(ufnresp).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@DELETE
	@Path("/delfile")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})	
	public Response deleteUploadedFile(UploadFileEntity ufn) {
		UploadFIleResp ufnresp = new UploadFIleResp();
		File f = new File(ufn.getFilePathOnServer()+ufn.getFileNameOnServer());
		if (f.exists()){
			if (f.delete()){
				ufn.setFileSize(-1);
				ufnresp.setUfn(ufn);
				ufnresp.setIsSuccessful(true);
				ufnresp.setReturnCode(0);
			}else{
				Messages returnMessage = new Messages();
				returnMessage.getIsError().add(true);
				returnMessage.getMessages().add("can't delete.");
				ufnresp.setReturnMessage(returnMessage);
			}
		}else {
			Messages returnMessage = new Messages();
			returnMessage.getIsError().add(true);
			returnMessage.getMessages().add("file not exists.");
			ufnresp.setReturnMessage(returnMessage);
		}
		return Response.ok(ufnresp).header("Access-Control-Allow-Origin", "*").build();
	}

}
