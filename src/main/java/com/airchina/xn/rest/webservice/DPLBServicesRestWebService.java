package com.airchina.xn.rest.webservice;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.airchina.xn.entities.UploadFileEntity;
import com.airchina.xn.model.Aircraft;
import com.airchina.xn.model.Logs;
import com.airchina.xn.model.Parameters;

public interface DPLBServicesRestWebService {

//	根据飞机注册号查询航空器
	public Response getAircraftByRegNo(String regno);
//	根据飞机型别机型查询航空器
	public Response getAircraftByType(String typecatalog, String typeofaircraft);
	public Response getAircraftByType(String typecatalog, String typeofaircraft, Integer pageStart, Integer countPerPage, Integer currentPage);
//	查询所有航空器
	public Response getAllAircraft();
	public Response getAllAircraft(Integer pageStart, Integer countPerPage, Integer currentPage);
//	新增一个航空器
	public Response newAircraft(Aircraft ac);
//	更新一个航空器
	public Response updateAircraft(Aircraft ac);
//	删除一个航空器
	public Response deleteAircraft(Aircraft ac);
	
//	新增一条日志记录
	public Response newLog(Logs l);
//	获取所有日志
	public Response getAllLogs();
	public Response getAllLogs(Integer pageStart, Integer countPerPage, Integer currentPage);
//	查询日志记录
	public Response getLogs(String objectType, Integer objectId, String operation, Integer operatorId);
	public Response getLogs(String objectType, Integer objectId, String operation, Integer operatorId, Integer pageStart, Integer countPerPage, Integer currentPage);
	
	
//	新增一条参数信息
	public Response newParameter(Parameters p);
//	修改一条参数信息
	public Response updateParameter(Parameters p);
//	删除一条参数信息
	public Response deleteParameter(Parameters p);
//	获取所有参数信息
	public Response getParameters();
	public Response getParameters(Integer pageStart, Integer countPerPage, Integer currentPage);
//	获取某一类型的参数信息
	public Response getParametersByType(String parameterType);
	public Response getParametersByType(String parameterType, Integer pageStart, Integer countPerPage, Integer currentPage);
//	获取某个名称的参数信息
	public Response getParametersByName(String parameterName);
	public Response getParametersByName(String parameterName, Integer pageStart, Integer countPerPage, Integer currentPage);
	
//	上传文件
	public Response uploadOneFile(Attachment attachment);
//	删除上传文件
	public Response deleteUploadedFile(UploadFileEntity ufn);
}
